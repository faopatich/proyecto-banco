package aplicacion.BancoM.menu;

import aplicacion.BancoM.menu.comandos.ServicioComandoMenu;

public class BancoMMenuGestorCuentas extends BancoMMenu {
    public BancoMMenuGestorCuentas(ServicioComandoMenu servicioComandoMenu) {
        super(servicioComandoMenu);
    }

    private void mostrarTitulo() {
        System.out.println("Menu de gestor de cuentas\n");
        System.out.println("Escribe algunos de los siguientes comandos:");
        System.out.println(" 1. manejar");
        System.out.println(" 2. manejar <codigo>");
        System.out.println(" 3. listar");
        System.out.println(" 4. ayuda");
        System.out.println(" 5. salir");
    }

    public void ejecutar() {
        this.mostrarTitulo();
        super.manejarComandos();
    }
}
