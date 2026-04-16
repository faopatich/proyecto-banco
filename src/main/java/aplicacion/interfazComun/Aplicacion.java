package aplicacion.interfazComun;

public class Aplicacion {
    private final Menu menuAplicacion;

    public Aplicacion(Menu menuAplicacion) {
        this.menuAplicacion = menuAplicacion;
    }

    public void ejecutar(ServicioEntrada servicioEntrada,ManejadorTransacciones manejadorTransacciones) {
        this.menuAplicacion.ejecutar(servicioEntrada, manejadorTransacciones);
    }
}
