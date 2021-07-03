package esparev.atm;

public class Money {
    private final int value;
    private final String name;
    private final boolean bill;
    private int quantity;
    private final int desiredQuantity;

    public Money(int value, String name, boolean bill, int quantity, int desiredQuantity) {
        this.value = value;
        this.name = name;
        this.bill = bill;
        this.quantity = quantity;
        this.desiredQuantity = desiredQuantity;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public boolean isBill() {
        return bill;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDesiredQuantity() {
        return desiredQuantity;
    }

}
