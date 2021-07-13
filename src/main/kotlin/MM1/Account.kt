package MM1

class Account(
    private var accountName : String,
    private var balanceInicial : Float = 0f,
    private var currency : String = "MXN") {


    private val expenses = mutableListOf<Movement>()
    private var incomes = mutableListOf<Movement>()

    //private var totalAmountIncome = 0f;
    //private var totalAmountExpenses = 0f;


    fun printExpensesList() {
        println("-------------------------------------------")
        println("---------------EXPENSES LIST---------------")
        println("-------------------------------------------")
        expenses.forEach { it.getInfoMovements() }
        println()
    }
    fun printIncomeList() {
        println("-------------------------------------------")
        println("----------------INCOMES LIST---------------")
        println("-------------------------------------------")
        incomes.forEach { it.getInfoMovements() }
        println()
    }

    fun editBalance (newBalance : Float){ //Funcion especial, lo mejor es no usarlo
        balanceInicial = newBalance
    }

    fun getBalance() :Float {
        return balanceInicial + getTotalIncome() - getTotalExpense()
    }

    fun getAccountName() : String {
        return accountName
    }

    fun printDetails(){
        println("""
            Nombre de la cuenta:     $accountName 
            Balance de la cuenta:    ${getBalance()} $currency
            ----------------------------------------------------""".trimMargin())
    }

    fun addExpense(movement : Movement) {
        expenses.add(movement)
        //totalAmountExpenses +=movement.getAmount()
        //balance -= movement.getAmount()
    }
    fun addIncome(movement: Movement) {
        incomes.add(movement)
        //totalAmountIncome +=movement.getAmount()
        //balance +=movement.getAmount()
    }

    //Metodo que retorna el dato calculado en base a la lista de incomes
    fun getTotalIncome() : Float {
        var TotalIncome : Float = 0f
        incomes.map { TotalIncome += it.getAmount() }
        return TotalIncome
    }

    //Metodo que retorna el dato calculado en base a la lista de expenses
    fun getTotalExpense() : Float {
        var totalExpense : Float = 0f
        expenses.map { totalExpense +=it.getAmount() }
        return totalExpense
    }


}