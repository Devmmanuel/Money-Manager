
class User(
    var email: String,
    var password: String,
    var username: String,
    var balanceSheetGeneral: Float = 0f) {

    val accountLists = mutableListOf<Account>()
    var validSes : Boolean = false

    init {
        println("Thanks for join us")
    }

    fun getUserName() : String{
        return username
    }

    // Metodo para iniciar sesion que regresa true o false
    fun logIn() {
     
        println("Ingresa tu email")
        val inputEmail = readLine().toString()
        println("Ingresa tu contrasena")
        val inputPassword = readLine().toString()

        if (inputEmail == email && inputPassword == password) {
            println("Welcome $username")
            validSes=true

        } else {
            validSes=false
            println("email &/or password are incorrect")

        }
    }

    fun validSesion() :Boolean {
        return validSes
    }

    // Metodo para cerrar sesion
    fun logOut() {
        if (validSesion()) {
            validSes= false
            println("Cerrando Sesión")
        }
    }

    // funcion para crear una cuenta
    fun createAccount() {

        if (validSesion()){
            println("Ingresa el nombre de la cuenta: ")
            val accountName = readLine().toString()
            println("Ingresa el balance de la cuenta")
            val accountBalanceSheet = readLine()!!.toFloat()
            println("Ingresa la divisa de la cuenta")
            val accountCoin = readLine().toString()

            balanceSheetGeneral += accountBalanceSheet
            val accountCreated = Account(accountName, accountBalanceSheet, accountCoin)

            accountLists.add(accountCreated)
        }

        else {
            println("Para crear una cuenta primero debes de iniciar sesion")
        }
    }

    // funcion para cambiar la contraseña o Email
    fun changePasswordOrEmail(){
        println("Que deseas cambiar la contrasena o el Email")
        val opcion = readLine().toString().lowercase()

        val input: String

        when(opcion){
            "contrasena" -> {
                println("Ingresa tu contrasena actual")
                input = readLine().toString()
                if(input == password){
                    println("Ingresa la nueva contraseña")
                    password = readLine().toString()
                }
                else{
                    println("Lo siento las contraseñas no coinciden")
                }
            }
            "email" -> {
                println("Ingresa tu correo actual")
                input = readLine().toString()
                if(input == email){
                    println("Ingresa tu nuevo correo")
                    password = readLine().toString()
                }
                else{
                    println("Lo siento los correos no coinciden")
                }
            }
        }
    }

    fun getAccountLists(){

        val sizeList = accountLists.size

        if (sizeList != 0) {
            println(" el usuario  $username cuenta con las siguientes cuentas: ")
            accountLists.forEach {
                println(" -> ${it.printDetails()} ")
            }
        }

        else {
            println("Lo siento $username aun no cuentas con ninguna cuenta")
        }
    }

    fun getAccount(NombreDeCuenta : String) : Account{
        var cuenta1 = Account("Null",0f)
        for (cuenta in accountLists){
            if (cuenta.getAccountName()==NombreDeCuenta){
                cuenta1 = cuenta
                println("Has seleccionado $NombreDeCuenta")
            }else{
                println("No existe esa cuenta")
            }
        }
        return cuenta1
    }
    fun getGeneralBalance() : Float{
        var TotalBalance = 0f
        for (cuenta in accountLists){
            TotalBalance+=cuenta.getTotalIncome()
            TotalBalance-=cuenta.getTotalExpense()
        }
        return TotalBalance
    }

    fun desplegarMenu() {
        do {
            println("-----Bienvenido ${getUserName()}-----")
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
                    createAccount()
                }
                "2" -> {
                    println("-------------------------------------------")
                    getAccountLists()
                    println("-------------------------------------------")
                }
                "3" -> {
                    println("A que cuenta desea agregar el gasto")
                    getAccountLists()

                    println("Teclee el nombre de la cuenta")
                    val opcion = readLine().toString()
                    val cuenta = getAccount(opcion)

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
                    getAccountLists()

                    println("Teclee el nombre de la cuenta")
                    val opcion = readLine().toString()
                    val cuenta = getAccount(opcion)

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
                    getAccountLists()

                    println("Teclee el nombre de la cuenta")
                    val opcion = readLine().toString()
                    val cuenta = getAccount(opcion)
                    cuenta.printExpensesList()
                }
                "6" -> {
                    println("De que cuenta desea visualizar los Ingresos")
                    getAccountLists()

                    println("Teclee el nombre de la cuenta")
                    val opcion = readLine().toString()
                    val cuenta = getAccount(opcion)
                    cuenta.printIncomeList()
                }
                "7" -> logOut()
            }

        }while (choice != "7")
    }

}

