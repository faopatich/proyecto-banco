package aplicacion;

import aplicacion.BancoM.banco.BancoM;
import aplicacion.BancoM.usuarios.PerfilUsuario;
import aplicacion.BancoM.usuarios.RolUsuario;
import aplicacion.interfazComun.Aplicacion;
import aplicacion.interfazComun.MenuAplicacion;
import aplicacion.interfazComun.ServicioEntrada;

import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        BancoM banco = new BancoM();

        banco.sucursal.servicioUsuario.crearUsuarioSiNoExiste(
                new PerfilUsuario("Mateo", "Contr", "Hoy"),
                Set.of(RolUsuario.Cliente)
        );

        MenuAplicacion menuAplicacion = new MenuAplicacion(null, banco);
        Aplicacion app = new Aplicacion(menuAplicacion);
        Scanner scanner = new Scanner(System.in);
        ServicioEntrada servicioEntrada = new ServicioEntrada(scanner);
        app.ejecutar(servicioEntrada, null);
    }
}
