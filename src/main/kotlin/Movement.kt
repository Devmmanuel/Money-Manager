class Movement(
    val name: String,
    val description: String,
    val amount: Float,
    val period: String,
) {


    fun getInfoMovements() {
        println("Nombre: $name")
        println("Description: $description")
        println("Amount: $amount")
        println("Date: $period")
        println("-------------------------------------------")
    }

}