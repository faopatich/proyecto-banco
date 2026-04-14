package proyectoBanco.banco;

import proyectoBanco.cuentas.*;
import proyectoBanco.usuarios.CredencialesUsuario;

import java.util.List;

public class Sucursal {
    private final GestorCuentas gestorCuentas;
    private final GestorTransacciones gestorTransacciones;

    public Sucursal(
            GestorCuentas gestorCuentas,
            GestorTransacciones gestorTransacciones
        ) {
        this.gestorCuentas = gestorCuentas;
        this.gestorTransacciones = gestorTransacciones;
    }

    // Métodos de Cliente
    public Cuenta obtenerEstadoCuenta(CredencialesUsuario credenciales) {
        return this.gestorCuentas.obtenerCuenta(credenciales.usuario());
    }
    public void crearCuenta(TipoCuenta tipoCuenta, CredencialesUsuario credenciales) {
        this.gestorCuentas.solicitarCrearCuenta(credenciales.usuario(), tipoCuenta);
    }
    public void eliminarCuenta(CredencialesUsuario credenciales) {
        this.gestorCuentas.solicitarEliminarCuenta(credenciales.usuario());
    }
    public boolean depositar(CredencialesUsuario credenciales, int cantidad) {
        return this.gestorTransacciones.manejarDeposito(credenciales.usuario(), cantidad);
    }
    public boolean retirar(CredencialesUsuario credenciales, int cantidad) {
        return this.gestorTransacciones.manejarRetiro(credenciales.usuario(), cantidad);
    }
    public boolean transferir(CredencialesUsuario credenciales, String receptor, int cantidad) {
        return this.gestorTransacciones.manejarTransferencia(credenciales.usuario(), receptor, cantidad);
    }

    // Métodos de gestor de cuentas
    public List<String> obtenerVistaOperacionesPendientes() {
        return this.gestorCuentas.obtenerVistaOperacionesPendientes();
    }
    public void resolverOperacion(int indice) {
        this.gestorCuentas.resolverOperacion(indice);
    }
}
