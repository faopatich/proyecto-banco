package aplicacion.BancoF;

import aplicacion.interfazComun.Credenciales;
import aplicacion.interfazComun.ManejadorTransacciones;
import aplicacion.interfazComun.Menu;
import aplicacion.interfazComun.ServicioEntrada;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco implements aplicacion.interfazComun.Banco {
    private String nombre;
    private ArrayList<Sucursal> sucursales;
    private GestorOperaciones gestorOperaciones;
    private Scanner scanner;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.sucursales = new ArrayList<Sucursal>();
        this.gestorOperaciones = new GestorOperaciones();
        this.scanner = new Scanner(System.in);
    }

    public String getNombre() {
        return nombre;
    }

    public GestorOperaciones getGestorOperaciones() {
        return gestorOperaciones;
    }

    public void agregarSucursal(Sucursal sucursal) {
        sucursales.add(sucursal);
    }

    public ArrayList<Sucursal> getSucursales() {
        return sucursales;
    }

    @Override
    public Menu login(Credenciales credenciales, String codigoSucursal) {
        String username = credenciales.usuario();
        String password = credenciales.contr();

        MenuSistema menuSistema = new MenuSistema(scanner, this);

        if (username.equals("admin") && password.equals("1234")) {
            return (servicioEntrada, manejadorTransacciones) -> menuSistema.menuAdminGeneral();
        }

        Sucursal sucursal = buscarSucursalPorAdminUsername(username);
        if (sucursal != null && sucursal.getAdmin().getPassword().equals(password)) {
            return (servicioEntrada, manejadorTransacciones) -> menuSistema.menuAdminSucursal(sucursal);
        }

        Cliente cliente = buscarClientePorUsername(username);
        if (cliente != null && cliente.getPassword().equals(password)) {
            return (servicioEntrada, manejadorTransacciones) -> menuSistema.menuCliente(cliente, manejadorTransacciones);
        }

        return null;
    }

    @Override
    public aplicacion.interfazComun.Cuenta obtenerCuenta(String numeroCuenta) {
        return buscarCuentaPorNumero(numeroCuenta);
    }

    public Sucursal buscarSucursalPorCodigo(String codigo) {
        Sucursal sucursalEncontrada = null;
        int i = 0;

        while (i < sucursales.size() && sucursalEncontrada == null) {
            if (sucursales.get(i).getCodigo().equals(codigo)) {
                sucursalEncontrada = sucursales.get(i);
            }
            i = i + 1;
        }

        return sucursalEncontrada;
    }

    public Cliente buscarClientePorUsername(String username) {
        Cliente clienteEncontrado = null;
        int i = 0;

        while (i < sucursales.size() && clienteEncontrado == null) {
            clienteEncontrado = sucursales.get(i).buscarClientePorUsername(username);
            i = i + 1;
        }

        return clienteEncontrado;
    }

    public Cliente buscarClientePorDni(String dni) {
        Cliente clienteEncontrado = null;
        int i = 0;

        while (i < sucursales.size() && clienteEncontrado == null) {
            clienteEncontrado = sucursales.get(i).buscarClientePorDni(dni);
            i = i + 1;
        }

        return clienteEncontrado;
    }

    public Cliente buscarClientePorCuenta(Cuenta cuenta) {
        Cliente clienteEncontrado = null;
        int i = 0;

        while (i < sucursales.size() && clienteEncontrado == null) {
            Sucursal sucursal = sucursales.get(i);

            int j = 0;
            while (j < sucursal.getClientes().size() && clienteEncontrado == null) {
                Cliente cliente = sucursal.getClientes().get(j);

                if (cliente.getCuenta() != null) {
                    if (cliente.getCuenta().equals(cuenta)) {
                        clienteEncontrado = cliente;
                    }
                }

                j = j + 1;
            }

            i = i + 1;
        }

        return clienteEncontrado;
    }

    public Sucursal buscarSucursalPorAdminUsername(String username) {
        Sucursal sucursalEncontrada = null;
        int i = 0;

        while (i < sucursales.size() && sucursalEncontrada == null) {
            if (sucursales.get(i).getAdmin().getUsername().equals(username)) {
                sucursalEncontrada = sucursales.get(i);
            }
            i = i + 1;
        }

        return sucursalEncontrada;
    }

    public double calcularTotalBanco() {
        double total = 0;
        int i = 0;

        while (i < sucursales.size()) {
            total = total + sucursales.get(i).calcularTotalSucursal();
            i = i + 1;
        }

        return total;
    }

    public void mostrarSucursales() {
        int i = 0;

        while (i < sucursales.size()) {
            System.out.println(
                    sucursales.get(i).getCodigo() +
                            " - " + sucursales.get(i).getNombre() +
                            " | Admin: " + sucursales.get(i).getAdmin().getUsername()
            );
            i = i + 1;
        }
    }

    public Cuenta buscarCuentaPorNumero(String numeroCuenta) {
        Cuenta cuentaEncontrada = null;
        int i = 0;

        while (i < sucursales.size() && cuentaEncontrada == null) {
            Sucursal sucursal = sucursales.get(i);

            int j = 0;
            while (j < sucursal.getClientes().size() && cuentaEncontrada == null) {
                Cliente cliente = sucursal.getClientes().get(j);

                if (cliente.getCuenta() != null) {
                    if (cliente.getCuenta().getNumeroCuenta().equals(numeroCuenta)) {
                        cuentaEncontrada = cliente.getCuenta();
                    }
                }

                j = j + 1;
            }

            i = i + 1;
        }

        return cuentaEncontrada;
    }
}