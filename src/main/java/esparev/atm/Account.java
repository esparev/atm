package esparev.atm;

public class Account {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private int averageSalary;
    private int maxCredit;

    public Account(String firstName, String lastName, String phoneNumber, String address, int averageSalary, int maxCredit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.averageSalary = averageSalary;
        this.maxCredit = maxCredit;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(int averageSalary) {
        this.averageSalary = averageSalary;
    }

    public int getMaxCredit() {
        return maxCredit;
    }

    public void setMaxCredit(int maxCredit) {
        this.maxCredit = maxCredit;
    }
}
