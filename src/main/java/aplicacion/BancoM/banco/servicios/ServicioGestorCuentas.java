package aplicacion.BancoM.banco.servicios;

import aplicacion.BancoM.banco.concurrencia.GestorUsuariosConcurrente;
import aplicacion.BancoM.cuentas.Cuenta;
import aplicacion.BancoM.cuentas.TipoCuenta;
import aplicacion.BancoM.usuarios.CredencialesUsuario;
import aplicacion.BancoM.usuarios.PerfilUsuario;

import java.util.List;

public class ServicioGestorCuentas extends ServicioProtegido {
    private final ServicioGestionCuentas servicioGestionCuentas;

    public ServicioGestorCuentas(GestorUsuariosConcurrente gestorUsuarios, ServicioGestionCuentas servicioGestionCuentas) {
        super(gestorUsuarios);
        this.servicioGestionCuentas = servicioGestionCuentas;
    }

    public boolean crearCuenta(
            CredencialesUsuario credenciales,
            PerfilUsuario perfilUsuario,
            TipoCuenta tipoCuenta
    ) {
        if (super.credencialesInvalidas(credenciales)) {
            return false;
        }
        return this.servicioGestionCuentas.crearCuenta(perfilUsuario.generarCredenciales(), tipoCuenta);
    }
    public boolean eliminarCuenta(CredencialesUsuario credenciales, PerfilUsuario perfilUsuario) {
        if (super.credencialesInvalidas(credenciales)) {
            return false;
        }
        return this.servicioGestionCuentas.eliminarCuenta(perfilUsuario.generarCredenciales());
    }
    public Cuenta obtenerCuenta(int numeroCuenta) {
        return this.servicioGestionCuentas.obtenerCuenta(numeroCuenta);
    }
    public List<String> obtenerVistaOperacionesPendientes(CredencialesUsuario credenciales) {
        if (super.credencialesInvalidas(credenciales)) {
            return null;
        }
        return this.servicioGestionCuentas.obtenerVistaOperacionesPendientes();
    }
    public boolean resolverOperacion(CredencialesUsuario credenciales, Integer codigo) {
        if (super.credencialesInvalidas(credenciales)) {
            return false;
        }
        this.servicioGestionCuentas.resolverOperacion(codigo);
        return true;
    }
}
