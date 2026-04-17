package aplicacion.BancoM.menu.comandos.cliente;

import aplicacion.BancoM.banco.BancoM;
import aplicacion.BancoM.banco.Sucursal;
import aplicacion.BancoM.cuentas.TipoCuenta;
import aplicacion.BancoM.menu.comandos.ComandoMenu;
import aplicacion.BancoM.usuarios.PerfilUsuario;

public class ComandoCrearCuenta implements ComandoMenu {
    private final Sucursal sucursal;
    private final PerfilUsuario perfilUsuario;
    private final TipoCuenta tipoCuenta;

    public ComandoCrearCuenta(Sucursal sucursal, PerfilUsuario perfilUsuario, TipoCuenta tipoCuenta) {
        this.sucursal = sucursal;
        this.perfilUsuario = perfilUsuario;
        this.tipoCuenta = tipoCuenta;
    }

    @Override
    public void ejecutar() {
        var resultado = this
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
