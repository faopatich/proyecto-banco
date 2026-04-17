package aplicacion.BancoM.menu.comandos.cliente;

import aplicacion.BancoM.banco.BancoM;
import aplicacion.BancoM.menu.comandos.ComandoMenu;
import aplicacion.BancoM.usuarios.PerfilUsuario;

public class ComandoDepositar implements ComandoMenu {
    private final BancoM bancoM;
    private final PerfilUsuario perfilUsuario;
    private final int saldo;

    public ComandoDepositar(BancoM bancoM, PerfilUsuario perfilUsuario, int saldo) {
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
                .depositar(this.saldo);
        if (resultado) {
            System.out.println("Depósito correcto");
        } else {
            System.out.println("No pudo realizarse el depósito");
        }
    }
}
