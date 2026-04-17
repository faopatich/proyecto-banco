package aplicacion.BancoM.menu.comandos.cliente;

import aplicacion.BancoM.banco.BancoM;
import aplicacion.BancoM.cuentas.TipoCuenta;
import aplicacion.BancoM.menu.comandos.ComandoMenu;
import aplicacion.BancoM.menu.comandos.ComandoSalir;
import aplicacion.BancoM.menu.comandos.FabricaComandoMenu;
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

    private ComandoMenu crearComandoCrearCuenta(String entrada) {
        var argumentos = entrada.split(" ");
        if (argumentos.length != 2 || !argumentos[0].equals("crear")) {
            return null;
        }
        if (!argumentos[1].equals("corriente") && !argumentos[1].equals("ahorro")) {
            return null;
        }
        TipoCuenta tipoCuenta = argumentos[1].equals("ahorro") ? TipoCuenta.CuentaAhorro : TipoCuenta.CuentaCorriente;
        return new ComandoCrearCuenta(this.bancoM,this.perfilUsuario, tipoCuenta);
    }

    private ComandoMenu crearComandoTransferencia(String entrada) {
        var argumentos = entrada.split(" ");
        if (argumentos.length != 4 && !argumentos[0].equals("transferencia")) {
            return null;
        }
        var codigoCuenta = argumentos[2];
        var saldo = this.obtenerNumero(argumentos[3]);
        if (codigoCuenta == null || saldo == null) {
            return null;
        }
        return new ComandoTransferencia(
                manejadorTransacciones,
                this.bancoM,
                this.perfilUsuario,
                argumentos[1],
                codigoCuenta,
                saldo
        );
    }

    private ComandoMenu crearComandoDepositar(String entrada) {
        var argumentos = entrada.split(" ");
        if (argumentos.length != 2 || !argumentos[0].equals("depositar")) {
            return null;
        }
        Integer saldo = this.obtenerNumero(argumentos[1]);
        if (saldo == null) {
            return null;
        }
        return new ComandoDepositar(this.bancoM,this.perfilUsuario, saldo);
    }

    private ComandoMenu crearComandoRetirar(String entrada) {
        var argumentos = entrada.split(" ");
        if (argumentos.length != 2 || !argumentos[0].equals("retirar")) {
            return null;
        }
        Integer saldo = this.obtenerNumero(argumentos[1]);
        if (saldo == null) {
            return null;
        }
        return new ComandoRetirar(this.bancoM,this.perfilUsuario, saldo);
    }

    @Override
    public ComandoMenu crear(String entrada) {
        switch (entrada.charAt(0)) {
            case 'c' -> {
                return this.crearComandoCrearCuenta(entrada);
            }
            case 't' -> {
                return this.crearComandoTransferencia(entrada);
            }
            case 'e' -> {
                if (entrada.equals("estado")) {
                    return new ComandoEstado(this.bancoM, this.perfilUsuario);
                }
                if (entrada.equals("eliminar")) {
                    return new ComandoEliminarCuenta(this.bancoM, this.perfilUsuario);
                }
                return null;
            }
            case 'd' -> {
                return this.crearComandoDepositar(entrada);
            }
            case 'r' -> {
                return this.crearComandoRetirar(entrada);
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
