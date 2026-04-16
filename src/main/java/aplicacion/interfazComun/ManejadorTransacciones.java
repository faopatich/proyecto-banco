package aplicacion.interfazComun;

public class ManejadorTransacciones {
    private final Banco bancoF;
    private final Banco bancoM;

    public ManejadorTransacciones(Banco bancoF, Banco bancoM) {
        this.bancoF = bancoF;
        this.bancoM = bancoM;
    }

    public Cuenta transferir(Cuenta emisor, String banco, String numeroCuentaReceptor, int saldo) {
        Banco b;
        if (banco.equals("BancoF")) {
            b = this.bancoF;
        } else if (banco.equals("BancoM")) {
            b = this.bancoM;
        } else {
            return null;
        }
        var receptor = b.obtenerCuenta(numeroCuentaReceptor);
        if (!emisor.retirar(saldo)) {
            return null;
        }
        if (!receptor.depositar(saldo)) {
            return null;
        }
        return emisor;
    }
}
