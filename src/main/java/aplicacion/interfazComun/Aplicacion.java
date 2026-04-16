package aplicacion.interfazComun;

public class Aplicacion {
    private final Menu menuAplicacion;

    public Aplicacion(Menu menuAplicacion) {
        this.menuAplicacion = menuAplicacion;
    }

    public void ejecutar() {
        this.menuAplicacion.ejecutar();
    }
}
