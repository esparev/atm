public class Card {
	private int monthExpiration;
	private int yearExpiration;
	private String operator;
	private boolean debit;
	private int cvv;
	private Account account = new Account();
	private String cardNumber;
	
	public Card() { }
	public Card(int monthExpiration, int yearExpiration, String operator, boolean debit, int cvv, Account account, String cardNumber) {
		this.monthExpiration = monthExpiration;
		this.yearExpiration = yearExpiration;
		this.operator = operator;
		this.debit = debit;
		this.cvv = cvv;
		this.account = account;
		this.cardNumber = cardNumber;
	}

	public void setMonthExpiration(int monthExpiration) {
		this.monthExpiration = monthExpiration;
	}
	public int getMonthExpiration() {
		return monthExpiration;
	}

	public void setYearExpiration(int yearExpiration) {
		this.yearExpiration = yearExpiration;
	}
	public int getYearExpiration() {
		return yearExpiration;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperator() {
		return operator;
	}

	public void setDebit(boolean debit) {
		this.debit = debit;
	}
	public boolean getDebit() {
		return debit;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public int getCvv() {
		return cvv;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	public String getAccount() {
		return account.getAccountFullName();
	}
	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardNumber() {
		return cardNumber;
	}
}
