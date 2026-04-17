package aplicacion.BancoM.menu.comandos.cliente;

import aplicacion.BancoM.banco.BancoM;
import aplicacion.BancoM.cuentas.TipoCuenta;
import aplicacion.BancoM.menu.comandos.ComandoMenu;
import aplicacion.BancoM.usuarios.PerfilUsuario;

public class ComandoCrearCuenta implements ComandoMenu {
    private final BancoM bancoM;
    private final PerfilUsuario perfilUsuario;
    private final TipoCuenta tipoCuenta;

    public ComandoCrearCuenta(BancoM bancoM, PerfilUsuario perfilUsuario, TipoCuenta tipoCuenta) {
        this.bancoM = bancoM;
        this.perfilUsuario = perfilUsuario;
        this.tipoCuenta = tipoCuenta;
    }

    @Override
    public void ejecutar() {
        var resultado = this.bancoM
                .sucursal
                .servicioCliente
                .solicitarCrearCuenta(this.perfilUsuario.generarCredenciales(), this.tipoCuenta);
        if (resultado) {
            System.out.println("Se ha solicitado crear una cuenta de forma exitosa");
        } else {
            System.out.println("No fue posible solicitar la creación de una cuenta");
        }
    }
}
