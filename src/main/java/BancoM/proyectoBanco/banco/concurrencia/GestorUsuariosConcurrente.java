package BancoM.proyectoBanco.banco.concurrencia;

import BancoM.proyectoBanco.banco.AccesoBaseDeDatos;
import BancoM.proyectoBanco.banco.GestorUsuarios;
import BancoM.proyectoBanco.usuarios.CredencialesUsuario;
import BancoM.proyectoBanco.usuarios.PerfilUsuario;
import BancoM.proyectoBanco.usuarios.RolUsuario;

import java.util.Set;

public class GestorUsuariosConcurrente {
    private final GestorUsuarios gestorUsuarios;

    public GestorUsuariosConcurrente(GestorUsuarios gestorUsuarios) {
        this.gestorUsuarios = gestorUsuarios;
    }

    public boolean verificarCredencialesUsuario(CredencialesUsuario credencialesUsuario) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorUsuarios.verificarCredencialesUsuario(bdd, credencialesUsuario)
        );
    }
    public boolean agregarUsuarioSiNoExiste(PerfilUsuario perfilUsuario, Set<RolUsuario> rolesUsuario) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorUsuarios.agregarUsuarioSiNoExiste(bdd, perfilUsuario, rolesUsuario)
        );
    }
    public boolean eliminarRolDeUsuarioSiExiste(CredencialesUsuario credencialesUsuario, RolUsuario rolUsuario) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorUsuarios.eliminarRolDeUsuarioSiExiste(bdd, credencialesUsuario, rolUsuario)
        );
    }
}
