


fun main() {


    //Inicio Codigo de prueba
    val cuenta1 = Account("Main")
    cuenta1.getBalance()
    cuenta1.editBalance(100f)
    println("El balance de la cuenta ${cuenta1.getAccountName()} es ${cuenta1.getBalance()}")
    cuenta1.printDetails()
    //cuenta1.getTransaccionList()

    val user1 = User()
    val sesion = user1.login("user123","12345")
    if (sesion) {
        println("Ha inciado sesión el usuario user123")}

    //Fin Codigo de prueba



    var income = mutableListOf<Movement>()
    var expenses = mutableListOf<Movement>()

    var totalAmountIncome = 0f;
    var totalAmountExpenses = 0f;


    expenses.add(Movement("netflix", "pagar cada mes", 200f, "Month"))
    expenses.add(Movement("agua", "pagar cada mes", 100f, "Day"))
    income.add(Movement("Quincena", "pagar cada mes", 100f, "Month"))


    income.forEach {
        totalAmountIncome += it.amount;
    }

    expenses.forEach {
        totalAmountExpenses += it.amount;
    }

    income.forEach { it.getInfoMovements() }

    expenses.forEach { it.getInfoMovements() }


    println("Tu total de gastos $totalAmountExpenses")
    println("Tu total de Ingresos $totalAmountIncome")



    //Filtrar por mes
    expenses.forEach {
        if (it.period == "Month") {
            println(".....Gastos por mes.......")
            it.getInfoMovements()
        }
    }

    //Filtrar por movimiento

    expenses.forEach {
        if (it.period == "Day") {
            println(".....Gastos por dia.......")
            it.getInfoMovements()
        }
    }


}