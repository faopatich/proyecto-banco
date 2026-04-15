package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;

public class Cliente extends Usuario {
    private Cuenta vistaCuenta;

    public Cliente(ServicioBanco servicioBanco, PerfilUsuario perfilUsuario) {
        super(servicioBanco, perfilUsuario);
        this.vistaCuenta = null;
    }

    public boolean solicitarCrearCuenta(TipoCuenta tipoCuenta) {
        return this.servicioBanco.solicitarCrearCuenta(super.perfilUsuario, tipoCuenta);
    }
    public boolean solicitarEliminarCuenta() {
        return this.servicioBanco.solicitarEliminarCuenta(super.perfilUsuario.generarCredenciales());
    }
    public void actualizarVistaCuenta() {
        this.vistaCuenta = this.servicioBanco.obtenerEstadoCuenta(
                super.perfilUsuario.generarCredenciales()
        );
    }
    public boolean depositar(int cantidad) {
        return this.servicioBanco.depositar(cantidad, super.perfilUsuario.generarCredenciales());
    }
    public boolean retirar(int cantidad) {
        return this.servicioBanco.retirar(cantidad, super.perfilUsuario.generarCredenciales());
    }
    public boolean transferir(String receptor, int cantidad) {
        return this.servicioBanco.transferir(super.perfilUsuario.generarCredenciales(), receptor, cantidad);
    }
    public void verEstadoCuenta() {
        if (this.vistaCuenta == null) {
            return;
        }
        this.vistaCuenta.verBalance();
    }
}
