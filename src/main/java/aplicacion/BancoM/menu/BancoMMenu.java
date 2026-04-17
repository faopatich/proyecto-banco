package aplicacion.BancoM.menu;

import aplicacion.BancoM.menu.comandos.ComandoMenu;
import aplicacion.BancoM.menu.comandos.ComandoSalir;
import aplicacion.BancoM.menu.comandos.FabricaComandoMenu;
import aplicacion.BancoM.menu.comandos.ServicioComandoMenu;
import aplicacion.interfazComun.ManejadorTransacciones;
import aplicacion.interfazComun.Menu;
import aplicacion.interfazComun.ServicioEntrada;

public abstract class BancoMMenu implements Menu {
    protected FabricaComandoMenu fabricaComandoMenu;

    BancoMMenu(FabricaComandoMenu fabricaComandoMenu) {
        this.fabricaComandoMenu = fabricaComandoMenu;
    }

    protected boolean manejarComando(ServicioComandoMenu servicioComandoMenu) {
        ComandoMenu comando;
        System.out.print("\n> ");
        comando = servicioComandoMenu.obtenerComando();
        if (comando instanceof ComandoSalir) {
            return false;
        }
        if (comando == null) {
            System.out.println("Comando desconocido");
            return true;
        }
        comando.ejecutar();
        return true;
    }

    protected void manejarComandos(ServicioEntrada servicioEntrada) {
        ServicioComandoMenu servicioComandoMenu = new ServicioComandoMenu(servicioEntrada, this.fabricaComandoMenu);
        while (this.manejarComando(servicioComandoMenu)) {}
    }

    public abstract void ejecutar(ServicioEntrada servicioEntrada, ManejadorTransacciones manejadorTransacciones);
}
