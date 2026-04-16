package aplicacion.BancoM.menu;

import aplicacion.BancoM.menu.comandos.ComandoMenu;
import aplicacion.BancoM.menu.comandos.ComandoSalir;
import aplicacion.BancoM.menu.comandos.ServicioComandoMenu;
import aplicacion.interfazComun.ManejadorTransacciones;
import aplicacion.interfazComun.Menu;
import aplicacion.interfazComun.ServicioEntrada;

public abstract class BancoMMenu implements Menu {
    protected final ServicioComandoMenu servicioComandoMenu;

    BancoMMenu(ServicioComandoMenu servicioComandoMenu) {
        this.servicioComandoMenu = servicioComandoMenu;
    }

    protected boolean manejarComando() {
        ComandoMenu comando;
        System.out.print("\n> ");
        comando = this.servicioComandoMenu.obtenerComando();
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

    protected void manejarComandos() {
        while (this.manejarComando()) {}
    }

    public abstract void ejecutar(ServicioEntrada servicioEntrada, ManejadorTransacciones manejadorTransacciones);
}
