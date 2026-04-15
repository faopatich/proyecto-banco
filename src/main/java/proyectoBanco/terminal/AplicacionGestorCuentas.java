package proyectoBanco.terminal;

public class AplicacionGestorCuentas {
    private final ServicioComandoGestorCuentas servicioComandoGestorCuentas;

    public AplicacionGestorCuentas(ServicioComandoGestorCuentas servicioComandoGestorCuentas) {
        this.servicioComandoGestorCuentas = servicioComandoGestorCuentas;
    }

    public boolean manejarComando() {
        var comando = this.servicioComandoGestorCuentas.siguienteComando();
        if (comando == null) {
            return false;
        }
        comando.ejecutar();
        return true;
    }

    public void manejarComandos() {
        while (this.manejarComando());
    }

    public static void main(String[] args) {

    }
}
