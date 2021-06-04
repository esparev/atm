class Card {
	private int monthExpiration;
	private int yearExpiration;
	private String operator;
	private boolean debit;
	private int cvv;
	private Account account = new Account();
	private String cardNumber;
	
	Card() { }
	Card(int monthExpiration, int yearExpiration, String operator, boolean debit, int cvv, Account account, String cardNumber) {
		this.monthExpiration = monthExpiration;
		this.yearExpiration = yearExpiration;
		this.operator = operator;
		this.debit = debit;
		this.cvv = cvv;
		this.account = account;
		this.cardNumber = cardNumber;
	}

	void setMonthExpiration(int monthExpiration) {
		this.monthExpiration = monthExpiration;
	}
	int getMonthExpiration() {
		return monthExpiration;
	}

	void setYearExpiration(int yearExpiration) {
		this.yearExpiration = yearExpiration;
	}
	int getYearExpiration() {
		return yearExpiration;
	}

	void setOperator(String operator) {
		this.operator = operator;
	}
	String getOperator() {
		return operator;
	}

	void setDebit(boolean debit) {
		this.debit = debit;
	}
	boolean getDebit() {
		return debit;
	}

	void setCvv(int cvv) {
		this.cvv = cvv;
	}
	int getCvv() {
		return cvv;
	}

	void setAccount(Account account) {
		this.account = account;
	}
	String getAccount() {
		return account.getAccountFullName();
	}
	
	void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	String getCardNumber() {
		return cardNumber;
	}
}