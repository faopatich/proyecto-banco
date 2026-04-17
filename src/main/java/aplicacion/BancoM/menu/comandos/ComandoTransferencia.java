package aplicacion.BancoM.menu.comandos;

import aplicacion.BancoM.banco.BancoM;
import aplicacion.BancoM.cuentas.Cuenta;
import aplicacion.BancoM.usuarios.PerfilUsuario;
import aplicacion.interfazComun.ManejadorTransacciones;

public class ComandoTransferencia implements ComandoMenu {
    private final ManejadorTransacciones manejadorTransacciones;
    private final BancoM banco;
    private final PerfilUsuario perfilUsuario;
    private final String nombreBanco;
    private final String numeroCuenta;
    private final Integer saldo;

    public ComandoTransferencia(ManejadorTransacciones manejadorTransacciones, BancoM banco, PerfilUsuario perfilUsuario, String nombreBanco, String numeroCuenta, Integer saldo) {
        this.manejadorTransacciones = manejadorTransacciones;
        this.banco = banco;
        this.perfilUsuario = perfilUsuario;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    @Override
    public void ejecutar() {
        var cuenta = this.banco.sucursal.servicioGestionCuentas.obtenerCuenta(
                this.perfilUsuario.generarCredenciales().usuario()
        );
        var nuevaCuenta = this.manejadorTransacciones.transferir(
                cuenta,
                this.nombreBanco,
                this.numeroCuenta,
                this.saldo
        );
        if (nuevaCuenta != null) {
            cuenta.copy((Cuenta) nuevaCuenta);
        }
    }
}
