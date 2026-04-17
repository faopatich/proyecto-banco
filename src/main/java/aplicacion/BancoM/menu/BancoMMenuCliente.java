package aplicacion.BancoM.menu;

import aplicacion.BancoM.banco.BancoM;
import aplicacion.BancoM.menu.comandos.cliente.FabricaComandoCliente;
import aplicacion.BancoM.usuarios.PerfilUsuario;
import aplicacion.interfazComun.ManejadorTransacciones;
import aplicacion.interfazComun.ServicioEntrada;

public class BancoMMenuCliente extends BancoMMenu {
    private final BancoM bancoM;
    private final PerfilUsuario perfilUsuario;

    public BancoMMenuCliente(BancoM bancoM, PerfilUsuario perfilUsuario) {
        super(null);
        this.bancoM = bancoM;
        this.perfilUsuario  = perfilUsuario;
    }

    private void mostrarTitulo() {
        System.out.println("Menu de cliente\n");
        System.out.println("Escribe algunos de los siguientes comandos:");
        System.out.println(" 1. crear");
        System.out.println(" 2. transferencia <banco> <num cuenta> <saldo>");
        System.out.println(" 3. estado");
        System.out.println(" 4. depositar");
        System.out.println(" 5. retirar");
        System.out.println(" 6. eliminar");
        System.out.println(" 3. salir");
    }

    public void ejecutar(ServicioEntrada servicioEntrada, ManejadorTransacciones manejadorTransacciones) {
        this.mostrarTitulo();
        super.fabricaComandoMenu = new FabricaComandoCliente(
                manejadorTransacciones,
                this.bancoM,
                this.perfilUsuario
        );
        super.manejarComandos(servicioEntrada);
    }
}
