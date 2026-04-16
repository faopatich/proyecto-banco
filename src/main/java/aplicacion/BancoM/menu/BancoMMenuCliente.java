package aplicacion.BancoM.menu;

import aplicacion.BancoM.menu.comandos.ServicioComandoMenu;
import aplicacion.interfazComun.ManejadorTransacciones;
import aplicacion.interfazComun.ServicioEntrada;

public class BancoMMenuCliente extends BancoMMenu {
    public BancoMMenuCliente(ServicioComandoMenu servicioComandoMenu) {
        super(servicioComandoMenu);
    }

    private void mostrarTitulo() {
        System.out.println("Menu de cliente\n");
        System.out.println("Escribe algunos de los siguientes comandos:");
        System.out.println(" 1. transferencia <banco> <num cuenta> <saldo>");
        System.out.println(" 2. salir");
    }

    public void ejecutar(ServicioEntrada servicioEntrada, ManejadorTransacciones manejadorTransacciones) {
        this.mostrarTitulo();
        super.manejarComandos();
    }
}
