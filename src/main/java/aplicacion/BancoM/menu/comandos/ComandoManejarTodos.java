package aplicacion.BancoM.menu.comandos;

import aplicacion.BancoM.banco.servicios.ServicioGestorCuentas;
import aplicacion.BancoM.usuarios.PerfilUsuario;

public class ComandoManejarTodos extends ComandoGestorCuenta {
    public ComandoManejarTodos(ServicioGestorCuentas servicioGestorCuentas, PerfilUsuario perfilUsuarioGestorCuentas) {
        super(servicioGestorCuentas, perfilUsuarioGestorCuentas);
    }

    private Integer obtenerCodigo(String vistaComando) {
        return Integer.parseInt(vistaComando.split("Código: ")[1]);
    }

    @Override
    public void ejecutar() {
        var operacionesPendientes = super.servicioGestorCuentas.obtenerVistaOperacionesPendientes(
                this.perfilUsuarioGestorCuentas.generarCredenciales()
        );
        for (var operacion : operacionesPendientes) {
            this.servicioGestorCuentas.resolverOperacion(
                    this.perfilUsuarioGestorCuentas.generarCredenciales(),
                    this.obtenerCodigo(operacion)
            );
        }
    }
}
