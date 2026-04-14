package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.cuentas.TipoCuenta;

public class UsuarioGestorCuentas extends Usuario {
    public UsuarioGestorCuentas(ServicioBanco servicioBanco, CredencialesUsuario credencialesUsuario) {
        super(servicioBanco, credencialesUsuario);
    }

    public boolean crearCuenta(PerfilUsuario perfilUsuario, TipoCuenta tipoCuenta) {
        return this.servicioBanco.crearCuenta(this.credencialesUsuario, perfilUsuario, tipoCuenta);
    }
    public boolean eliminarCuenta(PerfilUsuario perfilUsuario) {
        return this.servicioBanco.eliminarCuenta(this.credencialesUsuario, perfilUsuario);
    }
    public void verOperacionesPendientes() {
        var operacionesPendientes = this.servicioBanco.obtenerOperacionesPendientes(this.credencialesUsuario);
        if (operacionesPendientes == null) {
            return;
        }
        System.out.println("\nOperaciones pendientes:");
        for (var operacion: operacionesPendientes) {
            System.out.println(operacion);
        }
    }
    public boolean resolverOperacion(int indice) {
        return this.servicioBanco.resolverOperacion(this.credencialesUsuario, indice);
    }
}
