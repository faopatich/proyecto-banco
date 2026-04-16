package BancoM.proyectoBanco.gestorCuentas.comandos;

import BancoM.proyectoBanco.banco.servicios.ServicioGestorCuentas;
import BancoM.proyectoBanco.usuarios.PerfilUsuario;

public class ComandoSalir extends ComandoGestorCuenta {
    public ComandoSalir(ServicioGestorCuentas servicioGestorCuentas, PerfilUsuario perfilUsuarioGestorCuentas) {
        super(servicioGestorCuentas, perfilUsuarioGestorCuentas);
    }

    @Override
    public void ejecutar() {}
}
