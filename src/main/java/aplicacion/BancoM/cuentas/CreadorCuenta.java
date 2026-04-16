package aplicacion.BancoM.cuentas;

public class CreadorCuenta {
    private CuentaCorriente crearCuentaCorriente(String propietario, int numeroCuenta) {
        return new CuentaCorriente(propietario, numeroCuenta);
    }
    private CuentaAhorro crearCuentaAhorro(String propietario, int numeroCuenta) {
        return new CuentaAhorro(propietario, numeroCuenta);
    }

    public Cuenta crearCuenta(TipoCuenta tipoCuenta, String propietario, int numeroCuenta) {
        switch (tipoCuenta) {
            case CuentaCorriente -> {
                return this.crearCuentaCorriente(propietario, numeroCuenta);
            }
            case CuentaAhorro -> {
                return this.crearCuentaAhorro(propietario, numeroCuenta);
            }
            default -> {
                return null;
            }
        }
    }
}
