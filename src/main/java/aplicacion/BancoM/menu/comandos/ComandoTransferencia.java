package aplicacion.BancoM.menu.comandos;

public class ComandoTransferencia implements ComandoMenu {
    private final String banco;
    private final Integer numeroCuenta;
    private final Integer saldo;

    public ComandoTransferencia(String banco, Integer numeroCuenta, Integer saldo) {
        this.banco = banco;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    @Override
    public void ejecutar() {}
}
