
class Movement(
    private val name: String,
    private val description: String,
    private val amount: Float,
    private val period: String
) {

    fun getAmount() :Float {
        return amount
    }
    fun getPeriod() : String {
        return period
    }
    fun getInfoMovements() {
        println("Nombre: $name")
        println("Description: $description")
        println("Amount: $amount")
        println("Date: $period")
        println("-------------------------------------------")
    }


}
