import java.util.Scanner;

class Atm {
	private Bank bank = new Bank();
	private Money[] money = new Money[10];
	private int maxBills, maxCoins;
	
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Empty Constructor
	 */
	Atm() {
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
	Atm(int maxBills, int maxCoins) {
		this.maxBills = maxBills;
		this.maxCoins = maxCoins;
		initializeMoney();
		bank.initializeBank();
	}

	/**
	 * Ten instances (creations) of objects of the type Money 
	 */
	private void initializeMoney() {
		money[0] = new Money(1000, "ONE THOUSAND PESOS ", true, 50, 50); //Instance of an object from the class Money
		money[1] = new Money(500,  "FIVE HUNDRED PESOS ", true, 80, 80);
		money[2] = new Money(200,	 "TWO HUNDRED PESOS  ", true, 150, 150);
		money[3] = new Money(100,	 "ONE HUNDRED PESOS  ", true, 300, 300);
		money[4] = new Money(50,	 "FIFTY PESOS        ", true, 300, 300);
		money[5] = new Money(20,	 "TWENTY PESOS       ", true, 500, 500);
		money[6] = new Money(10,	 "TEN PESOS          ", false ,80, 80);
		money[7] = new Money(5,	   "FIVE PESOS         ", false ,80, 80);
		money[8] = new Money(2,	   "TWO PESOS          ", false ,100, 100);
		money[9] = new Money(1,	   "ONE PESO           ", false ,120, 120);
	}

	/**
	 * Shows the ATM menu as long as the user does not decide to exit with the option 0.
	 */
	void menu() {
		int option;

		do {
			System.out.println("\n==============================================================");
			System.out.println("=    0. EXIT || 1. CUT || 2. SUPPLY MONEY || 3. READ CARD    =");
			System.out.println("==============================================================");
			System.out.print("CHOOSE AN OPTION: ");
			option = sc.nextInt();

			switch(option) {
				case 1:
					System.out.println("\n===========================================");
					System.out.println("|| 1. BILLS || 2. COINS || 3. EVERYTHING ||");
					System.out.println("===========================================");
					System.out.print("CHOOSE THE TYPE OF CUT: ");
					int cutOption = sc.nextInt();

					if (cutOption == 1)
						moneyCut('B');
					else if (cutOption == 2)
						moneyCut('C');
					else if (cutOption == 3)
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
	void moneyCut() {
		String moneyType;
		int accumulator = 0;

		System.out.println("\n=============================== MONEY CUT ================================");
		System.out.println("||   QUANTITY   ||  DESIRED QTY  ||         DENOMINATION         ||   $   ");
		System.out.println("==========================================================================");
		
		for (int i = 0; i < money.length; i++) {
			moneyType = (money[i].isBill()) ? "BILLS" : "COINS";
			System.out.printf("|| %-13s|| %-14s|| %-29s|| %-6s\n", money[i].getQuantity(), money[i].getDesiredQuantity(), moneyType + " OF " + money[i].getName(), money[i].getQuantity() * money[i].getValue());
			accumulator += money[i].getQuantity() * money[i].getValue();
		}
		System.out.println("==========================================================================");
		System.out.println("TOTAL AMOUNT: $" + accumulator);
	}

 /**
	* Shows the current amount of money, the desired amount or maximum amount in the ATM and the denomination only of the type of money that the user enters, wheter it is B for Bills of C for Coins.
	* @param type
  */
	void moneyCut(Character type){
		String moneyType;
		int accumulator = 0;

		System.out.println("\n=============================== MONEY CUT ================================");
		System.out.println("||   QUANTITY   ||  DESIRED QTY  ||         DENOMINATION         ||   $   ");
		System.out.println("==========================================================================");
		
		for (int i = 0; i < money.length; i++) {
			if (money[i].isBill() == true) {
				if (type != 'B')
					continue;
				moneyType = "BILLS";
			}
			else {
				if (type != 'C')
					continue;
				moneyType = "COINS";
			}
			System.out.printf("|| %-13s|| %-14s|| %-29s|| %-6s\n", money[i].getQuantity(), money[i].getDesiredQuantity(), moneyType + " OF " + money[i].getName(), money[i].getQuantity() * money[i].getValue());
			accumulator += money[i].getQuantity() * money[i].getValue();
		}
		System.out.println("==========================================================================");
		System.out.println("TOTAL AMOUNT: $" + accumulator);
	}
	/**
	 * Shows a menu of the type of money that the user wants to supply as well as 3 additional options.
	 */
	void supplyMoney() {
		String moneyType;
		int option, index, quantity, maximum, denomination;

		do {
			System.out.println("\n========== SUPPLY ==========");
			
			for (int i = 0; i < money.length; i++) {
				moneyType = (money[i].isBill()) ? "BILLS OF " : "COINS OF ";
				System.out.println("||      " + moneyType + money[i].getValue() + "\t  ||");
			}

			System.out.println("============================");
			System.out.println("100 - ADJUST CURRENT AMOUNT TO DESIRED AMOUNT");
			System.out.println("101 - MODIFY THE CURRENT AMOUNT");
			System.out.println("102 - MODIFY THE CURRENT AMOUNT OF THE DENOMINATION OF YOUR CHOICE");
			System.out.println("0 - EXIT");
			System.out.print("\nCHOOSE AN OPTION: ");
			option = sc.nextInt();

			if (option == 0)
				return;
			if (option == 100)
				adjustDesiredQuantity();
			if (option == 101) {
				System.out.print("ENTER QUANTITY: ");
				quantity = sc.nextInt();
				adjustDesiredQuantity(quantity);
			}
			if (option == 102) {
				System.out.print("ENTER THE DENOMINATION BY WRITING ITS VALUE (e.g.: BILLS OF ONE THOUSAND PESOS = 1000): ");
				denomination = sc.nextInt();
				System.out.print("ENTER QUANTITY: ");
				quantity = sc.nextInt();
				adjustDesiredQuantity(denomination, quantity);
			}
			if (option >= 100) 
				return;

			index = option - 1;
			System.out.print("ENTER QUANTITY: ");
			quantity = sc.nextInt();

			maximum = (money[index].isBill()) ? maxBills : maxCoins;

			if (money[index].getQuantity() + quantity > maximum)
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
		for (int i = 0; i < money.length; i++)	
			money[i].setQuantity(money[i].getDesiredQuantity());
	}

	/**
	 * Adjust all current amounts of money to the amount that the user enters
	 * @param desiredAmount
	 */
	private void adjustDesiredQuantity(Integer desiredAmount) {
		for (int i = 0; i < money.length; i++)
			money[i].setQuantity(desiredAmount);
	}

	/**
	 * Adjusts the current amount of money of the denomination that the user enters
	 * @param value
	 * @param desiredAmount
	 */
	private void adjustDesiredQuantity(Integer value, Integer desiredAmount) {
		for (int i = 0; i < money.length; i++) {
			if (money[i].getValue() == value)
				money[i].setQuantity(desiredAmount);
		}
	}

	/**
	 * Read the card from one of the registered cards in the constructor method in the class Bank
	 */
	void readCard() {
		String cardNumber;
		
		System.out.print("\nTYPE IN YOUR CARD NUMBER: ");
		cardNumber = sc.next();

		bank.readCard(cardNumber);
	}
}