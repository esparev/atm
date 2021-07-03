package esparev.atm;

import java.util.Scanner;

public class Atm {
    private final Bank bank = new Bank();
    private final Money[] money = new Money[10];
    private final int maxBills, maxCoins;

    private static final Scanner sc = new Scanner(System.in);

    /**
     * Empty Constructor that starts by default with 600 max amount of bills and 150 of coins
     * and it also initializes the money, the bank accounts and cards
     */
    public Atm() {
        maxBills = 600;
        maxCoins = 150;
        initializeMoney();
        bank.initializeBank();
    }

    /**
     * Constructor with parameters that starts by with the amount of bills and coins that are received by
     * the parameters, and it also initializes the money, the bank accounts and cards
     * @param maxBills maximum amount of bills int the ATM
     * @param maxCoins maximum amount of coins in the ATM
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
        money[0] = new Money(1000, "THOUSAND PESO", true, 50, 50); //Instance of an object from the class Money
        money[1] = new Money(500, "FIVE HUNDRED PESO", true, 80, 80);
        money[2] = new Money(200, "TWO HUNDRED PESO", true, 150, 150);
        money[3] = new Money(100, "ONE HUNDRED PESO", true, 300, 300);
        money[4] = new Money(50, "FIFTY PESO", true, 300, 300);
        money[5] = new Money(20, "TWENTY PESO", true, 500, 500);
        money[6] = new Money(10, "TEN PESO", false,80, 100);
        money[7] = new Money(5, "FIVE PESO", false,80, 100);
        money[8] = new Money(2, "TWO PESO", false,100, 100);
        money[9] = new Money(1, "ONE PESO", false,120, 100);
    }

    /**
     * Shows the menu for the administrator and the options he has
     */
    public void menu() {
        do {
            System.out.println("\n=========================================================");
            System.out.println("0. EXIT || 1. MONEY INQUIRY || 2. DEPOSIT || 3. READ CARD");
            System.out.println("=========================================================");
            System.out.print("CHOOSE AN OPTION: ");
            int option = sc.nextInt();

            int inquiryOption;
            switch (option) {
                case 1: // Money Inquiry Option
                    System.out.println("\n=====================================");
                    System.out.println("1. BILLS || 2. COINS || 3. EVERYTHING");
                    System.out.println("=====================================");
                    System.out.print("CHOOSE THE TYPE OF INQUIRY: ");
                    inquiryOption = sc.nextInt();

                    if (inquiryOption == 1) { // Inquiry for Bills
                        moneyInquiry('B');
                    } else if (inquiryOption == 2) { // Inquiry for Coins
                        moneyInquiry('C');
                    } else if (inquiryOption == 3) { // Inquiry for Bills and Coins
                        moneyInquiry();
                    } else { // Error message
                        System.out.println("::: ERROR :::");
                    }
                    break;
                case 2: // Deposit Option
                    deposit();
                    break;
                case 3: // Read Card Option
                    readCard();
                    break;
                case 0: // Exit Option
                    System.out.println("\n=====================");
                    System.out.println("THANK YOU! COME AGAIN");
                    System.out.println("=====================");
                    return;
                default: // Non-Existent Option
                    return;
            }
        } while (true);
    }

    /**
     * Shows the current amount of money, the desired amount or maximum amount in the ATM and the denomination of
     * bills and coins
     */
    public void moneyInquiry() {
        String moneyType;
        int accumulator = 0;

        System.out.println("\n============================= MONEY INQUIRY ==============================");
        System.out.println("|   QUANTITY   |   DESIRED QTY   |          DENOMINATION          |   $   ");
        System.out.println("---------------+-----------------+--------------------------------+-------");

        for (Money value : money) {
            moneyType = (value.isBill()) ? "BILL" : "COIN";
            System.out.printf("| %-13s| %-16s| %-31s| %-6s\n", value.getQuantity(), value.getDesiredQuantity(), value.getName() + " " + moneyType, value.getQuantity() * value.getValue());
            accumulator += value.getQuantity() * value.getValue();
        }
        System.out.println("---------------+-----------------+--------------------------------+-------");
        System.out.println("TOTAL AMOUNT: $" + accumulator);
    }

    /**
     * Shows the current amount of money, the desired amount or maximum amount in the ATM and the denomination of the
     * chosen denomination (only bills or coins)
     * @param denomination the designation of bills or coins
     */
    public void moneyInquiry(char denomination) {
        String moneyType;
        int accumulator = 0;

        System.out.println("\n============================= MONEY INQUIRY ==============================");
        System.out.println("|   QUANTITY   |   DESIRED QTY   |          DENOMINATION          |   $   ");
        System.out.println("---------------+-----------------+--------------------------------+-------");

        for (Money value : money) {
            moneyType = (value.isBill()) ? "BILL" : "COIN";
            if (value.isBill() && denomination == 'B') {
                System.out.printf("| %-13s| %-16s| %-31s| %-6s\n", value.getQuantity(), value.getDesiredQuantity(), value.getName() + " " + moneyType, value.getQuantity() * value.getValue());
                accumulator += value.getQuantity() * value.getValue();
            } else if (!value.isBill() && denomination == 'C') {
                System.out.printf("| %-13s| %-16s| %-31s| %-6s\n", value.getQuantity(), value.getDesiredQuantity(), value.getName() + " " + moneyType, value.getQuantity() * value.getValue());
                accumulator += value.getQuantity() * value.getValue();
            }
        }
        System.out.println("---------------+-----------------+--------------------------------+-------");
        System.out.println("TOTAL AMOUNT: $" + accumulator);
    }

    /**
     * Shows a menu of the type of money that the user wants to supply as well as three additional options
     */
    public void deposit() {
        String moneyType;
        int option, index, quantity, maximum, denominationValue;

        do {
            System.out.println("\n========== DEPOSIT ==========");

            for (Money value : money) {
                moneyType = (value.isBill()) ? "BILLS OF" : "COINS OF";
                System.out.printf("|| %-5s %-5s\n", moneyType, value.getValue());
            }
            System.out.println("============================");
            System.out.println("100 - ADJUST CURRENT AMOUNT TO DESIRED AMOUNT");
            System.out.println("101 - MODIFY THE CURRENT AMOUNT");
            System.out.println("102 - MODIFY THE CURRENT AMOUNT OF THE DENOMINATION OF YOUR CHOICE");
            System.out.println("0 - EXIT");
            System.out.print("\nCHOOSE AN OPTION: ");
            option = sc.nextInt();

            if (option == 100) {
                adjustDesiredQuantity();
            } else if (option == 101) {
                System.out.print("ENTER QUANTITY: ");
                quantity = sc.nextInt();
                adjustDesiredQuantity(quantity);
            } else if (option == 102) {
                System.out.print("ENTER THE DENOMINATION BY WRITING ITS NUMERIC VALUE (e.g.: 1000 = THOUSAND PESO BILL): ");
                denominationValue = sc.nextInt();

                System.out.print("ENTER QUANTITY: ");
                quantity = sc.nextInt();
                adjustDesiredQuantity(denominationValue, quantity);
            } else if (option == 0) {
                return;
            } else {
                return;
            }
            index = option - 1;

            System.out.print("ENTER QUANTITY: ");
            quantity = sc.nextInt();

            maximum = (money[index].isBill()) ? maxBills : maxCoins;

            if (money[index].getQuantity() + quantity > maximum) {
                System.out.println("::: ERROR, TOO MUCH MONEY :::\n");
            } else {
                money[index].setQuantity(money[index].getQuantity() + quantity);
            }
        } while (true);
    }

    /**
     * Adjusts all current amounts of money to the desired amount
     */
    public void adjustDesiredQuantity() {
        for (Money value : money) {
            value.setQuantity(value.getDesiredQuantity());
        }
        System.out.println("::: DESIRED AMOUNT ADJUSTED :::");
    }

    /**
     * Adjust all current amounts of money to the amount that the user enters
     * @param desiredAmount the desired amount of money in the ATM
     */
    public void adjustDesiredQuantity(int desiredAmount) {
        for (Money value : money) {
            value.setQuantity(desiredAmount);
        }
        System.out.println("::: DESIRED AMOUNT ADJUSTED :::");
    }

    /**
     * Adjusts the current amount of money of the denomination that the user enters
     * @param denominationValue the true value of the denomination of a bill or a coin
     * @param desiredAmount the desired amount of money in the ATM
     */
    public void adjustDesiredQuantity(int denominationValue, int desiredAmount) {
        for (Money item : money) {
            if (item.getValue() == denominationValue) {
                item.setQuantity(desiredAmount);
            }
        }
    }

    /**
     * Reads the card from one of the registered cards in the Constructor method in the Class Bank
     */
    public void readCard() {
        String cardNumber;

        System.out.print("\nTYPE IN YOUR CARD NUMBER: ");
        cardNumber = sc.next();

        bank.findCard(cardNumber);
    }
}
