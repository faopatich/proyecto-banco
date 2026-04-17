package aplicacion.interfazComun;

public class SeparadorArgumentos {
    public SeparadorArgumentos() {}

    public String[] crear(String entrada) {
        var argumentos = entrada.split(" ");
        if (
                ((argumentos.length != 4) &&
                (argumentos.length != 1)) ||
                (argumentos.length == 1 && !argumentos[0].equals("salir"))
        ) {
            return null;
        }
        return argumentos;
    }
}
