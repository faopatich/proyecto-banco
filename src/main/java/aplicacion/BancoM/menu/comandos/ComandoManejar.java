package aplicacion.BancoM.menu.comandos;

import aplicacion.BancoM.banco.servicios.ServicioGestorCuentas;
import aplicacion.BancoM.usuarios.PerfilUsuario;

public class ComandoManejar implements ComandoMenu {
    private final ServicioGestorCuentas servicioGestorCuentas;
    private final PerfilUsuario perfilUsuario;
    private final Integer codigo;

    public ComandoManejar(
            ServicioGestorCuentas servicioGestorCuentas,
            PerfilUsuario perfilUauario,
            Integer codigo
    ) {
        this.servicioGestorCuentas = servicioGestorCuentas;
        this.perfilUsuario = perfilUauario;
        this.codigo = codigo;
    }

    @Override
    public void ejecutar() {
        this.servicioGestorCuentas.resolverOperacion(
                this.perfilUsuario.generarCredenciales(),
                this.codigo
        );
    }
}
