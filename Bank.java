import java.util.Calendar;

public class Bank {
	private Card cards[] = new Card[5];
	private Account accounts[] = new Account[5];

	/**
	 * The method initializes the arrays accounts with 5 indexes and the array of cards with 10 indexes.
	 */
	public void initializeBank() {
		accounts[0] = new Account("Frank ", "Sinatra ", "The Street 52", 3000, 30000, "3334445556");
		accounts[1] = new Account("Edward ", "Richtofen ", "Trinity Ave. 115", 2200, 35000, "5566778899");
		accounts[2] = new Account("Jose ", "Esparev ", "A Street With Name But No Number", 1500, 20000, "0011223344");
		accounts[3] = new Account("Mason ", "De Santa", "Phyric Victory 11", 1850, 23000, "4433221100");
		accounts[4] = new Account("Michael ", "Townley", "A Street With No Name 13", 8500, 50000, "9988776655");

		cards[0] = new Card(10, 2020, "Visa", true, 333,	accounts[0],	"1111111111111111");
		cards[1] = new Card(3, 2021, "Mastercard", false, 911,	accounts[1], "0000000000000000");
		cards[2] = new Card(2, 2019, "American Express", true, 666, accounts[2], "3333333333333333");
		cards[3] = new Card(6, 2022, "Visa", true, 164, accounts[3], "9999999999999999");
		cards[4] = new Card(12, 2019, "American Express", true, 566,	accounts[4], "7777777777777777");
	}

	/**
	 * Method that recieves a card number and searches for that card number in the array of cards. In the event that it exists, it will indicate that the user was found and it will show their data and otherwise it will show an error message.
	 * @param cardNumber
	 */
	public void readCard(String cardNumber) {
		Calendar calendar = Calendar.getInstance();
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		boolean isCardFound = false;

		for(int i = 0; i < cards.length; i++) {
			if(cardNumber.equals(cards[i].getCardNumber())) {
				System.out.println("\n========== USER FOUND ==========");
				System.out.println("Username: " + cards[i].getAccount());
				System.out.println("Card Number: " + cards[i].getCardNumber());
				System.out.println("Expiration Month: " + cards[i].getMonthExpiration());
				System.out.println("Expiration Year: " + cards[i].getYearExpiration());
				validateExpiration(cards[i].getYearExpiration() >= year && cards[i].getMonthExpiration() > month);
				isCardFound = true;
				break;
			}
			if(!isCardFound && i == cards.length - 1) {
				System.out.println("::: ERROR :::\nNON-EXISTING CARD NUMBER");
			}
		}
	}

	/**
	 * Validates if a bank card is expired or not
	 * @param validation
	 */
	public void validateExpiration(boolean validation) {
		if(validation)
			System.out.println("\n::: VALID CARD :::");
		else
			System.out.println("\n::: EXPIRED CARD :::");
	}
}
