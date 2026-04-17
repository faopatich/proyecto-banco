package aplicacion.BancoM.banco.concurrencia;

import aplicacion.BancoM.banco.AccesoBaseDeDatos;
import aplicacion.BancoM.banco.gestores.GestorUsuarios;
import aplicacion.BancoM.usuarios.CredencialesUsuario;
import aplicacion.BancoM.usuarios.PerfilUsuario;
import aplicacion.BancoM.usuarios.RolUsuario;

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
    public boolean verificarGestorDeSucursal(CredencialesUsuario credencialesUsuario, String codigoSucursal) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorUsuarios.verificarGestorDeSucursal(bdd, credencialesUsuario, codigoSucursal)
        );
    }
    public boolean agregarUsuarioSiNoExiste(PerfilUsuario perfilUsuario, Set<RolUsuario> rolesUsuario) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorUsuarios.agregarUsuarioSiNoExiste(bdd, perfilUsuario, rolesUsuario)
        );
    }
    public boolean asignarSucursalDeGestor(CredencialesUsuario credencialesUsuario, String codigoSucursal) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorUsuarios.asignarSucursalDeGestor(bdd, credencialesUsuario, codigoSucursal)
        );
    }
    public boolean eliminarRolDeUsuarioSiExiste(CredencialesUsuario credencialesUsuario, RolUsuario rolUsuario) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorUsuarios.eliminarRolDeUsuarioSiExiste(bdd, credencialesUsuario, rolUsuario)
        );
    }
    public PerfilUsuario obtenerPerfilDeUsuario(CredencialesUsuario credencialesUsuario) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorUsuarios.obtenerPrefilDeUsuario(bdd, credencialesUsuario)
        );
    }
    public Set<RolUsuario> obtenerRolesDeUsuario(CredencialesUsuario credencialesUsuario) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorUsuarios.obtenerRolesDeUsuario(bdd, credencialesUsuario)
        );
    }
}
