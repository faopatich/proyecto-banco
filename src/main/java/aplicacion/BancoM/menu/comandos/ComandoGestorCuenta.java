package aplicacion.BancoM.menu.comandos;

import aplicacion.BancoM.banco.servicios.ServicioGestorCuentas;
import aplicacion.BancoM.usuarios.PerfilUsuario;

public abstract class ComandoGestorCuenta implements ComandoMenu {
    protected ServicioGestorCuentas servicioGestorCuentas;
    protected PerfilUsuario perfilUsuarioGestorCuentas;

    public ComandoGestorCuenta(ServicioGestorCuentas servicioGestorCuentas, PerfilUsuario perfilUsuarioGestorCuentas) {
        this.servicioGestorCuentas = servicioGestorCuentas;
        this.perfilUsuarioGestorCuentas = perfilUsuarioGestorCuentas;
    }

    public abstract void ejecutar();
}
