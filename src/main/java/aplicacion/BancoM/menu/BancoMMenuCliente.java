package aplicacion.BancoM.menu;

public class BancoMMenuCliente extends BancoMMenu {
    BancoMMenuCliente(ServicioComandoMenu servicioComandoMenu) {
        super(servicioComandoMenu);
    }

    private void mostrarTitulo() {
        System.out.println("Menu de cliente\n");
        System.out.println("Escribe algunos de los siguientes comandos:");
        System.out.println(" 1. transferencia <banco> <num cuenta> <saldo>");
        System.out.println(" 2. salir");
    }

    public void ejecutar() {
        this.mostrarTitulo();
        super.manejarComandos();
    }
}
