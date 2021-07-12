package MM1

class User(
    private var email: String,
    private var password: String,
    private var username: String) {

    val accountLists = mutableListOf<Account>()
    var validSes : Boolean = false

    init {
        //println("Gracias por unirte a Money Manager")
    }

    fun getUserName() : String{
        return username
    }
    fun getEmail() : String {
        return email
    }

    // Metodo para iniciar sesion que regresa true o false
    fun logIn(inputEmail : String, inputPassword : String) :Boolean{

        if (inputEmail == email && inputPassword == password) {
            //println("Bienvenido $username")
            validSes=true
            return true

        } else {
            validSes=false
            //println("Email y/o contraseña incorrectos")
            return false
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

            val accountCreated = Account(accountName, accountBalanceSheet, accountCoin)

            accountLists.add(accountCreated)

            println("La cuenta $accountName ha sido creada")
            println()
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
            println("El usuario  $username cuenta con las siguientes cuentas: ")
            accountLists.forEach {
                it.printDetails()
            }
        }

        else {
            println("Lo siento $username aun no cuenta con ninguna cuenta")
        }
    }

    fun getAccount(NombreDeCuenta : String) : Account {
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



}

