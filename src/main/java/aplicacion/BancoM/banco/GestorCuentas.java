package aplicacion.BancoM.banco;

import aplicacion.BancoM.cuentas.CreadorCuenta;
import aplicacion.BancoM.cuentas.Cuenta;
import aplicacion.BancoM.cuentas.TipoCuenta;

import java.util.*;

public class GestorCuentas {
    private final CreadorCuenta creadorCuenta;

    public GestorCuentas(CreadorCuenta creadorCuenta) {
        this.creadorCuenta = creadorCuenta;
    }

    // Operaciones de cuenta
    public boolean crearCuenta(Map<String, Cuenta> cuentas, String usuario, TipoCuenta tipoCuenta) {
        if (cuentas.containsKey(usuario)) {
            return false;
        }
        cuentas.put(
                usuario,
                this.creadorCuenta.crearCuenta(
                        tipoCuenta,
                        usuario
                )
        );
        return true;
    }
    public boolean eliminarCuenta(Map<String, Cuenta> cuentas, String usuario) {
        if (!cuentas.containsKey(usuario)) {
            return false;
        }
        cuentas.remove(usuario);
        return true;
    }
    public Cuenta obtenerCuenta(Map<String, Cuenta> cuentas, String usuario) {
        return cuentas.get(usuario);
    }
}
