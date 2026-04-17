package aplicacion;

import aplicacion.BancoF.Banco;
import aplicacion.BancoF.Cuenta;
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

        bancoM.sucursal.servicioUsuario.crearUsuarioSiNoExiste(perfilMateo, Set.of(RolUsuario.Cliente));
        bancoM.sucursal.servicioGestionCuentas.crearCuenta(perfilMateo.generarCredenciales(), TipoCuenta.CuentaAhorro);
        Cuenta cuenta = new Cuenta("Caja de ahorro");
        cuenta.sumarSaldo(200);

        MenuAplicacion menuAplicacion = new MenuAplicacion(bancoF, bancoM);
        ManejadorTransacciones manejadorTransacciones = new ManejadorTransacciones(bancoF, bancoM);
        Cuenta cuentaMateo = (Cuenta) manejadorTransacciones.transferir(cuenta, "BancoM", "0",100);
        System.out.println(cuentaMateo.getSaldo());
//        Aplicacion app = new Aplicacion(menuAplicacion);
//        Scanner scanner = new Scanner(System.in);
//        ServicioEntrada servicioEntrada = new ServicioEntrada(scanner);
//        app.ejecutar(servicioEntrada, manejadorTransacciones);
    }
}
