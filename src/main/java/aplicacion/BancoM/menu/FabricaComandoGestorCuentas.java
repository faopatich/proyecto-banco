package aplicacion.BancoM.menu;

import aplicacion.BancoM.banco.servicios.ServicioGestorCuentas;
import aplicacion.BancoM.menu.comandos.*;
import aplicacion.BancoM.usuarios.PerfilUsuario;

public class FabricaComandoGestorCuentas implements FabricaComandoMenu {
    private final ServicioGestorCuentas servicioGestorCuentas;
    private final PerfilUsuario perfilUsuarioGestorCuentas;

    private ComandoMenu crearComandoManejar(String entrada) {
        var lineaDividida = entrada.split(" ");

        if (!lineaDividida[0].equals("manejar")) {
            return null;
        }

        if (lineaDividida.length > 1) {
            int codigo;
            try {
                codigo = Integer.parseInt(lineaDividida[1]);
            } catch (NumberFormatException e) {
                return null;
            }
            return new ComandoManejar(
                    this.servicioGestorCuentas,
                    this.perfilUsuarioGestorCuentas,
                    codigo
            );
        }
        return new ComandoManejarTodos(this.servicioGestorCuentas, this.perfilUsuarioGestorCuentas);
    }

    public FabricaComandoGestorCuentas(ServicioGestorCuentas servicioGestorCuentas, PerfilUsuario perfilUsuarioGestorCuentas) {
        this.servicioGestorCuentas = servicioGestorCuentas;
        this.perfilUsuarioGestorCuentas = perfilUsuarioGestorCuentas;
    }

    @Override
    public ComandoMenu crear(String entrada) {
        switch (entrada.charAt(0)) {
            case 'm' -> {
                return this.crearComandoManejar(entrada);
            }
            case 'l' -> {
                if (entrada.equals("listar")) {
                    return new ComandoListar(this.servicioGestorCuentas, this.perfilUsuarioGestorCuentas);
                }
                return null;
            }
            case 'a' -> {
                return new ComandoAyuda();
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
