package aplicacion.BancoM.banco.comandos;

import aplicacion.BancoM.banco.concurrencia.GestorCuentasConcurrente;
import aplicacion.BancoM.cuentas.TipoCuenta;

public class ComandoCuentaCrearCuenta implements ComandoCuenta {
    private final GestorCuentasConcurrente gestorCuentasConcurrente;
    private final String propietario;
    private final TipoCuenta tipoCuenta;

    public ComandoCuentaCrearCuenta(
            GestorCuentasConcurrente gestorCuentasConcurrente,
            String propietario,
            TipoCuenta tipoCuenta
    ) {
        this.gestorCuentasConcurrente = gestorCuentasConcurrente;
        this.propietario = propietario;
        this.tipoCuenta = tipoCuenta;
    }

    @Override
    public void ejecutar() {
        this.gestorCuentasConcurrente.crearCuenta(this.propietario, this.tipoCuenta);
    }

    @Override
    public String toString() {
        return "Crear cuenta - TC: " + this.tipoCuenta + " - Propietario: " + this.propietario;
    }
}
