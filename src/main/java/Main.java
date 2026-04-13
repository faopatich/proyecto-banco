void main() {
    var banco = new Banco();
    var persona1 = new Persona("Mateo", "La Boca", banco);
    var persona2 = new Persona("Carlos", "Tablada", banco);

    persona1.crearCuenta(TipoCuenta.CuentaCorriente);
    persona2.crearCuenta(TipoCuenta.CuentaCorriente);

    persona1.verBalance();
    persona2.verBalance();

    persona1.cargarSaldo(1000);

    persona1.transferir("Carlos", 100);

    System.out.println("\n\nLuego de la transferencia\n");
    persona1.verBalance();
    persona2.verBalance();
}