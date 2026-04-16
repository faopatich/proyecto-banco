package aplicacion.BancoM.banco;

import aplicacion.BancoM.usuarios.CredencialesUsuario;
import aplicacion.interfazComun.Banco;
import aplicacion.interfazComun.Credenciales;
import aplicacion.interfazComun.Menu;

public class BancoM implements Banco {
    private final Sucursal sucursal;

    private CredencialesUsuario crearCredenciales(Credenciales credenciales) {
        return new CredencialesUsuario(
                credenciales.usuario(),
                credenciales.contr()
        );
    }

    public BancoM() {
        this.sucursal = new Sucursal();
    }

    @Override
    public Menu login(Credenciales credenciales) {
        return null;
    }
}
