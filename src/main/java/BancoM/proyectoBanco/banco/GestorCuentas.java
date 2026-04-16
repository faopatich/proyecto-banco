package BancoM.proyectoBanco.banco;

import BancoM.proyectoBanco.cuentas.CreadorCuenta;
import BancoM.proyectoBanco.cuentas.Cuenta;
import BancoM.proyectoBanco.cuentas.TipoCuenta;

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
