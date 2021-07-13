package MM1

import java.lang.IllegalArgumentException

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

    fun getAccountLists() : Int{
        val sizeList = accountLists.size

        if (sizeList != 0) {
            println("El usuario  $username cuenta con las siguientes cuentas: ")
            accountLists.forEach {
                it.printDetails()
            }
        return 1
        }

        else {
            println("Lo siento $username aun no cuenta con ninguna cuenta")
            return 0
        }
    }

    fun getAccount(NombreDeCuenta : String) : Account? {
        //val cuenta1 : List<Account?>
            val cuenta1: List<Account?> = accountLists.filter { it.getAccountName() == NombreDeCuenta }

        if (cuenta1.size!=0){
            println("Has seleccionado la cuenta ${cuenta1[0]?.getAccountName()}")
            return cuenta1[0]
        }else{
            println("No existe esa cuenta, inténtelo de nuevo")
            return null
        }



        /*for (cuenta in accountLists){
            if (cuenta.getAccountName()==NombreDeCuenta){
                cuenta1 = cuenta
                println("Has seleccionado $NombreDeCuenta")
            }else{
                println("No existe esa cuenta")
            }
        }
         */

    }

    fun fail(message : String) :Nothing{
        throw IllegalArgumentException(message)
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

