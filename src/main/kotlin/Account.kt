
class Account(
    private var accountName : String,
    private var balance : Float = 0f,
    private var currency : String = "MXN") {


    private val list = mutableListOf<Movement>()
/*
    fun getTransaccionList() {
        for (trans in list){
            println("Esta es la ${trans.getName()} de ${trans.getAmount()}")
        }
    }

 */

    fun editBalance (newBalance : Float){
        balance = newBalance
    }

    fun getBalance() :Float {
        return balance
    }
    fun getAccountName() : String {
        return accountName
    }
    fun addMovement(movement : Movement) {
        list.add(movement)
    }

    fun printDetails(){
        println("""
            El nombre de la cuenta es $accountName 
            El balance de la cuenta es $balance $currency""".trimMargin())
    }






}