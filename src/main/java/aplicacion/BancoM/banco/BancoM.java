package aplicacion.BancoM.banco;

import aplicacion.BancoM.menu.BancoMMenuCliente;
import aplicacion.BancoM.menu.BancoMMenuGestorCuentas;
import aplicacion.BancoM.menu.comandos.FabricaComandoCliente;
import aplicacion.BancoM.menu.comandos.FabricaComandoGestorCuentas;
import aplicacion.BancoM.menu.comandos.FabricaComandoMenu;
import aplicacion.BancoM.menu.comandos.ServicioComandoMenu;
import aplicacion.BancoM.usuarios.CredencialesUsuario;
import aplicacion.BancoM.usuarios.PerfilUsuario;
import aplicacion.BancoM.usuarios.RolUsuario;
import aplicacion.interfazComun.Banco;
import aplicacion.interfazComun.Credenciales;
import aplicacion.interfazComun.Menu;
import aplicacion.interfazComun.ServicioEntrada;

import java.util.Scanner;
import java.util.Set;

public class BancoM implements Banco {
    public final Sucursal sucursal;

    private CredencialesUsuario crearCredenciales(Credenciales credenciales) {
        return new CredencialesUsuario(
                credenciales.usuario(),
                credenciales.contr()
        );
    }

    private Menu obtenerMenu(PerfilUsuario perfilUsuario, Set<RolUsuario> rolesUsuario) {
        Menu menu = null;
        Scanner scanner = new Scanner(System.in);
        ServicioEntrada servicioEntrada = new ServicioEntrada(scanner);
        FabricaComandoMenu fabricaComandoMenu;
        ServicioComandoMenu servicioComandoMenu;
        if (rolesUsuario.contains(RolUsuario.GestorCuentas)) {
            fabricaComandoMenu = new FabricaComandoGestorCuentas(
                    this.sucursal.servicioGestorCuentas,
                    perfilUsuario
            );
            servicioComandoMenu = new ServicioComandoMenu(servicioEntrada, fabricaComandoMenu);
            menu = new BancoMMenuGestorCuentas(servicioComandoMenu);
        } else if (rolesUsuario.contains(RolUsuario.Cliente)) {
            fabricaComandoMenu = new FabricaComandoCliente();
            servicioComandoMenu = new ServicioComandoMenu(servicioEntrada, fabricaComandoMenu);
            menu = new BancoMMenuCliente(servicioComandoMenu);
        }
        return menu;
    }

    public BancoM() {
        this.sucursal = new Sucursal();
    }

    @Override
    public Menu login(Credenciales credenciales) {
        var credecialesUsuario = this.crearCredenciales(credenciales);
        var perfilUsuario = this.sucursal.servicioUsuario.obtenerPerfilDeUsuario(credecialesUsuario);
        var rolesUsuario = this.sucursal.servicioUsuario.obtenerRolesDeUsuario(credecialesUsuario);

        if (perfilUsuario == null || rolesUsuario == null) {
            return null;
        }
        return this.obtenerMenu(perfilUsuario, rolesUsuario);
    }
}
