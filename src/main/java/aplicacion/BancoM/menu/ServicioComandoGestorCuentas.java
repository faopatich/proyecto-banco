package aplicacion.BancoM.menu;

import aplicacion.BancoM.menu.comandos.ComandoGestorCuenta;

public class ServicioComandoGestorCuentas {
    private final ServicioEntrada servicioEntrada;
    private final FabricaComandoGestorCuentas fabricaComandoGestorCuentas;

    public ServicioComandoGestorCuentas(ServicioEntrada servicioEntrada, FabricaComandoGestorCuentas fabricaComandoGestorCuentas) {
        this.servicioEntrada = servicioEntrada;
        this.fabricaComandoGestorCuentas = fabricaComandoGestorCuentas;
    }

    public ComandoGestorCuenta siguienteComando() {
        return this.fabricaComandoGestorCuentas.crear(
                this.servicioEntrada.leer()
        );
    }
}
