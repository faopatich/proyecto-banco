package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;

public class UsuarioGestorCuentas extends Usuario {
    public UsuarioGestorCuentas(ServicioBanco servicioBanco, CredencialesUsuario credencialesUsuario) {
        super(servicioBanco, credencialesUsuario);
    }

    public void verOperacionesPendientes() {}
    public boolean crearCuenta() {
        return false;
    }
    public boolean eliminarCuenta() {
        return false;
    }
}
