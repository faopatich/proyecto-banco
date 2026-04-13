package proyectoBanco.comandos;

import proyectoBanco.TipoCuenta;

public class ComandoCrear {
    public final TipoCuenta tipoCuenta;
    public final String usuario;
    public final String direccion;

    public ComandoCrear(TipoCuenta tipoCuenta, String usuario, String direccion) {
        this.tipoCuenta = tipoCuenta;
        this.usuario = usuario;
        this.direccion = direccion;
    }
}
