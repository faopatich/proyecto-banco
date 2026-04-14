package proyectoBanco.banco;

import proyectoBanco.usuarios.PerfilUsuario;

public class ServicioBanco {
    private final PerfilUsuario perfilUsuario;

    public ServicioBanco(PerfilUsuario perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    public void solicitarCrearCuenta() {}
    public void solicitarEliminarCuenta() {}

    public /* Cuenta */ void obtenerEstadoCuenta() {}

    public void depositar(int cantidad) {}
    public void retirar(int cantidad) {}
    public void transferir(String receptor, int cantidad) {}
}
