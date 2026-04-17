package aplicacion.BancoM.menu.comandos.gestor;

import aplicacion.BancoM.banco.servicios.ServicioGestorCuentas;
import aplicacion.BancoM.menu.comandos.ComandoMenu;
import aplicacion.BancoM.usuarios.PerfilUsuario;

public class ComandoListar implements ComandoMenu {
    private final ServicioGestorCuentas servicioGestorCuentas;
    private final PerfilUsuario perfilUsuario;

    public ComandoListar(ServicioGestorCuentas servicioGestorCuentas, PerfilUsuario perfilUsuario) {
        this.servicioGestorCuentas = servicioGestorCuentas;
        this.perfilUsuario = perfilUsuario;
    }

    @Override
    public void ejecutar() {
        var operacionesPendientes = this.servicioGestorCuentas.obtenerVistaOperacionesPendientes(
                this.perfilUsuario.generarCredenciales()
        );
        if (operacionesPendientes.isEmpty()) {
            System.out.println("Sin operaciones pendientes\n");
        } else {
            System.out.println("Operaciones pendientes:");
        }
        for (var operacion : operacionesPendientes) {
            System.out.println(operacion);
        }
    }
}
