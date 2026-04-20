📋 Sistema de Menús – BancoF
🧭 Descripción general

El sistema de menús de BancoF está diseñado para funcionar por consola y organiza la interacción del usuario según su rol dentro del banco.

Cada usuario, una vez autenticado, accede a un menú específico que le permite ejecutar distintas acciones sobre el sistema.

El flujo general es:

El usuario inicia sesión
El sistema identifica su rol
Se muestra el menú correspondiente
El usuario ingresa opciones
Se ejecutan operaciones hasta que decide salir
👤 Tipos de menú según usuario
🧑‍💼 Menú de Cliente

Permite a los clientes operar sobre su propia cuenta.

Funcionalidades disponibles:
💰 Consultar saldo
➕ Depositar dinero
➖ Retirar dinero
🔄 Transferir dinero
📜 Ver historial de operaciones
Ejemplo de flujo:
1. Consultar saldo
2. Depositar dinero
3. Retirar dinero
4. Transferir dinero
5. Ver historial
0. Salir

👉 Ejemplo práctico:

El cliente elige 3
Ingresa el monto
El sistema valida fondos
Se realiza el retiro
Se registra la operación en el historial
🧑‍💻 Menú de Administrador de Sucursal

Permite gestionar clientes y cuentas dentro de su sucursal.

Funcionalidades disponibles:
👥 Crear clientes
🏦 Crear cuentas
❌ Desactivar cuentas
📊 Ver historial de operaciones de la sucursal
Restricción importante:

El administrador solo puede operar sobre su propia sucursal.

🔄 Funcionamiento interno del menú

Los menús funcionan mediante un bucle que:

Muestra las opciones disponibles
Espera input del usuario (Scanner)
Ejecuta la acción correspondiente
Vuelve a mostrar el menú

Ejemplo simplificado:

while (true) {
mostrarOpciones();
int opcion = scanner.nextInt();

    switch (opcion) {
        case 1:
            consultarSaldo();
            break;
        case 2:
            depositar();
            break;
        case 0:
            return;
    }
}
💸 Transferencias

Para realizar una transferencia, el sistema solicita:

Número de cuenta destino
Monto a transferir
Validaciones:
La cuenta destino debe existir
El saldo debe ser suficiente
Flujo:
Se debita el monto de la cuenta origen
Se acredita en la cuenta destino
Se registra la operación en ambas cuentas
📜 Historial de operaciones

Cada operación realizada se guarda en un historial que incluye:

Tipo de operación (depósito, retiro, transferencia)
Monto
Fecha
Acceso:
👤 Cliente → solo sus operaciones
🧑‍💼 Admin → todas las operaciones de su sucursal
⚠️ Validaciones del sistema

El menú contempla validaciones básicas:

Opciones inválidas → se vuelve a pedir input
Fondos insuficientes → operación rechazada
Cuenta inexistente → error en transferencia