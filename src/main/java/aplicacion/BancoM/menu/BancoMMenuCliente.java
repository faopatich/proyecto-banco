package aplicacion.BancoM.menu;

import aplicacion.BancoM.banco.BancoM;
import aplicacion.BancoM.banco.Sucursal;
import aplicacion.BancoM.menu.comandos.cliente.FabricaComandoCliente;
import aplicacion.BancoM.usuarios.PerfilUsuario;
import aplicacion.interfazComun.ManejadorTransacciones;
import aplicacion.interfazComun.ServicioEntrada;

public class BancoMMenuCliente extends BancoMMenu {
    private final Sucursal sucursal;
    private final PerfilUsuario perfilUsuario;

    public BancoMMenuCliente(Sucursal sucursal, PerfilUsuario perfilUsuario) {
        super(null);
        this.sucursal = sucursal;
        this.perfilUsuario  = perfilUsuario;
    }

    private void mostrarTitulo() {
        System.out.println("Menu de cliente\n");
        System.out.println("Escribe algunos de los siguientes comandos:");
        System.out.println(" 1. crear <tipo>");
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
                this.sucursal,
                this.perfilUsuario
        );
        super.manejarComandos(servicioEntrada);
    }
}
