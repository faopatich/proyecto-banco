package aplicacion.BancoM.banco;

import aplicacion.BancoM.cuentas.TipoCuenta;
import aplicacion.BancoM.menu.BancoMMenuCliente;
import aplicacion.BancoM.menu.BancoMMenuGestorCuentas;
import aplicacion.BancoM.menu.comandos.gestor.FabricaComandoGestorCuentas;
import aplicacion.BancoM.menu.comandos.FabricaComandoMenu;
import aplicacion.BancoM.usuarios.CredencialesUsuario;
import aplicacion.BancoM.usuarios.PerfilUsuario;
import aplicacion.BancoM.usuarios.RolUsuario;
import aplicacion.interfazComun.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BancoM implements Banco {
    private final Map<String, Sucursal> sucursales;

    private CredencialesUsuario crearCredenciales(Credenciales credenciales) {
        return new CredencialesUsuario(
                credenciales.usuario(),
                credenciales.contr()
        );
    }

    private Menu obtenerMenu(Sucursal sucursal, PerfilUsuario perfilUsuario, Set<RolUsuario> rolesUsuario) {
        Menu menu = null;
        if (rolesUsuario.contains(RolUsuario.GestorCuentas)) {
            if (!sucursal.gestorUsuariosConcurrente.verificarGestorDeSucursal(perfilUsuario.generarCredenciales(), sucursal.codigo)) {
                return null;
            }
            FabricaComandoMenu fabricaComandoMenu = new FabricaComandoGestorCuentas(
                    sucursal.servicioGestorCuentas,
                    perfilUsuario
            );
            menu = new BancoMMenuGestorCuentas(fabricaComandoMenu);
        } else if (rolesUsuario.contains(RolUsuario.Cliente)) {
            menu = new BancoMMenuCliente(sucursal, perfilUsuario);
        }
        return menu;
    }

    private Sucursal obtenerCualquierSucursal() {
        return new Sucursal("");
    }

    public BancoM() {
        this.sucursales = new HashMap<>();
    }

    public void agregaSucursal(String codigoSucursal) {
        if (this.sucursales.containsKey(codigoSucursal)) {
            return;
        }
        var sucursal = new Sucursal(codigoSucursal);
        this.sucursales.put(codigoSucursal, sucursal);
        AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> bdd.sucursales.add(sucursal.codigo)
        );
    }
    public Sucursal obtenerSucursal(String codigoSucursal) {
        return this.sucursales.get(codigoSucursal);
    }
    public void agregarCliente(PerfilUsuario perfilUsuario) {
        this.obtenerCualquierSucursal()
                .gestorUsuariosConcurrente
                .agregarUsuarioSiNoExiste(
                        perfilUsuario,
                        Set.of(RolUsuario.Cliente)
                );
    }
    public void agregarGestorCuentas(PerfilUsuario perfilUsuario, String codigoSucursal) {
        var gestorUsuarios = this.obtenerSucursal(codigoSucursal).gestorUsuariosConcurrente;
        var credenciales = perfilUsuario.generarCredenciales();
        gestorUsuarios.agregarUsuarioSiNoExiste(perfilUsuario, Set.of(RolUsuario.GestorCuentas));
        if (!gestorUsuarios.asignarSucursalDeGestor(credenciales, codigoSucursal)) {
            gestorUsuarios.eliminarRolDeUsuarioSiExiste(credenciales, RolUsuario.GestorCuentas);
        }
    }
    public void agregarCuenta(CredencialesUsuario credencialesUsuario, TipoCuenta tipoCuenta) {
        this.obtenerCualquierSucursal()
                .gestorCuentasConcurrente
                .crearCuenta(credencialesUsuario.usuario(), tipoCuenta);
    }

    @Override
    public Menu login(Credenciales credenciales, String codigoSucursal) {
        var credecialesUsuario = this.crearCredenciales(credenciales);
        var sucursal = this.obtenerSucursal(codigoSucursal);
        if (sucursal == null) {
            return null;
        }
        if (!sucursal.gestorUsuariosConcurrente.verificarCredencialesUsuario(credecialesUsuario)) {
            return null;
        }
        var perfilUsuario = sucursal.servicioUsuario.obtenerPerfilDeUsuario(credecialesUsuario);
        var rolesUsuario = sucursal.servicioUsuario.obtenerRolesDeUsuario(credecialesUsuario);

        if (perfilUsuario == null || rolesUsuario == null) {
            return null;
        }
        return this.obtenerMenu(sucursal, perfilUsuario, rolesUsuario);
    }

    @Override
    public Cuenta obtenerCuenta(String numeroCuenta) {
        var sucursal = this.obtenerCualquierSucursal();
        try {
            return sucursal.servicioGestorCuentas.obtenerCuenta(Integer.parseInt(numeroCuenta));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
