# Proyeto Banco

Interfaz de línea de comandos:

```
- Ingrese en el formato: <banco> <codigo-sucursal> <usuario> <contraseña>

BancoF S002 palermo 1234
```

[Documentación de BancoF](https://github.com/faopatich/proyecto-banco/blob/main/src/main/java/aplicacion/BancoF/ReadMe.md)

[Documentación de BancoM](https://github.com/faopatich/proyecto-banco/blob/main/src/main/java/aplicacion/BancoM/README.md)

## Sucursales

Cada banco tiene sucursales, con código de sucursal, y cada código tiene su propio
formato. Para las sucursales de BancoF, el formato es

```
S<contador> -- contador = abc
```

La letra S es igual siempre, y el contador son tres dígitos (que pueden ser 0) y va
creciendo de a uno con cada sucursal (es un contador). Arranca en 0.

Para BancoM, los códigos de sucursales son un nombre arbitrario, generalmente asociados
a la ubicación de la sucursal.

## Usuarios

Caba banco tiene usuarios, que pueden ser clientes (tienen una cuenta) o admins, y el
concepto de admin en cada banco puede ser distinto. En BancoF, el admin tiene el poder
de realizar varias operaciones en su sucursal; en BancoM, no existe un 'admin' sino un
gestor de cuentas, que puede crear y eliminar cuentas, y eso lo hace manejando los pedidos
de creación/eliminación de cuentas emitidos por los usuarios.

Cada usuario tiene sus credenciales, mínimamente un username y contraseña, que se validan
para hacer su login. Colocar las credenciales incorrectas lleva a un mensaje de login
inválido; el usuario no puede indicar su propio rol, lo gestiona el banco internamente.

## Ejemplo

El ejemplo de ejecución del `Main`:

```java
package aplicacion;

import aplicacion.BancoF.*;
import aplicacion.BancoM.banco.BancoM;
import aplicacion.BancoM.cuentas.TipoCuenta;
import aplicacion.BancoM.usuarios.PerfilUsuario;
import aplicacion.interfazComun.Aplicacion;
import aplicacion.interfazComun.ManejadorTransacciones;
import aplicacion.interfazComun.MenuAplicacion;
import aplicacion.interfazComun.ServicioEntrada;

import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Banco bancoF = new Banco("BancoF");
        BancoM bancoM = new BancoM();
        bancoM.agregaSucursal("paseo-colon");
        bancoM.agregaSucursal("av-brasil");

        var perfilMateo = new PerfilUsuario("Mateo", "Contr", "Hoy");
        var perfilGestor1 = new PerfilUsuario("Gestor1", "Contr", "Hoy");
        var perfilGestor2 = new PerfilUsuario("Gestor2", "Contr", "Hoy");
        bancoM.agregarCliente(perfilMateo);
        bancoM.agregarGestorCuentas(perfilGestor1, "paseo-colon");
        bancoM.agregarGestorCuentas(perfilGestor2, "av-brasil");
        bancoM.agregarCuenta(perfilMateo.generarCredenciales(), TipoCuenta.CuentaAhorro);


        AdminSucursal adminCentral = UsuarioFactory.crearAdminSucursal(
                "Admin Central",
                "11111111",
                "central",
                "1234",
                "S001"
        );

        AdminSucursal adminPalermo = UsuarioFactory.crearAdminSucursal(
                "Admin Palermo",
                "22222222",
                "palermo",
                "1234",
                "S002"
        );
        var sucursal = new Sucursal("S001", "Casa Central", adminCentral);
        bancoF.agregarSucursal(sucursal);
        bancoF.agregarSucursal(new Sucursal("S002", "Palermo", adminPalermo));

        MenuAplicacion menuAplicacion = new MenuAplicacion(bancoF, bancoM);
        ManejadorTransacciones manejadorTransacciones = new ManejadorTransacciones(bancoF, bancoM);
        Aplicacion app = new Aplicacion(menuAplicacion);
        Scanner scanner = new Scanner(System.in);
        ServicioEntrada servicioEntrada = new ServicioEntrada(scanner);
        app.ejecutar(servicioEntrada, manejadorTransacciones);
    }
}
```

En este ejemplo, las combinaciones válidas son:
1. BancoF S001 central 1234
2. BancoF S002 palermo 1234
3. BancoM <sucursal> Mateo Contr
4. BancoM paseo-colon Gestor1 Contr
5. BancoM av-brasil Gestor2 Contr

También se dispone del comando `salir`.

### Notas
1. En BancoM, el cliente (Mateo) puede hacer login en cualquier sucursal,
pero los gestores de cuentas solo pueden hacerlo en sus sucursales.
2. En BancoF, para crear un cliente debe primero inciarse sesión como
admin y crearlo, y asignarle una cuenta, desde su menú.
