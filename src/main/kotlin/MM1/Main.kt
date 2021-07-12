package MM1


fun main() {


    //Inicio Codigo de prueba
    /*
    val cuenta1 = MM1.Account("Main")
    cuenta1.getBalance()
    //cuenta1.editBalance(100f)
    println("El balance de la cuenta ${cuenta1.getAccountName()} es ${cuenta1.getBalance()}")
    cuenta1.printDetails()
    val transaccion1 = MM1.Movement("Netflix","Pago de la suscripción mensual",199f,"16/06/2021")
    val transaccion2 = MM1.Movement("DisneyPlus","Pago de la suscripcion",100f,"20/06/2021")

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

    cuenta1.addExpense(MM1.Movement("netflix", "pagar cada mes", 200f, "Month"))
    cuenta1.addExpense(MM1.Movement("agua", "pagar cada mes", 100f, "Day"))
    cuenta1.addIncome(MM1.Movement("Quincena", "pagar cada mes", 100f, "Month"))


    cuenta1.printExpensesList()
    cuenta1.printIncomeList()
*/
    //Metodos de acceso a los datos de gasto, ingreso y balance de "cuenta1"

    //println("Tu total de gastos ${cuenta1.getTotalExpense()}")
    //println("Tu total de Ingresos ${cuenta1.getTotalIncome()}")
    //println("Tu balance general es ${cuenta1.getBalance()}")


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
    desplegarMenu(user)




}
fun desplegarMenu(user : User) {
    do {
        println("-----Bienvenido ${user.getUserName()}-----")
        println("¿Que acción desea realizar")
        println(
            """
            1 -> Agregar una cuenta
            2 -> Ver Cuentas
            3 -> Agregar una gasto
            4 -> Agregar un ingreso
            5 -> Ver gastos
            6 -> Ver Ingresos
            7 -> Cerrar Sesion""".trimMargin()

        )
        val choice = readLine().toString()
        when (choice) {
            "1" -> {
                user.createAccount()
            }
            "2" -> {
                println("-------------------------------------------")
                user.getAccountLists()
                println("-------------------------------------------")
            }
            "3" -> {
                println("A que cuenta desea agregar el gasto")
                user.getAccountLists()

                println("Teclee el nombre de la cuenta")
                val opcion = readLine().toString()
                val cuenta = user.getAccount(opcion)

                println("Ingresa el nombre del gasto: ")
                val nombreGasto = readLine().toString()
                println("Ingresa una descripción del gasto")
                val descripcionGasto = readLine().toString()
                println("Ingresa el monto del gasto")
                val montoGasto = readLine()!!.toFloat()
                println("Ingresa la fecha del gasto")
                val fechaGasto = readLine().toString()
                cuenta.addExpense(Movement(nombreGasto, descripcionGasto, montoGasto, fechaGasto))
            }
            "4" -> {
                println("A que cuenta desea agregar el ingreso")
                user.getAccountLists()

                println("Teclee el nombre de la cuenta")
                val opcion = readLine().toString()
                val cuenta = user.getAccount(opcion)

                println("Ingresa el nombre del ingreso: ")
                val nombreIngreso = readLine().toString()
                println("Ingresa una descripción del ingreso")
                val descripcionIngreso = readLine().toString()
                println("Ingresa el monto del ingreso")
                val montoIngreso = readLine()!!.toFloat()
                println("Ingresa la fecha del ingreso")
                val fechaIngreso = readLine().toString()
                cuenta.addIncome(Movement(nombreIngreso, descripcionIngreso, montoIngreso, fechaIngreso))
            }
            "5" -> {
                println("De que cuenta desea visualizar los gastos")
                user.getAccountLists()

                println("Teclee el nombre de la cuenta")
                val opcion = readLine().toString()
                val cuenta = user.getAccount(opcion)
                cuenta.printExpensesList()
            }
            "6" -> {
                println("De que cuenta desea visualizar los Ingresos")
                user.getAccountLists()

                println("Teclee el nombre de la cuenta")
                val opcion = readLine().toString()
                val cuenta = user.getAccount(opcion)
                cuenta.printIncomeList()
            }
            "7" -> user.logOut()
        }

    }while (choice != "7")
}