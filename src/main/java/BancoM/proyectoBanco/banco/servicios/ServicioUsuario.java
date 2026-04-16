package BancoM.proyectoBanco.banco.servicios;

import BancoM.proyectoBanco.banco.concurrencia.GestorUsuariosConcurrente;
import BancoM.proyectoBanco.usuarios.PerfilUsuario;
import BancoM.proyectoBanco.usuarios.RolUsuario;

import java.util.Set;

public class ServicioUsuario {
    private final GestorUsuariosConcurrente gestorUsuariosConcurrente;

    public ServicioUsuario(GestorUsuariosConcurrente gestorUsuariosConcurrente) {
        this.gestorUsuariosConcurrente = gestorUsuariosConcurrente;
    }

    public boolean crearUsuarioSiNoExiste(PerfilUsuario perfilUsuario, Set<RolUsuario> roles) {
        return this.gestorUsuariosConcurrente.agregarUsuarioSiNoExiste(perfilUsuario, roles);
    }
    public boolean eliminarRolDeUsuarioSiExiste(PerfilUsuario perfilUsuario, RolUsuario rolUsuario) {
        return this.gestorUsuariosConcurrente.eliminarRolDeUsuarioSiExiste(
                perfilUsuario.generarCredenciales(),
                rolUsuario
        );
    }
}
