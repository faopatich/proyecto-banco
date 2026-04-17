package aplicacion.BancoM.menu.comandos.cliente;

import aplicacion.BancoM.banco.BancoM;
import aplicacion.BancoM.menu.comandos.ComandoMenu;
import aplicacion.BancoM.usuarios.PerfilUsuario;

public class ComandoEstado implements ComandoMenu {
    private final BancoM bancoM;
    private final PerfilUsuario perfilUsuario;

    public ComandoEstado(BancoM bancoM, PerfilUsuario perfilUsuario) {
        this.bancoM  = bancoM;
        this.perfilUsuario = perfilUsuario;
    }

    @Override
    public void ejecutar() {
        var cuenta = this.bancoM.sucursal
                .gestorCuentasConcurrente
                .obtenerCuenta(
                        this.perfilUsuario.obtenerNombre()
                );
        if (cuenta == null) {
            System.out.println("No tiene una cuenta en este banco");
        } else {
            cuenta.verBalance();
        }
    }
}
