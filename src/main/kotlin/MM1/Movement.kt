package MM1
data class Movement(
    private val name: String,
    private val description: String,
    private val amount: Float,
    private val date: String
) {

    fun getAmount() :Float {
        return amount
    }
    fun getInfoMovements() {
        println("Nombre: $name")
        println("Description: $description")
        println("Amount: $amount")
        println("Date: $date")
        println("-------------------------------------------")
    }


}
