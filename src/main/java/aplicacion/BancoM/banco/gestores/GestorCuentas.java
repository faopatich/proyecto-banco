package aplicacion.BancoM.banco.gestores;

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
                        usuario,
                        cuentas.size()
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
    public Cuenta obtenerCuenta(Map<String, Cuenta> cuentas, int numeroCuenta) {
        Cuenta cuenta = null;
        var cuentasOriginales = cuentas.values().stream().toList();
        int i = 0;
        while (i < cuentas.size()) {
            var c = cuentasOriginales.get(i);
            if (c.obtenerNumeroCuenta() == numeroCuenta) {
                cuenta = c;
                break;
            }
            i++;
        }
        return cuenta;
    }
    public void actualizarCuenta(Map<String, Cuenta> cuentas, Cuenta nuevaCuenta) {
        Cuenta cuenta = null;
        var cuentasOriginales = cuentas.values().stream().toList();
        int i = 0;
        while (i < cuentas.size()) {
            var c = cuentasOriginales.get(i);
            if (c.obtenerNumeroCuenta() == nuevaCuenta.obtenerNumeroCuenta()) {
                cuenta = c;
                break;
            }
            i++;
        }
        if (cuenta == null) {
            return;
        }
        cuenta.copy(nuevaCuenta);
    }
}
