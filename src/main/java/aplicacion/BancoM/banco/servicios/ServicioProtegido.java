package aplicacion.BancoM.banco.servicios;

import aplicacion.BancoM.banco.concurrencia.GestorUsuariosConcurrente;
import aplicacion.BancoM.usuarios.CredencialesUsuario;

public class ServicioProtegido {
    protected GestorUsuariosConcurrente gestorUsuariosConcurrente;

    protected ServicioProtegido(GestorUsuariosConcurrente gestorUsuarios) {
        this.gestorUsuariosConcurrente = gestorUsuarios;
    }

    protected boolean credencialesInvalidas(CredencialesUsuario credencialesUsuario) {
        return !this.gestorUsuariosConcurrente.verificarCredencialesUsuario(credencialesUsuario);
    }
}
