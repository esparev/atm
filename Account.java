class Account {
	private String accountFirstName;
	private String accountLastName;
	private String phoneNumber;
	private String address;
	private int averageSalary;
	private int maxCredit;

	Account() {	}
	Account(String accountFirstName, String accountLastName, String address, int averageSalary, int maxCredit, String phoneNumber) {
		this.accountFirstName = accountFirstName;
		this.accountLastName = accountLastName;
		this.address = address;
		this.averageSalary = averageSalary;
		this.maxCredit = maxCredit;
		this.phoneNumber = phoneNumber;
	}
	
	void setAccountFirstName(String accountFirstName) {
		this.accountFirstName = accountFirstName;
	}
	String getAccountFirstName() {
		return accountFirstName;
	}

	void setAccountLastName(String accountLastName) {
		this.accountLastName = accountLastName;
	}
	String getAccountLastName() {
		return accountLastName;
	}

	String getAccountFullName() {
		return accountFirstName + accountLastName;
	}

	void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	String getPhoneNumber() {
		return phoneNumber;
	}

	void setAddress(String address) {
		this.address = address;
	}
	String getAddress() {
		return address;
	}

	void setAverageSalary(int averageSalary) {
		this.averageSalary = averageSalary;
	}
	int getAverageSalary() {
		return averageSalary;
	}

	void setMaxCredit(int maxCredit) {
		this.maxCredit = maxCredit;
	}
	int getMaxCredit() {
		return maxCredit;
	}
}