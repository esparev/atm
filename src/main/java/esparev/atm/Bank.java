package esparev.atm;

import java.util.Calendar;

public class Bank {
    private final Card[] cards = new Card[5];
    private final Account[] accounts = new Account[5];

    public void initializeBank() {
        accounts[0] = new Account("FRANK", "SINATRA", "3334445556", "THE STREET 52", 3000, 30000);
        accounts[1] = new Account("EDWARD", "RICHTOFEN", "5566778899", "TRINITY AVE. 115", 2200, 35000);
        accounts[2] = new Account("JOSE", "ESPAREV", "0011223344", "A STREET WITH NAME BUT NO NUMBER", 1500, 20000);
        accounts[3] = new Account("MASON", "DE SANTA", "4433221100", "PYRRHIC VICTORY 11", 1850, 23000);
        accounts[4] = new Account("MICHAEL", "TOWNLEY", "A STREET WITH NO NAME 13", "9988776655", 8500, 50000);

        cards[0] = new Card("4444444444444444", accounts[0], 10, 2020, "333", true);
        cards[1] = new Card("3888888888888888", accounts[1], 3, 2021, "911", false);
        cards[2] = new Card("5222222222222222", accounts[2], 2, 2019, "666", true);
        cards[3] = new Card("4666666666666666", accounts[3], 8, 2022, "164", true);
        cards[4] = new Card("6333333333333333", accounts[4], 12, 2019, "566", false);
    }

    /**
     * Receives a card number and searches for that card number in the array of cards
     * @param cardNumber to search and get the data from that card number
     */
    public void findCard(String cardNumber) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        boolean cardFound = false;

        for (Card card : cards) {
            if (cardNumber.equals(card.getCardNumber())) {
                System.out.println("\n========== USER FOUND ==========");
                System.out.println("USERNAME: " + card.getCardholderName());
                System.out.println("CARD NUMBER: " + card.getCardNumber().replaceAll("\\w(?=\\w{4})", "*"));
                System.out.println("EXPIRATION MONTH: " + card.getExpirationMonth());
                System.out.println("EXPIRATION YEAR: " + card.getExpirationYear());
                System.out.println("CARD NETWORK: " + card.getCardNetworkName());
                cardFound = true;
                if (card.getExpirationYear() >= year) {
                    if (card.getExpirationMonth() > month) {
                        System.out.println("\n::: VALID CARD :::");
                        continue;
                    }
                    System.out.println("\n::: VALID CARD :::");
                } else {
                    System.out.println("\n::: EXPIRED CARD :::");
                }
                break;
            }
        }
        if (!cardFound) {
            System.out.println("::: ERROR :::\nNON-EXISTING CARD NUMBER");
        }
    }
}
