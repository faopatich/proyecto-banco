package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;

public class Usuario {
    protected final ServicioBanco servicioBanco;
    protected final PerfilUsuario perfilUsuario;

    public Usuario(ServicioBanco servicioBanco, PerfilUsuario perfilUsuario) {
        this.servicioBanco = servicioBanco;
        this.perfilUsuario = perfilUsuario;
    }
}
