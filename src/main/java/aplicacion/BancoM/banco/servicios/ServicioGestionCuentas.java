package aplicacion.BancoM.banco.servicios;

import aplicacion.BancoM.banco.concurrencia.GestorCuentasConcurrente;
import aplicacion.BancoM.cuentas.Cuenta;
import aplicacion.BancoM.cuentas.TipoCuenta;
import aplicacion.BancoM.usuarios.CredencialesUsuario;

import java.util.List;

public class ServicioGestionCuentas {
    private final GestorCuentasConcurrente gestorCuentasConcurrente;

    public ServicioGestionCuentas(GestorCuentasConcurrente gestorCuentasConcurrente) {
        this.gestorCuentasConcurrente = gestorCuentasConcurrente;
    }

    // Métodos de gestor de cuentas
    public boolean crearCuenta(CredencialesUsuario credenciales, TipoCuenta tipoCuenta) {
        return this.gestorCuentasConcurrente.crearCuenta(credenciales.usuario(), tipoCuenta);
    }
    public boolean eliminarCuenta(CredencialesUsuario credenciales) {
        return this.gestorCuentasConcurrente.eliminarCuenta(credenciales.usuario());
    }
    public Cuenta obtenerCuenta(int numeroCuenta) {
        return this.gestorCuentasConcurrente.obtenerCuenta(numeroCuenta);
    }
    public List<String> obtenerVistaOperacionesPendientes() {
        return this.gestorCuentasConcurrente.obtenerVistaOperacionesPendientes();
    }
    public void resolverOperacion(Integer codigo) {
        this.gestorCuentasConcurrente.resolverOperacion(codigo);
    }
}
