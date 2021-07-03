package esparev.atm;

public class Card {
    private enum CardNetwork {
        VISA, MASTERCARD, AMERICAN_EXPRESS, DISCOVER, N_A
    }
    private final String cardNumber;
    private final Account cardholderName;
    private final int expirationMonth;
    private final int expirationYear;
    private final String securityCode;
    private final CardNetwork cardNetworkName;
    private final boolean credit;

    public Card(String cardNumber, Account cardholderName, int expirationMonth, int expirationYear, String securityCode, boolean credit) {
        this.cardNumber = cardNumber;
        this.cardholderName = cardholderName;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.securityCode = securityCode;
        switch (cardNumber.charAt(0)) {
            case '3':
                cardNetworkName = CardNetwork.AMERICAN_EXPRESS;
                break;
            case '4':
                cardNetworkName = CardNetwork.VISA;
                break;
            case '5':
                cardNetworkName = CardNetwork.MASTERCARD;
                break;
            case '6':
                cardNetworkName = CardNetwork.DISCOVER;
                break;
            default:
                cardNetworkName = CardNetwork.N_A;
                break;
        }
        this.credit = credit;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardholderName() {
        return cardholderName.getFullName();
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public CardNetwork getCardNetworkName() {
        return cardNetworkName;
    }

    public boolean isCredit() {
        return credit;
    }

}
