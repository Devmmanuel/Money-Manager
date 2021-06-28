


fun main() {


    //Inicio Codigo de prueba
    val cuenta1 = Account("Main")
    cuenta1.getBalance()
    //cuenta1.editBalance(100f)
    println("El balance de la cuenta ${cuenta1.getAccountName()} es ${cuenta1.getBalance()}")
    cuenta1.printDetails()
    val transaccion1 = Movement("Netflix","Pago de la suscripción mensual",199f,"16/06/2021")
    val transaccion2 = Movement("DisneyPlus","Pago de la suscripcion",100f,"20/06/2021")

    cuenta1.addExpense(transaccion1)
    cuenta1.addExpense(transaccion2)

    cuenta1.printExpensesList()
    println("---------------------------CORTE--------------------------------------")

    /*
    val user1 = User()
    val sesion = user1.login("user123","12345")
    if (sesion) {
        println("Ha inciado sesión el usuario user123")}

    //Fin Codigo de prueba

*/

    cuenta1.addExpense(Movement("netflix", "pagar cada mes", 200f, "Month"))
    cuenta1.addExpense(Movement("agua", "pagar cada mes", 100f, "Day"))
    cuenta1.addIncome(Movement("Quincena", "pagar cada mes", 100f, "Month"))


    cuenta1.printExpensesList()
    cuenta1.printIncomeList()

    //Metodos de acceso a los datos de gasto, ingreso y balance de "cuenta1"

    println("Tu total de gastos ${cuenta1.getTotalExpense()}")
    println("Tu total de Ingresos ${cuenta1.getTotalIncome()}")
    println("Tu balance general es ${cuenta1.getBalance()}")



    //Filtrar por mes
    /*
    cuenta1.getExpensesList() {
        if (it.getPeriod() == "Month") {
            println(".....Gastos por mes.......")
            it.getInfoMovements()
        }
    }

    //Filtrar por movimiento

    expenses.forEach {
        if (it.getPeriod() == "Day") {
            println(".....Gastos por dia.......")
            it.getInfoMovements()
        }
    }
*/

    val user = User("dev@gmail.com","password","emmanuel")

    user.logIn()
    user.desplegarMenu()




}