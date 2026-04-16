package proyectoBanco.gestorCuentas;

import proyectoBanco.banco.*;
import proyectoBanco.banco.servicios.*;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.Cliente;
import proyectoBanco.usuarios.PerfilUsuario;
import proyectoBanco.usuarios.RolUsuario;
import proyectoBanco.usuarios.UsuarioGestorCuentas;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AplicacionGestorCuentas {
    public final Scanner scanner;
    public final ServicioEntrada servicioEntrada;

    public ServicioComandoGestorCuentas servicioComandoGestorCuentas;
    public Menu menu;

    public AplicacionGestorCuentas() {
        this.scanner = new Scanner(System.in);
        this.servicioEntrada = new ServicioEntrada(scanner);
        this.servicioComandoGestorCuentas = null;
        this.menu = null;
    }

    public static void main(String[] args) {
        var aplicacion = new AplicacionGestorCuentas();

        var sucursal1 = new Sucursal();

        var perfilGestorCuentas = new PerfilUsuario("Mateo", "123", "24/5/2004");
        var roles = new HashSet<>(Set.of(RolUsuario.GestorCuentas));
        var rolCliente = new HashSet<>(Set.of(RolUsuario.Cliente));

        var fabrica = new FabricaComandoGestorCuentas(
                sucursal1.servicioGestorCuentas,
                perfilGestorCuentas
        );
        aplicacion.servicioComandoGestorCuentas = new ServicioComandoGestorCuentas(
                aplicacion.servicioEntrada,
                fabrica
        );
        aplicacion.menu = new Menu(aplicacion.servicioComandoGestorCuentas);

        sucursal1.servicioUsuario.crearUsuarioSiNoExiste(perfilGestorCuentas, roles);
        var usuarioGestorCuentas = new UsuarioGestorCuentas(
                perfilGestorCuentas,
                sucursal1.servicioGestorCuentas
        );

        var perfilUsuario1 = new PerfilUsuario("Carlos","hola", "hace mucho");
        var perfilUsuario2 = new PerfilUsuario("Rosa", "lol", "hace relativamente poco");

        sucursal1.servicioUsuario.crearUsuarioSiNoExiste(perfilUsuario1, rolCliente);
        sucursal1.servicioUsuario.crearUsuarioSiNoExiste(perfilUsuario2, rolCliente);

        var cliente1 = new Cliente(perfilUsuario1, sucursal1.servicioCliente);
        var cliente2 = new Cliente(perfilUsuario2, sucursal1.servicioCliente);
        cliente1.solicitarCrearCuenta(TipoCuenta.CuentaAhorro);
        cliente2.solicitarCrearCuenta(TipoCuenta.CuentaCorriente);

        aplicacion.menu.ejecutar();

        cliente1.depositar(200);
        cliente1.transferir(perfilUsuario2.obtenerNombre(), 400);

        cliente1.verEstadoCuenta();
        cliente2.verEstadoCuenta();

        usuarioGestorCuentas.verOperacionesPendientes();
    }
}
