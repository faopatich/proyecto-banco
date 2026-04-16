package aplicacion.BancoM.menu;

import aplicacion.BancoM.menu.comandos.ComandoMenu;
import aplicacion.BancoM.menu.comandos.FabricaComandoMenu;
import aplicacion.interfazComun.ServicioEntrada;

public abstract class ServicioComandoMenu {
    private final ServicioEntrada servicioEntrada;
    private final FabricaComandoMenu fabricaComandoMenu;

    public ServicioComandoMenu(ServicioEntrada servicioEntradas, FabricaComandoMenu fabricaComandoMenu) {
        this.servicioEntrada = servicioEntradas;
        this.fabricaComandoMenu = fabricaComandoMenu;
    }

    public ComandoMenu obtenerComando() {
        String entrada = this.servicioEntrada.leer();
        return this.fabricaComandoMenu.crear(entrada);
    }
}
