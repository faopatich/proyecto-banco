package proyectoBanco.banco;

import proyectoBanco.usuarios.CredencialesUsuario;
import proyectoBanco.usuarios.RolUsuario;

import java.util.HashMap;
import java.util.Set;

public class GestorRoles {
    private final HashMap<String, Set<RolUsuario>> rolesUsuario;

    public GestorRoles() {
        this.rolesUsuario = new HashMap<>();
    }

    public void agregarRolesDeUsuario(String nombre, Set<RolUsuario> rolesUsuario) {
        if (!this.rolesUsuario.containsKey(nombre)) {
            this.rolesUsuario.put(nombre, rolesUsuario);
        } else {
            this.rolesUsuario.get(nombre).addAll(rolesUsuario);
        }
    }
    public boolean verificarUsuarioConCredenciales(String usuario, RolUsuario rolUsuario) {
        var roles = this.rolesUsuario.get(usuario);
        if (roles == null || roles.isEmpty()) {
            return false;
        }
        return roles.contains(rolUsuario);
    }
}
