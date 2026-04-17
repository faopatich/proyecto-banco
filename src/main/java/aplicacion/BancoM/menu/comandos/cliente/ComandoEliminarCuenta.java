package aplicacion.BancoM.menu.comandos.cliente;

import aplicacion.BancoM.banco.BancoM;
import aplicacion.BancoM.menu.comandos.ComandoMenu;
import aplicacion.BancoM.usuarios.PerfilUsuario;

public class ComandoEliminarCuenta implements ComandoMenu {
    private final BancoM bancoM;
    private final PerfilUsuario perfilUsuario;

    public ComandoEliminarCuenta(BancoM bancoM, PerfilUsuario perfilUsuario) {
        this.bancoM = bancoM;
        this.perfilUsuario = perfilUsuario;
    }

    @Override
    public void ejecutar() {
        var resultado = this.bancoM
                .sucursal
                .servicioCliente
                .solicitarEliminarCuenta(this.perfilUsuario.generarCredenciales());
        if (resultado) {
            System.out.println("Se ha solicitado eliminar su cuenta de forma exitosa");
        } else {
            System.out.println("No fue posible solicitar la creación de au cuenta");
        }
    }
}
