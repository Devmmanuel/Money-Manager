package MM1
 abstract class Movement(
    private val name: String,
    private val description: String,
    private val amount: Float,
    private val date: String
) {

     abstract fun getAmount() : Float
    abstract fun getInfoMovements()


 }
