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
        var resultado = this.bancoM.sucursal.gestorCuentasConcurrente.eliminarCuenta(
                this.perfilUsuario.obtenerNombre()
        );
        if (resultado) {
            System.out.println("Cuenta eliminada exitosamente");
        } else {
            System.out.println("No fue posible eliminar la cuenta");
        }
    }
}
