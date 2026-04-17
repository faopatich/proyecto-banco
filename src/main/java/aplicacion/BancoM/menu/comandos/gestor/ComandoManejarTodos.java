package aplicacion.BancoM.menu.comandos.gestor;

import aplicacion.BancoM.banco.servicios.ServicioGestorCuentas;
import aplicacion.BancoM.menu.comandos.ComandoMenu;
import aplicacion.BancoM.usuarios.PerfilUsuario;

public class ComandoManejarTodos implements ComandoMenu {
    private final ServicioGestorCuentas servicioGestorCuentas;
    private final PerfilUsuario perfilUsuario;

    public ComandoManejarTodos(ServicioGestorCuentas servicioGestorCuentas, PerfilUsuario perfilUsuario) {
        this.servicioGestorCuentas = servicioGestorCuentas;
        this.perfilUsuario = perfilUsuario;
    }

    private Integer obtenerCodigo(String vistaComando) {
        return Integer.parseInt(vistaComando.split("Código: ")[1]);
    }

    @Override
    public void ejecutar() {
        var operacionesPendientes = this.servicioGestorCuentas.obtenerVistaOperacionesPendientes(
                this.perfilUsuario.generarCredenciales()
        );
        for (var operacion : operacionesPendientes) {
            this.servicioGestorCuentas.resolverOperacion(
                    this.perfilUsuario.generarCredenciales(),
                    this.obtenerCodigo(operacion)
            );
        }
    }
}
