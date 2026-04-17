package aplicacion;

import aplicacion.BancoF.*;
import aplicacion.BancoM.banco.BancoM;
import aplicacion.BancoM.cuentas.TipoCuenta;
import aplicacion.BancoM.usuarios.PerfilUsuario;
import aplicacion.BancoM.usuarios.RolUsuario;
import aplicacion.interfazComun.Aplicacion;
import aplicacion.interfazComun.ManejadorTransacciones;
import aplicacion.interfazComun.MenuAplicacion;
import aplicacion.interfazComun.ServicioEntrada;

import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Banco bancoF = new Banco("BancoF");
        BancoM bancoM = new BancoM();

        var perfilMateo = new PerfilUsuario("Mateo", "Contr", "Hoy");
        var perfilGestor = new PerfilUsuario("Gestor", "Contr", "Hoy");
        bancoM.sucursal.servicioUsuario.crearUsuarioSiNoExiste(perfilMateo, Set.of(RolUsuario.Cliente));
        bancoM.sucursal.servicioUsuario.crearUsuarioSiNoExiste(perfilGestor, Set.of(RolUsuario.GestorCuentas));
        bancoM.sucursal.servicioGestionCuentas.crearCuenta(perfilMateo.generarCredenciales(), TipoCuenta.CuentaAhorro);

        aplicacion.BancoF.Cliente.Builder builder = new Cliente.Builder();
        builder.setUsername("Franco")
                .setPassword("Contr");
        Cliente clienteF = builder.build();
        Cuenta cuentaF = new Cuenta("Caja de ahorro");
        cuentaF.sumarSaldo(200);
        clienteF.setCuenta(cuentaF);
        Sucursal sucursalF = new Sucursal("X", "S", new AdminSucursal("", "", "", "Contr", "X"));
        bancoF.agregarSucursal(sucursalF);
        sucursalF.agregarCliente(clienteF);

        MenuAplicacion menuAplicacion = new MenuAplicacion(bancoF, bancoM);
        ManejadorTransacciones manejadorTransacciones = new ManejadorTransacciones(bancoF, bancoM);
        Aplicacion app = new Aplicacion(menuAplicacion);
        Scanner scanner = new Scanner(System.in);
        ServicioEntrada servicioEntrada = new ServicioEntrada(scanner);
        app.ejecutar(servicioEntrada, manejadorTransacciones);
    }
}
