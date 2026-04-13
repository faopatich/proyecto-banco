import java.util.Scanner;

public class ServicioComando {
    private Scanner lector;

    public ServicioComando() {
        this.lector = new Scanner(System.in);
    }

    public String obtenerComando() {
        return this.lector.nextLine();
    }
}
