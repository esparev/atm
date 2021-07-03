package esparev.atm;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int atmOption;

        Atm[] atms = new Atm[5];
        atms[0] = new Atm();
        atms[1] = new Atm();
        atms[2] = new Atm(500, 210);
        atms[3] = new Atm(300, 210);
        atms[4] = new Atm(400, 350);

        System.out.println("======================");
        System.out.println("E S P A R E V  B A N K");
        System.out.println("======================");
        atmOption = random.nextInt(5); // Chooses a random number between 0 and 4

        atms[atmOption].menu();
    }
}
