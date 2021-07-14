package MM1

class Account(
    private var accountName : String,
    private var balanceInicial : Float = 0f,
    private var currency : String = "MXN") {


    private val expenses = mutableListOf<Expenses>()
    private var incomes = mutableListOf<Incomes>()

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
        return balanceInicial + getTotal(incomes) - getTotal(expenses)
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

    fun addExpense(movement : Expenses) {
        expenses.add(movement)
        //totalAmountExpenses +=movement.getAmount()
        //balance -= movement.getAmount()
    }
    fun addIncome(movement: Incomes) {
        incomes.add(movement)
        //totalAmountIncome +=movement.getAmount()
        //balance +=movement.getAmount()
    }



    //Metodo que retorna el dato calculado en base a la lista de incomes


    //Metodo que retorna el dato calculado en base a la lista de expenses


    fun getTotal(Lista : List<Movement>) : Float {
        var Total : Float = 0f
        Lista.map { Total += it.getAmount() }
        return Total
    }



}