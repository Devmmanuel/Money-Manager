package MM1

class Incomes(private val name: String,
              private val description: String,
              private val amount: Float,
              private val date: String) : Movement(name, description, amount, date) {


        override fun getAmount() :Float {
            return amount
        }


        override  fun getInfoMovements(){
            println("Nombre: $name")
            println("Description: $description")
            println("Amount: $amount")
            println("Date: $date")
            println("-------------------------------------------")
        }




    }