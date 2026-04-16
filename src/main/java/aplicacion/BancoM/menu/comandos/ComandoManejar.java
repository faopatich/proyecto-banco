package aplicacion.BancoM.menu.comandos;

import aplicacion.BancoM.banco.servicios.ServicioGestorCuentas;
import aplicacion.BancoM.usuarios.PerfilUsuario;

public class ComandoManejar extends ComandoGestorCuenta {
    private final Integer codigo;

    public ComandoManejar(
            ServicioGestorCuentas servicioGestorCuentas,
            PerfilUsuario perfilUsuarioGestorCuentas,
            Integer codigo
    ) {
        super(servicioGestorCuentas, perfilUsuarioGestorCuentas);
        this.codigo = codigo;
    }

    @Override
    public void ejecutar() {
        super.servicioGestorCuentas.resolverOperacion(
                super.perfilUsuarioGestorCuentas.generarCredenciales(),
                this.codigo
        );
    }
}
