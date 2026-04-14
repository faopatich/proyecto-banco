package proyectoBanco.banco;

import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.CredencialesUsuario;

import java.util.List;

public class ServicioBanco {
    private final Sucursal sucursal;
    private final GestorUsuarios gestorUsuarios; // Es un service

    private boolean credencialesInvalidas(CredencialesUsuario credencialesUsuario) {
        return !this.gestorUsuarios.verificarCredencialesUsuario(credencialesUsuario);
    }

    public ServicioBanco(Sucursal sucursal, GestorUsuarios gestorUsuarios) {
        this.sucursal = sucursal;
        this.gestorUsuarios = gestorUsuarios;
    }

    // Operaciones de cliente
    public boolean crearCuenta(TipoCuenta tipoCuenta, CredencialesUsuario credencialesUsuario) {
        if (this.credencialesInvalidas(credencialesUsuario)) return false;
        this.sucursal.crearCuenta(tipoCuenta, credencialesUsuario);
        return true;
    }
    public boolean eliminarCuenta(CredencialesUsuario credencialesUsuario) {
        if (this.credencialesInvalidas(credencialesUsuario)) return false;
        this.sucursal.eliminarCuenta(credencialesUsuario);
        return true;
    }
    public Cuenta obtenerEstadoCuenta(CredencialesUsuario credencialesUsuario) {
        if (this.credencialesInvalidas(credencialesUsuario)) return null;
        return this.sucursal.obtenerEstadoCuenta(credencialesUsuario);
    }
    public boolean depositar(int cantidad, CredencialesUsuario credencialesUsuario) {
        if (this.credencialesInvalidas(credencialesUsuario)) return false;
        return this.sucursal.depositar(credencialesUsuario, cantidad);
    }
    public boolean retirar(int cantidad, CredencialesUsuario credencialesUsuario) {
        if (this.credencialesInvalidas(credencialesUsuario)) return false;
        return this.sucursal.retirar(credencialesUsuario, cantidad);
    }
    public boolean transferir(CredencialesUsuario credencialesUsuario, String receptor, int cantidad) {
        if (this.credencialesInvalidas(credencialesUsuario)) return false;
        return this.sucursal.transferir(
                credencialesUsuario,
                receptor,
                cantidad
        );
    }

    // Métodos de gestor de cuentas
    public List<String> obtenerOperacionesPendientes(CredencialesUsuario credencialesUsuario) {
        if (this.credencialesInvalidas(credencialesUsuario)) return null;
        return this.sucursal.obtenerVistaOperacionesPendientes();
    }
    public boolean resolverOperacion(CredencialesUsuario credencialesUsuario, int indice) {
        if (this.credencialesInvalidas(credencialesUsuario)) return false;
        this.sucursal.resolverOperacion(indice);
        return true;
    }
}
