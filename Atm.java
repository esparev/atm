import java.util.Scanner;

public class Atm {
	private Bank bank = new Bank();
	private Money money[] = new  Money[10];
	private int maxBills, maxCoins;
	
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Empty Constructor
	 */
	public Atm() {
		maxCoins = 150;
		maxBills = 600;
		initializeMoney();
		bank.initializeBank();
	}
	/**
	 * Constructor with parameters
	 * @param maxBills
	 * @param maxCoins
	 */
	public Atm(int maxBills, int maxCoins) {
		this.maxBills = maxBills;
		this.maxCoins = maxCoins;
		initializeMoney();
		bank.initializeBank();
	}

	/**
	 * Ten instances (creations) of objects of the type Money 
	 */
	private void initializeMoney() {
		money[0] = new Money(1000,"One Thousand Pesos ",true,50,50); //Instance of an object from the class Money
		money[1] = new Money(500, "Five Hundred Pesos ",true,80,80);
		money[2] = new Money(200,	"Two Hundred Pesos  ",true,150,150);
		money[3] = new Money(100,	"One Hundred Pesos  ",true,300,300);
		money[4] = new Money(50,	"Fifty Pesos        ",true,300,300);
		money[5] = new Money(20,	"Twenty Pesos       ",true,500,500);
		money[6] = new Money(10,	"Ten Pesos          ",false,80,80);
		money[7] = new Money(5,	  "Five Pesos         ",false,80,80);
		money[8] = new Money(2,	  "Two Pesos          ",false,100,100);
		money[9] = new Money(1,	  "One Peso           ",false,120,120);
	}

	/**
	 * Shows the ATM menu as long as the user does not decide to exit with the option 0.
	 */
	public void menu() {
		int option;

		do {
			System.out.println("\n==============================================================");
			System.out.println("|| 0 - Exit || 1 - Cut || 2 - Supply Money || 3 - Read Card ||");
			System.out.println("==============================================================");
			System.out.print("Choose an Option: ");
			option = sc.nextInt();

			switch(option) {
				case 1:
					System.out.println("\n===========================================");
					System.out.println("|| 1. Bills || 2. Coins || 3. Everything ||");
					System.out.println("===========================================");
					System.out.print("Choose the Type of Cut: ");
					int cutOption = sc.nextInt();

					if(cutOption == 1)
						moneyCut('B');
					else if(cutOption == 2)
						moneyCut('C');
					else if(cutOption == 3)
						moneyCut();
					break;
				case 2:
					supplyMoney();
					break;
				case 3:
					readCard();
					break;
				case 0:
					System.out.println("\n=====================");
					System.out.println("THANK YOU! COME AGAIN");
					System.out.println("=====================");
					return;
			}
		} while(true);
	}

	/**
	 * Shows the current amount of money, the desired amount or maximum amount in the ATM and the denomination of the bills and coins.
	 */
	public void moneyCut() {
		String moneyType;
		int accumulator = 0;

		System.out.println("\n=============================== MONEY CUT ================================");
		System.out.println("||   Quantity   ||  Desired Qty  ||         Denomination         ||   $   ");
		System.out.println("==========================================================================");
		
		for(int i = 0; i < money.length; i++) {
			moneyType = (money[i].isBill()) ? "Bills" : "Coins";
			System.out.println("||" + money[i].getQuantity() + "\t\t||" + money[i].getDesiredQuantity() + "\t\t ||" + moneyType + " of " + money[i].getName() + "\t ||" + money[i].getQuantity() * money[i].getValue());
			accumulator += money[i].getQuantity() * money[i].getValue();
		}
		System.out.println("==========================================================================");
		System.out.println("Total Amount: $" + accumulator);
	}

 /**
	* Shows the current amount of money, the desired amount or maximum amount in the ATM and the denomination only of the type of money that the user enters, wheter it is B for Bills of C for Coins.
	* @param type
  */
	public void moneyCut(char type){
		String moneyType;
		int accumulator = 0;

		System.out.println("\n=============================== MONEY CUT ================================");
		System.out.println("||   Quantity   ||  Desired Qty  ||         Denomination         ||   $   ");
		System.out.println("==========================================================================");
		
		for(int i = 0; i < money.length; i++) {
			if(money[i].isBill() == true) {
				if(type != 'B')
				continue;
				moneyType = "Bills";
			}
			else {
				if(type != 'C')
				continue;
				moneyType = "Coins";
			}
			System.out.println("||" + money[i].getQuantity() + "\t\t||" + money[i].getDesiredQuantity() + "\t\t ||" + moneyType + " of " + money[i].getName() + "\t ||" + money[i].getQuantity() * money[i].getValue());
			accumulator += money[i].getQuantity() * money[i].getValue();
		}
		System.out.println("==========================================================================");
		System.out.println("Total Amount: $" + accumulator);
	}
	/**
	 * Shows a menu of the type of money that the user wants to supply as well as 3 additional options.
	 */
	public void supplyMoney() {
		String moneyType;
		int option, index, quantity, maximum, denomination;

		do {
			System.out.println("\n========== SUPPLY ==========");
			
			for(int i = 0; i < money.length; i++) {
				moneyType = (money[i].isBill()) ? "Bills of " : "Coins of ";
				System.out.println("||      " + moneyType + money[i].getValue() + "\t  ||");
			}

			System.out.println("============================");
			System.out.println("100 - Adjust Current Amount to Desired Amount");
			System.out.println("101 - Modify the Current Amount");
			System.out.println("102 - Modify the Current Amount of the Denomination of your Choice");
			System.out.println("0 - Exit");
			System.out.print("\nChoose an Option: ");
			option = sc.nextInt();

			if(option == 0)
				return;
			if(option == 100)
				adjustDesiredQuantity();
			if(option == 101) {
				System.out.print("Enter Quantity: ");
				quantity = sc.nextInt();
				adjustDesiredQuantity(quantity);
			}
			if(option == 102) {
				System.out.print("Enter the Denomination by Writing its Value (e.g.: Bills of One Thousand Pesos = 1000): ");
				denomination = sc.nextInt();
				System.out.print("Enter Quantity: ");
				quantity = sc.nextInt();
				adjustDesiredQuantity(denomination, quantity);
			}
			if(option >= 100) return;

			index = option - 1;
			System.out.print("Enter Quantity: ");
			quantity = sc.nextInt();

			maximum = (money[index].isBill()) ? maxBills : maxCoins;

			if(money[index].getQuantity() + quantity > maximum)
				System.out.println("::: ERROR, TOO MUCH MONEY :::\n");
			else
				money[index].setQuantity(money[index].getQuantity() + quantity);
		} while(true);
	}

	/**
	 * Adjusts all current amounts of money to the desired amount
	 */
	private void adjustDesiredQuantity() {
		System.out.println("::: DESIRED AMOUNT ADJUSTED :::");
		for(int i = 0; i < money.length; i++)	
			money[i].setQuantity(money[i].getDesiredQuantity());
	}

	/**
	 * Adjust all current amounts of money to the amount that the user enters
	 * @param desiredAmount
	 */
	private void adjustDesiredQuantity(int desiredAmount) {
		for(int i = 0; i < money.length; i++)
			money[i].setQuantity(desiredAmount);
	}

	/**
	 * Adjusts the current amount of money of the denomination that the user enters
	 * @param value
	 * @param desiredAmount
	 */
	private void adjustDesiredQuantity(int value,int desiredAmount) {
		for(int i = 0; i < money.length; i++) {
			if(money[i].getValue() == value)
				money[i].setQuantity(desiredAmount);
		}
	}

	/**
	 * Read the card from one of the registered cards in the constructor method in the class Bank
	 */
	public void readCard() {
		String cardNumber;
		
		System.out.print("\nType in Your Card Number: ");
		cardNumber = sc.next();

		bank.readCard(cardNumber);
	}
}
