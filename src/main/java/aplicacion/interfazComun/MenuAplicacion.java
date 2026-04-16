package aplicacion.interfazComun;

import java.util.Scanner;

public class MenuAplicacion implements Menu {
    private final Banco bancoF;
    private final Banco bancoM;
    private final SeparadorArgumentos separadorArgumentos;
    private final ServicioEntrada servicioEntrada;

    public MenuAplicacion(Banco bancoF, Banco bancoM) {
        this.bancoF = bancoF;
        this.bancoM = bancoM;
        this.separadorArgumentos = new SeparadorArgumentos();
        this.servicioEntrada = new ServicioEntrada(new Scanner(System.in));
    }

    public void ejecutar() {
        while (true) {
            var comandoLogin = this.servicioEntrada.leer();
            var argumentos = this.separadorArgumentos.crear(comandoLogin);
            if (argumentos == null) {
                System.out.println("Comando con formato inválido\n");
                continue;
            }
            if (argumentos[0].equals("salir")) {
                break;
            }
            var credenciales = new Credenciales(argumentos[1], argumentos[2]);
            Banco banco = null;
            if (argumentos[0].equals("BancoF")) {
                banco = this.bancoF;
            } else if (argumentos[0].equals("BancoM")) {
                banco = this.bancoM;
            } else {
                System.out.println("Banco especificado inválido\n");
                continue;
            }
            var menu = banco.login(credenciales);
            if (menu == null) {
                System.out.println("Credenciales inválidas para el banco especificado\n");
                continue;
            }
            menu.ejecutar();
        }
    }
}
