package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.cuentas.Cuenta;

import java.util.HashMap;

public class GestorTransacciones extends Usuario {
    private HashMap<String, Cuenta> cuentas;

    public GestorTransacciones(
            ServicioBanco servicioBanco,
            CredencialesUsuario credencialesUsuario,
            HashMap<String, Cuenta> cuentas
    ) {
        super(servicioBanco, credencialesUsuario);
        this.cuentas = cuentas;
    }

    public boolean manejarDeposito(CredencialesUsuario credencialesUsuario, int saldo) {
        var cuenta = this.cuentas.get(credencialesUsuario.usuario());
        if (cuenta == null) {
            return false;
        }
        cuenta.depositar(saldo);
        return true;
    }
    public boolean manejarRetiro(CredencialesUsuario credencialesUsuario, int saldo) {
        var cuenta = this.cuentas.get(credencialesUsuario.usuario());
        if (cuenta == null) {
            return false;
        }
        cuenta.retirar(saldo);
        return true;
    }
    public boolean manejarTransferencia(CredencialesUsuario credencialesUsuario, String receptor, int saldo) {
        var cuentaEmisor = this.cuentas.get(credencialesUsuario.usuario());
        var cuentaReceptor = this.cuentas.get(receptor);
        if (cuentaEmisor == null || cuentaReceptor == null) {
            return false;
        }
        return cuentaEmisor.transferir(cuentaReceptor, saldo);
    }
}
