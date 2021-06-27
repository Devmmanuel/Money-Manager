


fun main() {


    //Inicio Codigo de prueba
    val cuenta1 = Account("Main")
    cuenta1.getBalance()
    cuenta1.editBalance(100f)
    println("El balance de la cuenta ${cuenta1.getAccountName()} es ${cuenta1.getBalance()}")
    cuenta1.printDetails()
    val transaccion1 = Movement("Netflix",199f)
    val transaccion2 = Movement("DisneyPlus",100f)

    cuenta1.addMovement(transaccion1)
    cuenta1.addMovement(transaccion2)

    cuenta1.getTransaccionList()

    val user1 = User()
    val sesion = user1.login("user123","12345")
    if (sesion) {
        println("Ha inciado sesión el usuario user123")}

    //Fin Codigo de prueba
}