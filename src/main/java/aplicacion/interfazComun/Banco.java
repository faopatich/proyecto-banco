package aplicacion.interfazComun;

public interface Banco {
    Menu login(Credenciales credenciales);
    Cuenta obtenerCuenta(String numeroCuenta);
}
