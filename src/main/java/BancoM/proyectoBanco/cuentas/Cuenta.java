package BancoM.proyectoBanco.cuentas;

public abstract class Cuenta {
    protected String propietario;
    protected int saldo;

    public abstract void verBalance();
    public abstract boolean depositar(int cantidad);
    public abstract boolean retirar(int cantidad);
    public abstract boolean transferir(Cuenta cuenta, int cantidad);
}
