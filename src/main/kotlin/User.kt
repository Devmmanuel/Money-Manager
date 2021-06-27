class User () {

    val userSaved : String = "user123"
    val passwordSaved : String = "12345"




    //función para loggear usuario
    fun login(user : String, password : String ) :Boolean {
        //Función para validar que es un String y no un espacio vacio
        fun validate(input: String): Boolean {
            if (input.isEmpty()) {
                return false
            }
            return true
        }

        val userValidated = validate(user)
        val passValidated = validate(password)
        return if (userValidated && passValidated) {
            user == userSaved && password == passwordSaved
        } else false

    }


}