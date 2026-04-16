package aplicacion.BancoM.menu.comandos;

public class FabricaComandoCliente implements FabricaComandoMenu {
    public FabricaComandoCliente() {}

    private Integer obtenerNumero(String texto) {
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private ComandoMenu crearComandoTransferencia(String entrada) {
        var argumentos = entrada.split(" ");
        if (argumentos.length != 4) {
            return null;
        }
        var codigoCuenta = this.obtenerNumero(argumentos[2]);
        var saldo = this.obtenerNumero(argumentos[3]);
        if (codigoCuenta == null || saldo == null) {
            return null;
        }
        return new ComandoTransferencia(argumentos[1], codigoCuenta, saldo);
    }

    @Override
    public ComandoMenu crear(String entrada) {
        switch (entrada.charAt(0)) {
            case 't' -> {
                return this.crearComandoTransferencia(entrada);
            }
            case 's' -> {
                return new ComandoSalir();
            }
            default -> {
                return null;
            }
        }
    }
}
