package MM1;


import org.jetbrains.annotations.NotNull;

public class ExpensesJava extends Movement {
    private String name;
    private String description;
    private float amount;
    private String date;

    public ExpensesJava(@NotNull String name, @NotNull String description, float amount, @NotNull String date, String name1, String description1, float amount1, String date1) {
        super(name, description, amount, date);
        this.name = name1;
        this.description = description1;
        this.amount = amount1;
        this.date = date1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public float getAmount() {
        return amount;
    }

    public void getInfoMovements() {
        System.out.println("Nombre " + this.name);
        System.out.println("Description " + this.description);
        System.out.println("Amount " + this.amount);
        System.out.println("Date " + this.date);
        System.out.println("-------------------------------------------");

    }

}
