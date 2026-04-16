package aplicacion.interfazComun;

public class MenuAplicacion implements Menu {
    private final Banco bancoF;
    private final Banco bancoM;
    private final SeparadorArgumentos separadorArgumentos;

    public MenuAplicacion(Banco bancoF, Banco bancoM) {
        this.bancoF = bancoF;
        this.bancoM = bancoM;
        this.separadorArgumentos = new SeparadorArgumentos();
    }

    public void ejecutar(ServicioEntrada servicioEntrada, ManejadorTransacciones manejadorTransacciones) {
        while (true) {
            System.out.println("Menu de aplicación");
            System.out.println(" - Ingrese en el formato: <banco> <usuario> <contraseña>\n");
            System.out.print("> ");
            var comandoLogin = servicioEntrada.leer();
            var argumentos = this.separadorArgumentos.crear(comandoLogin);
            if (argumentos == null) {
                System.out.println("Comando con formato inválido\n");
                continue;
            }
            if (argumentos[0].equals("salir")) {
                break;
            }
            var credenciales = new Credenciales(argumentos[1], argumentos[2]);
            Banco banco;
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
            menu.ejecutar(servicioEntrada, manejadorTransacciones);
        }
    }
}
