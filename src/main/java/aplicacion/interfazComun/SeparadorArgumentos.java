package aplicacion.interfazComun;

public class SeparadorArgumentos {
    public SeparadorArgumentos() {}

    public String[] crear(String entrada) {
        var argumentos = entrada.split(" ");
        if ((argumentos.length != 3 ) && (argumentos.length != 1)) {
            return null;
        }
        return argumentos;
    }
}
