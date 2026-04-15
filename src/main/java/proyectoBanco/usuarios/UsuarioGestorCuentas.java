package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.cuentas.TipoCuenta;

public class UsuarioGestorCuentas extends Usuario {
    public UsuarioGestorCuentas(ServicioBanco servicioBanco, PerfilUsuario perfilUsuario) {
        super(servicioBanco, perfilUsuario);
    }

    public boolean crearCuenta(PerfilUsuario perfilUsuario, TipoCuenta tipoCuenta) {
        return this.servicioBanco.crearCuenta(super.perfilUsuario.generarCredenciales(), perfilUsuario, tipoCuenta);
    }
    public boolean eliminarCuenta(PerfilUsuario perfilUsuario) {
        return this.servicioBanco.eliminarCuenta(super.perfilUsuario.generarCredenciales(), perfilUsuario);
    }
    public void verOperacionesPendientes() {
        var operacionesPendientes = this.servicioBanco.obtenerOperacionesPendientes(super.perfilUsuario.generarCredenciales());
        if (operacionesPendientes == null) {
            return;
        }
        System.out.println("\nOperaciones pendientes:");
        for (var operacion: operacionesPendientes) {
            System.out.println(operacion);
        }
    }
    public boolean resolverOperacion(int indice) {
        return this.servicioBanco.resolverOperacion(super.perfilUsuario.generarCredenciales(), indice);
    }
}
