package BancoM.proyectoBanco.banco.servicios;

import BancoM.proyectoBanco.banco.concurrencia.GestorUsuariosConcurrente;
import BancoM.proyectoBanco.usuarios.CredencialesUsuario;

public class ServicioProtegido {
    protected GestorUsuariosConcurrente gestorUsuariosConcurrente;

    protected ServicioProtegido(GestorUsuariosConcurrente gestorUsuarios) {
        this.gestorUsuariosConcurrente = gestorUsuarios;
    }

    protected boolean credencialesInvalidas(CredencialesUsuario credencialesUsuario) {
        return !this.gestorUsuariosConcurrente.verificarCredencialesUsuario(credencialesUsuario);
    }
}
