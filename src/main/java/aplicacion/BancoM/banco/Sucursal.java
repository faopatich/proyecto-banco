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

    public final GestorRoles gestorRoles;
    public final GestorUsuarios gestorUsuarios;
    public final GestorUsuariosConcurrente gestorUsuariosConcurrente;
    public final CreadorCuenta creadorCuenta;
    public final GestorCuentas gestorCuentas;
    public final GestorCuentasConcurrente gestorCuentasConcurrente;
    public final ServicioGestionCuentas servicioGestionCuentas;
    public final ServicioCuentaCliente servicioCuentaCliente;
    public final GestorTransacciones gestorTransacciones;
    public final GestorTransaccionesConcurrente gestorTransaccionesConcurrente;
    public final ServicioTransaccion servicioTransaccion;

    public Sucursal() {
        this.gestorRoles = new GestorRoles();
        this.gestorUsuarios = new GestorUsuarios(gestorRoles);
        this.gestorUsuariosConcurrente = new GestorUsuariosConcurrente(gestorUsuarios);
        this.creadorCuenta = new CreadorCuenta();
        this.gestorCuentas = new GestorCuentas(creadorCuenta);
        this.gestorCuentasConcurrente = new GestorCuentasConcurrente(gestorCuentas);
        this.servicioGestionCuentas = new ServicioGestionCuentas(gestorCuentasConcurrente);
        this.servicioCuentaCliente = new ServicioCuentaCliente(gestorCuentasConcurrente);
        this.gestorTransacciones = new GestorTransacciones();
        this.gestorTransaccionesConcurrente = new GestorTransaccionesConcurrente(gestorTransacciones);
        this.servicioTransaccion = new ServicioTransaccion(gestorTransaccionesConcurrente);

        this.servicioUsuario = new ServicioUsuario(gestorUsuariosConcurrente);
        this.servicioCliente = new ServicioCliente(gestorUsuariosConcurrente, servicioCuentaCliente, servicioTransaccion);
        this.servicioGestorCuentas = new ServicioGestorCuentas(gestorUsuariosConcurrente, servicioGestionCuentas);
    }
}
