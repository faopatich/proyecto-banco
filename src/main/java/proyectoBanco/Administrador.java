package proyectoBanco;

import proyectoBanco.comandos.ComandoCrear;
import proyectoBanco.comandos.ComandoEliminar;
import proyectoBanco.comandos.ComandoSalir;
import proyectoBanco.comandos.ServicioComando;

public class Administrador {
    private Banco banco;
    private ServicioComando servicioComando;

    private void crearCuenta(TipoCuenta tipoCuenta, String usuario, String direccion) {
        this.banco.crearCuenta(tipoCuenta, usuario, direccion);
    }

    private void eliminarCuenta(String usuario) {
        this.banco.eliminarCuenta(usuario);
    }

    public Administrador(Banco banco, ServicioComando servicioComando) {
        this.banco = banco;
        this.servicioComando = servicioComando;
    }

    public void manejarCrear(ComandoCrear comandoCrear) {
        this.crearCuenta(
                comandoCrear.tipoCuenta(),
                comandoCrear.usuario(),
                comandoCrear.direccion()
        );
    }
    public void manejarEliminar(ComandoEliminar comandoEliminar) {
        this.eliminarCuenta(comandoEliminar.usuario());
    }
    public void manejarSalir(ComandoSalir comandoSalir) {
        // Por ahora nada...
    }

    public void procesarComando() {
        var comando = this.servicioComando.obtenerComando();
        comando.manejar(this);
    }
}
