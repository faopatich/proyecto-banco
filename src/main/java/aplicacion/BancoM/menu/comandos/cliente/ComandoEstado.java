package aplicacion.BancoM.menu.comandos.cliente;

import aplicacion.BancoM.banco.BancoM;
import aplicacion.BancoM.banco.Sucursal;
import aplicacion.BancoM.menu.comandos.ComandoMenu;
import aplicacion.BancoM.usuarios.PerfilUsuario;

public class ComandoEstado implements ComandoMenu {
    private final Sucursal sucursal;
    private final PerfilUsuario perfilUsuario;

    public ComandoEstado(Sucursal sucursal, PerfilUsuario perfilUsuario) {
        this.sucursal  = sucursal;
        this.perfilUsuario = perfilUsuario;
    }

    @Override
    public void ejecutar() {
        var cuenta = this.sucursal
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
