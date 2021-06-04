class Money {
	private int value;
	private boolean bill;
	private String name;
	private int quantity;
	private int desiredQuantity;
	
	Money() { }
	Money(int value, String  name, boolean bill, int quantity, int desiredQuantity) {
		this.value = value;
		this.name = name;
		this.bill = bill;
		this.quantity = quantity;
		this.desiredQuantity = desiredQuantity;
	}	

	void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	int getQuantity() {
		return quantity;
	}

	void setValue(int value) {
		this.value = value;
	}
	int getValue() {
		return value;
	}

	void setBill(boolean bill) {
		this.bill = bill;
	}
	boolean isBill(){
		return bill;
	}

	void setName(String name) {
		this.name = name;
	}
	String getName() {
		return name;
	}

	void setDesiredQuantity(int desiredQuantity) {
		this.desiredQuantity = desiredQuantity;
	}
	int getDesiredQuantity() {
		return desiredQuantity;
	}
}