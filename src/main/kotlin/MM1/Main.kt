package MM1

import java.lang.IllegalArgumentException


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
    //Set Default Settings
    val user = User("dev@gmail.com","password","emmanuel")
    user.accountLists.add(Account("Main",0f,"MXN"))

    //Lista de usuarios dentro de la app
    val listaUsers = mutableListOf<User?>(user)
    var currentUser :User? =null

    do {
        println("¡¡Gracias por utilizar Money Manager!!")
        println("¿Que acción desea realizar?")
        println(
            """
            1 -> Iniciar Sesion
            2 -> Crear nuevo usuario
            3 -> Cerrar aplicación""".trimMargin()
        )
        val choice = readLine().toString()
        when (choice) {
            "1" -> {
                currentUser = cargarUser(listaUsers)
                if (currentUser != null) {
                    desplegarMenu(currentUser)
                }
            }
            "2" -> {

                var inputEmail = ""

                print("Ingrese un username: ")
                val inputUserName = readLine().toString()
                var mailvalid = false

                //Si no se ingresa un email válido, se seguirá pidiendo que se ingrese
                while(mailvalid != true){
                    print("Ingrese un email valido: ")
                    //Expresion regular que valida que es un email
                    val expreg_mail = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
                    inputEmail = readLine().toString()
                    mailvalid = expreg_mail.toRegex().matches(inputEmail)
                }

                //Usuario crea contraseña
                print("Ingrese una contraseña: ")
                val inputPassword = readLine().toString()
                //Se crea el usuario
                listaUsers.add(User(inputEmail, inputPassword, inputUserName))
                println("Usuario $inputUserName creado exitosamente")
            }


            "3" -> {
                println("Cerrando aplicación")
            }
        }
    }while(choice!="3")


}

fun cargarUser(listaU : List<User?>) : User? {
    var userVal = false
    var passwVal = false
    var usuario :User? = null
    println("Ingrese su email")
    val inputEmail = readLine().toString()
    listaU.forEach{
        if(it?.getEmail()==inputEmail){
            println("Hola ${it.getUserName()}")
            usuario = it
            userVal = true
        }
    }
    if (!userVal){
        println("--No se encuentra registrado ese email, inténtelo de nuevo--")
    }
    if(userVal) {
        println("Ingrese su contraseña")
        val inputPassword = readLine().toString()
        passwVal= usuario?.logIn(inputEmail,inputPassword)!!
        if(passwVal){
            println("Sesión iniciada correctamente, ${usuario?.getUserName()}")
            return usuario
        }else{
            println("--Su contraseña es incorrecta, inténtelo de nuevo--")
        }
    }
    return null
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
                val gastos = user.getAccountLists()

                    if(gastos != 0){
                        println("A que cuenta desea agregar el gasto")
                        val cuenta = cargarCuenta(user)
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

            }
            "4" -> {
                val ingreso = user.getAccountLists()

                if(ingreso!= 0 ){
                    println("A que cuenta desea agregar el ingreso")
                    val cuenta = cargarCuenta(user)
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

            }
            "5" -> {
                val ver_gastos = user.getAccountLists()
                if(ver_gastos != 0){
                    println("De que cuenta desea visualizar los gastos")
                    val cuenta = cargarCuenta(user)
                    cuenta.printExpensesList()
                }

            }
            "6" -> {
                val ver_ingreso = user.getAccountLists()

                if(ver_ingreso != 0){
                    println("De que cuenta desea visualizar los Ingresos")
                    val cuenta = cargarCuenta(user)
                    cuenta.printIncomeList()
                }

            }
            "7" -> user.logOut()
        }

    }while (choice != "7")
}

fun cargarCuenta(user : User) : Account{
    var cuenta : Account?
    do {
        println("Teclee el nombre de la cuenta")
        val opcion = readLine().toString()
        cuenta= user.getAccount(opcion)
    }while (cuenta==null)
    return cuenta
}