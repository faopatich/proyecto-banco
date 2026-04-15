package proyectoBanco.terminal;

import proyectoBanco.banco.*;
import proyectoBanco.cuentas.CreadorCuenta;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.usuarios.PerfilUsuario;
import proyectoBanco.usuarios.RolUsuario;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AplicacionGestorCuentas {
    private final ServicioComandoGestorCuentas servicioComandoGestorCuentas;

    public AplicacionGestorCuentas(ServicioComandoGestorCuentas servicioComandoGestorCuentas) {
        this.servicioComandoGestorCuentas = servicioComandoGestorCuentas;
    }

    public boolean manejarComando() {
        var comando = this.servicioComandoGestorCuentas.siguienteComando();
        if (comando == null) {
            return false;
        }
        comando.ejecutar();
        return true;
    }

    public void manejarComandos() {
        while (this.manejarComando());
    }

    public static ServicioBanco crearServicioBanco() {
        var cuentas = new HashMap<String, Cuenta>();
        var creadorCuenta = new CreadorCuenta();
        var gestorCuentas = new GestorCuentas(cuentas, creadorCuenta);
        var gestorTransaccs = new GestorTransacciones(cuentas);
        var gestorRoles = new GestorRoles();
        var gestorUsuarios = new GestorUsuarios(gestorRoles);
        var sucursal = new Sucursal(gestorCuentas, gestorTransaccs);
        return new ServicioBanco(sucursal, gestorUsuarios);
    }

    public static void main(String[] args) {
        var servicioBanco = AplicacionGestorCuentas.crearServicioBanco();

        var perfilGestorCuentas = new PerfilUsuario("Mateo", "235", "La Boca");
        var roles = new HashSet<>(Set.of(RolUsuario.GestorCuentas));
        servicioBanco.crearUsuario(perfilGestorCuentas, roles);

        var fabrica = new FabricaComandoGestorCuentas(servicioBanco, perfilGestorCuentas);
        var servicioEntrada = new ServicioEntrada(new Scanner(System.in));
        var servicioComandoGestorCuentas = new ServicioComandoGestorCuentas(servicioEntrada, fabrica);
        var app = new AplicacionGestorCuentas(servicioComandoGestorCuentas);

        app.manejarComandos();
    }
}
