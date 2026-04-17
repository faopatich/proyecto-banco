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
        bancoM.agregaSucursal("paseo-colon");
        bancoM.agregaSucursal("av-brasil");

        var perfilMateo = new PerfilUsuario("Mateo", "Contr", "Hoy");
        var perfilGestor1 = new PerfilUsuario("Gestor1", "Contr", "Hoy");
        var perfilGestor2 = new PerfilUsuario("Gestor2", "Contr", "Hoy");
        bancoM.agregarCliente(perfilMateo);
        bancoM.agregarGestorCuentas(perfilGestor1, "paseo-colon");
        bancoM.agregarGestorCuentas(perfilGestor2, "av-brasil");
        bancoM.agregarCuenta(perfilMateo.generarCredenciales(), TipoCuenta.CuentaAhorro);


        AdminSucursal adminCentral = UsuarioFactory.crearAdminSucursal(
                "Admin Central",
                "11111111",
                "central",
                "1234",
                "S001"
        );

        AdminSucursal adminPalermo = UsuarioFactory.crearAdminSucursal(
                "Admin Palermo",
                "22222222",
                "palermo",
                "1234",
                "S002"
        );
        var sucursal = new Sucursal("S001", "Casa Central", adminCentral);
        bancoF.agregarSucursal(sucursal);
        bancoF.agregarSucursal(new Sucursal("S002", "Palermo", adminPalermo));

        MenuAplicacion menuAplicacion = new MenuAplicacion(bancoF, bancoM);
        ManejadorTransacciones manejadorTransacciones = new ManejadorTransacciones(bancoF, bancoM);
        Aplicacion app = new Aplicacion(menuAplicacion);
        Scanner scanner = new Scanner(System.in);
        ServicioEntrada servicioEntrada = new ServicioEntrada(scanner);
        app.ejecutar(servicioEntrada, manejadorTransacciones);
    }
}
