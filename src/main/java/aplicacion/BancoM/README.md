# BancoM

El BancoM soporta múltiples sucursales con operaciones
cocurrentes (aunque esto aún está sujeto a pruebas).
A priori, un único hilo donde se simule la ejecución
del banco debería bastar.

BancoM no provee un `Main` de pruebas, pero acá se
detalla el funcionamiento de sus menúes.

## Estructura

En BancoM, existen los `Usuarios`, personas registradas
en las bases de datos del banco, y pueden ser de dos
tipos: `Cliente` o `Gestor de cuentas`.

Un Cliente es un usuario con una cuenta activa en el
banco. Un gestor de cuentas no tiene una cuenta activa,
pero tiene el poder de crear y eliminar cuentas.

Cada usuario puede solicitar la creación de una cuenta,
o la eliminación de una cuenta existente, indicando el
tipo de cuenta (ahorro/corriente). También puede ver
el estado de la cuenta y hacer transacciones.

Los gestores de cuentas pueden crear y eliminar cuentas
manualmente, pero generalmente van a manejar las
peticiones de creación y eliminación de cuentas de
los usuarios. Solo pueden hacer esto para la
sucursal en la que tengan permisos.

Cada usuario tiene un conjunto de roles, y un mínimo de
credenciales y datos: su nombre de usuario (único), su
contraseña, y su fecha de nacimiento (actualmente sin
uso). Para crear un usuario, referirse a la clase
[`GestorUsuariosConcurrente`](banco/concurrencia/GestorUsuariosConcurrente.java),
que no está protegida pero su uso está destinado
exclusivamente a crear y modificar usuarios de prueba,
al menos en las ejecuciones de prueba.

## Menú de cliente

El cliente puede ver el siguiente menú:

```
Menu de cliente

Escribe algunos de los siguientes comandos:
 1. crear <tipo>
 2. transferencia <banco> <num cuenta> <saldo>
 3. estado
 4. depositar
 5. retirar
 6. eliminar
 7. salir
```

Es necesario tipear el comando en sí.

Los tipos de  cuenta pueden ser `corriente` o
`ahorro`.

Los bancos pueden ser BancoM o `BancoF`.

Los números de cuenta arrancan en 0 y se van
incrementando de a 1, en BancoM.

## Menú de gestor de cuentas

El gestor de cuentas puede ver el siguiente menú:

```
Menu de gestor de cuentas

Escribe algunos de los siguientes comandos:
 1. manejar
 2. manejar <codigo>
 3. listar
 4. ayuda
 5. salir
```

Es necesario tipear el comando en sí.

El menú permite acceder a la lista de peticiones
pendientes con `listar`, manejarlas todas con
`manejar`, o alguna en puntual con `manejar` y
el código de la petición.

El comando `ayuda` imprime nuevamente el menú.
