
class User(
    var email: String,
    var password: String,
    var username: String,
    var balanceSheetGeneral: Float = 0f,
    var totalExpenses: Float = 0f ) {

    val accountLists = mutableListOf<Account>()

    init {
        println("Thanks for join us")
    }


    // Metodo para iniciar sesion que regresa true o false
    fun logIn(): Boolean {
     
        println("Ingresa tu email")
        val inputEmail = readLine().toString()
        println("Ingresa tu contrasena")
        val inputPassword = readLine().toString()

        return if (inputEmail == email && inputPassword == password) {
            println("Welcome $username")
            true
        } else {
            println("email &/or password are incorrect")
            false
        }
    }

    // Metodo para cerrar sesion
    fun logOut() {
        if (logIn()) {
            println("Cerrando Sesión")
        }
    }

    // funcion para crear una cuenta
    fun createAccount() {

        if (logIn()){
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
        val opcion = readLine().toString().toLowerCase()

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
        println("El usuario cuenta con las siguientes cuentas: ")
        accountLists.forEach {
            println("${it.accountName} con un balance de ${it.balance} y una divisa ${it.currency}")
        }
    }

}

