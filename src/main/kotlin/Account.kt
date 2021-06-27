
class Account(
    private var accountNname : String,
    private var balance : Float = 0f,
    private var currency : String = "MXN") {


    private val list = mutableListOf<Movement>()

    fun getTransaccionList() {
        for (trans in list){
            println("Esta es la $trans")
        }
    }

    fun editBalance (newBalance : Float){
        balance = newBalance
    }

    fun getBalance() {
        println("El balnce de la cuenta es $balance")
    }






}