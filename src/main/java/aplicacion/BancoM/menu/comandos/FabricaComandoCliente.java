package aplicacion.BancoM.menu.comandos;

import aplicacion.BancoM.banco.BancoM;
import aplicacion.BancoM.usuarios.PerfilUsuario;
import aplicacion.interfazComun.ManejadorTransacciones;

public class FabricaComandoCliente implements FabricaComandoMenu {
    private final ManejadorTransacciones manejadorTransacciones;
    private final BancoM bancoM;
    private final PerfilUsuario perfilUsuario;

    public FabricaComandoCliente(ManejadorTransacciones manejadorTransacciones, BancoM bancoM, PerfilUsuario perfilUsuario) {
        this.manejadorTransacciones = manejadorTransacciones;
        this.bancoM = bancoM;
        this.perfilUsuario = perfilUsuario;
    }

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
        var codigoCuenta = argumentos[2];
        var saldo = this.obtenerNumero(argumentos[3]);
        if (codigoCuenta == null || saldo == null) {
            return null;
        }
        return new ComandoTransferencia(manejadorTransacciones, this.bancoM, this.perfilUsuario, argumentos[1], codigoCuenta, saldo);
    }

    @Override
    public ComandoMenu crear(String entrada) {
        switch (entrada.charAt(0)) {
            case 't' -> {
                return this.crearComandoTransferencia(entrada);
            }
            case 'e' -> {
                return new ComandoEstado(this.bancoM, this.perfilUsuario);
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
