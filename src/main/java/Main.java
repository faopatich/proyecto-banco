void main() {
    var banco = new Banco();
    var servicioComando = new ServicioComando();
    var administrador = new Administrador(banco, servicioComando);

    administrador.procesarComando(); // Crear cuenta de Mateo
    administrador.procesarComando(); // Crear cuenta de Carlos

    var persona1 = new Persona("Mateo", "La Boca", banco);
    var persona2 = new Persona("Carlos", "Tablada", banco);

    persona1.verBalance();
    persona2.verBalance();

    persona1.cargarSaldo(1000);

    persona1.transferir("Carlos", 100);

    System.out.println("\n\nLuego de la transferencia\n");
    persona1.verBalance();
    persona2.verBalance();
}