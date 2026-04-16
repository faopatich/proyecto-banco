package aplicacion.BancoM.banco;

import aplicacion.BancoM.cuentas.Cuenta;
import aplicacion.BancoM.usuarios.PerfilUsuario;
import aplicacion.BancoM.usuarios.RolUsuario;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BaseDeDatos {
    public final Map<String, Cuenta> cuentas;
    public final Map<String, PerfilUsuario> perfiles;
    public final Map<String, Set<RolUsuario>> roles;

    BaseDeDatos() {
        this.cuentas = new HashMap<>();
        this.perfiles = new HashMap<>();
        this.roles = new HashMap<>();
    }
}
