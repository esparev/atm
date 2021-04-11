public class Account {
	private String accountFirstName;
	private String accountLastName;
	private String phoneNumber;
	private String address;
	private int averageSalary;
	private int maxCredit;

	public Account() {	}
	public Account(String accountFirstName, String accountLastName, String address, int averageSalary, int maxCredit, String phoneNumber) {
		this.accountFirstName = accountFirstName;
		this.accountLastName = accountLastName;
		this.address = address;
		this.averageSalary = averageSalary;
		this.maxCredit = maxCredit;
		this.phoneNumber = phoneNumber;
	}
	
	public void setAccountFirstName(String accountFirstName) {
		this.accountFirstName = accountFirstName;
	}
	public String getAccountFirstName() {
		return accountFirstName;
	}

	public void setAccountLastName(String accountLastName) {
		this.accountLastName = accountLastName;
	}
	public String getAccountLastName() {
		return accountLastName;
	}

	public String getAccountFullName() {
		return accountFirstName + accountLastName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}

	public void setAverageSalary(int averageSalary) {
		this.averageSalary = averageSalary;
	}
	public int getAverageSalary() {
		return averageSalary;
	}

	public void setMaxCredit(int maxCredit) {
		this.maxCredit = maxCredit;
	}
	public int getMaxCredit() {
		return maxCredit;
	}
}
