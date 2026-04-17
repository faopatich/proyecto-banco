package aplicacion.BancoM.cuentas;

import aplicacion.BancoM.usuarios.PerfilUsuario;

public abstract class Cuenta implements aplicacion.interfazComun.Cuenta, Cloneable {
    protected String propietario;
    protected int numeroCuenta;
    protected int saldo;

    public int obtenerNumeroCuenta() {
        return this.numeroCuenta;
    }

    public abstract void verBalance();

    @Override
    public abstract boolean depositar(int cantidad);

    @Override
    public abstract boolean retirar(int cantidad);

    public abstract boolean transferir(Cuenta cuenta, int cantidad);

    public void copy(Cuenta otro) {
        this.propietario = otro.propietario;
        this.numeroCuenta = otro.numeroCuenta;
        this.saldo = otro.saldo;
    }

    @Override
    public Cuenta clone() {
        try {
            return (Cuenta) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
