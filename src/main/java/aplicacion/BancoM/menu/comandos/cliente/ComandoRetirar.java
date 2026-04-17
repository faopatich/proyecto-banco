package aplicacion.BancoM.menu.comandos.cliente;

import aplicacion.BancoM.banco.BancoM;
import aplicacion.BancoM.menu.comandos.ComandoMenu;
import aplicacion.BancoM.usuarios.PerfilUsuario;

public class ComandoRetirar implements ComandoMenu {
    private final BancoM bancoM;
    private final PerfilUsuario perfilUsuario;
    private final int saldo;

    public ComandoRetirar(BancoM bancoM, PerfilUsuario perfilUsuario, int saldo) {
        this.bancoM = bancoM;
        this.perfilUsuario = perfilUsuario;
        this.saldo = saldo;
    }

    @Override
    public void ejecutar() {
        var resultado = bancoM.sucursal.gestorCuentasConcurrente
                .obtenerCuenta(
                        perfilUsuario.obtenerNombre()
                )
                .retirar(this.saldo);
        if (resultado) {
            System.out.println("Retiro correcto");
        } else {
            System.out.println("No pudo realizarse el retiro");
        }
    }
}
