package aplicacion.interfazComun;

public interface Banco {
    Menu login(Credenciales credenciales, String codigoSucursal);
    Cuenta obtenerCuenta(String numeroCuenta);
}
