package proyectoBanco.cuentas;

import proyectoBanco.Banco;

public class CuentaAhorro extends Cuenta {
    private final Banco banco;

    public CuentaAhorro(String propietario, Banco banco) {
        super.propietario = propietario;
        super.saldo = 0;
        this.banco = banco;
    }

    @Override
    public void verBalance() {
        System.out.println("Balance de cuenta.");
        System.out.println("    - Tipo de cuenta: Ahorro");
        System.out.println("    - Propietario: " + this.propietario);
        System.out.println("    - Saldo: " + this.saldo);
    }

    @Override
    public boolean depositar(int cantidad) {
        this.saldo += cantidad;
        return true;
    }

    @Override
    public boolean retirar(int cantidad) {
        if (this.saldo >= cantidad) {
            this.saldo -= cantidad;
            return true;
        }
        return false;
    }

    @Override
    public boolean transferir(String receptor, int cantidad) {
        return this.banco.transferir(super.propietario, receptor, cantidad);
    }
}
