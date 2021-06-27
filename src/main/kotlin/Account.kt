
class Account(
    var accountNname : String,
    var balance : Float = 0f,
    var currency : String = "MXN") {


    val list = mutableListOf<Movement>()

    fun getTransaccionList() {
        for (trans in list){
            println("Esta es la $trans")
        }
    }

    fun editBalance (newBalance : Float){
        balance = newBalance
    }






}