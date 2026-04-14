package proyectoBanco.banco;

import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.PerfilUsuario;

public class ServicioBanco {
    private final Sucursal sucursal;
    private final PerfilUsuario perfilUsuario;
    private Cuenta cuenta;

    public ServicioBanco(Sucursal sucursal, PerfilUsuario perfilUsuario) {
        this.sucursal = sucursal;
        this.perfilUsuario = perfilUsuario;
        this.cuenta = null;
    }

    public void solicitarCrearCuenta(TipoCuenta tipoCuenta) {
        this.sucursal.solicitarCrearCuenta(tipoCuenta, this.perfilUsuario.generarCredenciales());
    }
    public void solicitarEliminarCuenta() {
        this.sucursal.solicitarEliminarCuenta(this.perfilUsuario.generarCredenciales());
    }

    public void refrescarPerfilUsuario() {
        // Por ahora no cambia...
    }
    public void obtenerEstadoCuenta() {
        this.cuenta = this.sucursal.obtenerEstadoCuenta(this.perfilUsuario.generarCredenciales());
    }

    public boolean depositar(int cantidad) {
        return this.sucursal.intentarHacerDeposito(cantidad, this.perfilUsuario.generarCredenciales());
    }
    public boolean retirar(int cantidad) {
        return this.sucursal.intentarHacerRetiro(cantidad, this.perfilUsuario.generarCredenciales());
    }
    public boolean transferir(String receptor, int cantidad) {
        return this.sucursal.intentarHacerTransferencia(
                receptor,
                cantidad,
                this.perfilUsuario.generarCredenciales()
        );
    }
}
