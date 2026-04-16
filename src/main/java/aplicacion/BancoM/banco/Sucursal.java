package aplicacion.BancoM.banco;

import aplicacion.BancoM.banco.concurrencia.GestorCuentasConcurrente;
import aplicacion.BancoM.banco.concurrencia.GestorTransaccionesConcurrente;
import aplicacion.BancoM.banco.concurrencia.GestorUsuariosConcurrente;
import aplicacion.BancoM.banco.servicios.*;
import aplicacion.BancoM.cuentas.CreadorCuenta;

public class Sucursal {
    public final ServicioUsuario servicioUsuario;
    public final ServicioCliente servicioCliente;
    public final ServicioGestorCuentas servicioGestorCuentas;

    public Sucursal() {
        var gestorRoles = new GestorRoles();
        var gestorUsuarios = new GestorUsuarios(gestorRoles);
        var gestorUsuariosConcurrente = new GestorUsuariosConcurrente(gestorUsuarios);
        var creadorCuenta = new CreadorCuenta();
        var gestorCuentas = new GestorCuentas(creadorCuenta);
        var gestorCuentasConcurrente = new GestorCuentasConcurrente(gestorCuentas);
        var servicioGestionCuentas = new ServicioGestionCuentas(gestorCuentasConcurrente);
        var servicioCuentaCliente = new ServicioCuentaCliente(gestorCuentasConcurrente);
        var gestorTransacciones = new GestorTransacciones();
        var gestorTransaccionesConcurrente = new GestorTransaccionesConcurrente(gestorTransacciones);
        var servicioTransaccion = new ServicioTransaccion(gestorTransaccionesConcurrente);

        this.servicioUsuario = new ServicioUsuario(gestorUsuariosConcurrente);
        this.servicioCliente = new ServicioCliente(gestorUsuariosConcurrente, servicioCuentaCliente, servicioTransaccion);
        this.servicioGestorCuentas = new ServicioGestorCuentas(gestorUsuariosConcurrente, servicioGestionCuentas);
    }
}
