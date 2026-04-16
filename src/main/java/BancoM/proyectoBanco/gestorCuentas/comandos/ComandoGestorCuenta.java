package BancoM.proyectoBanco.gestorCuentas.comandos;

import BancoM.proyectoBanco.banco.servicios.ServicioGestorCuentas;
import BancoM.proyectoBanco.usuarios.PerfilUsuario;

public abstract class ComandoGestorCuenta {
    protected ServicioGestorCuentas servicioGestorCuentas;
    protected PerfilUsuario perfilUsuarioGestorCuentas;

    public ComandoGestorCuenta(ServicioGestorCuentas servicioGestorCuentas, PerfilUsuario perfilUsuarioGestorCuentas) {
        this.servicioGestorCuentas = servicioGestorCuentas;
        this.perfilUsuarioGestorCuentas = perfilUsuarioGestorCuentas;
    }

    public abstract void ejecutar();
}
