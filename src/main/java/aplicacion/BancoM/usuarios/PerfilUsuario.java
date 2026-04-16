package aplicacion.BancoM.usuarios;

public class PerfilUsuario {
    // Obligatorios
    private final String nombre;
    private String contr;
    private final String fechaDeNacimiento;

    // Opcionales
    private String email;
    private String genero;
    private String direccion;

    public PerfilUsuario(String nombre, String contr, String fechaDeNacimiento) {
        this.nombre = nombre;
        this.contr = contr;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String obtenerNombre() {
        return nombre;
    }
    public String obtenerContr() {
        return contr;
    }
    public String obtenerFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
    public String obtenerEmail() {
        return email;
    }
    public String obtenerGenero() {
        return genero;
    }
    public String obtenerDireccion() {
        return direccion;
    }

    public void cambiarContr(String contr) {
        this.contr = contr;
    }
    public void cambiarEmail(String email) {
        this.email = email;
    }
    public void cambiarGenero(String genero) {
        this.genero = genero;
    }
    public void cambiarDireccion(String direccion) {
        this.direccion = direccion;
    }

    public CredencialesUsuario generarCredenciales() {
        return new CredencialesUsuario(this.nombre, this.contr);
    }
}
