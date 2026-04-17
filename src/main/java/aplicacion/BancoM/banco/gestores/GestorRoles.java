package aplicacion.BancoM.banco.gestores;

import aplicacion.BancoM.usuarios.RolUsuario;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GestorRoles {
    public GestorRoles() {}

    public void agregarRolesDeUsuario(Map<String, Set<RolUsuario>> roles, String nombre, Set<RolUsuario> rolesUsuario) {
        if (!roles.containsKey(nombre)) {
            roles.put(nombre, new HashSet<>(rolesUsuario));
        } else {
            roles.get(nombre).addAll(rolesUsuario);
        }
    }
    public void eliminarRolDeUsuario(Map<String, Set<RolUsuario>> roles, String nombre, RolUsuario rolUsuario) {
        var rolesActuales = roles.get(nombre);
        if (rolesActuales == null || rolesActuales.isEmpty()) {
            return;
        }
        rolesActuales.remove(rolUsuario);
        if (rolesActuales.isEmpty()) {
            roles.remove(nombre);
        }
    }
    public boolean verificarUsuarioTieneRol(Map<String, Set<RolUsuario>> roles, String nombre, RolUsuario rol) {
        var rolesUsuario = roles.get(nombre);
        if (rolesUsuario == null) {
            return false;
        }
        return rolesUsuario.contains(rol);
    }
    public boolean verificarUsuarioTieneRoles(Map<String, Set<RolUsuario>> roles, String nombre) {
        return roles.containsKey(nombre);
    }
}
