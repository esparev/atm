public class Money {
	private int value;
	private boolean bill;
	private String name;
	private int quantity;
	private int desiredQuantity;
	
	public Money() { }
	public Money(int value, String  name, boolean bill, int quantity, int desiredQuantity) {
		this.value = value;
		this.name = name;
		this.bill = bill;
		this.quantity = quantity;
		this.desiredQuantity = desiredQuantity;
	}	

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setValue(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}

	public void setBill(boolean bill) {
		this.bill = bill;
	}
	public boolean isBill(){
		return bill;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setDesiredQuantity(int desiredQuantity) {
		this.desiredQuantity = desiredQuantity;
	}
	public int getDesiredQuantity() {
		return desiredQuantity;
	}
}
