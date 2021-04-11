import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[]args) {
		int option;

		Atm atms[] = new Atm[5];
		atms[0] = new Atm();
		atms[1] = new Atm(500,210);
		atms[2] = new Atm(300,210);
		atms[3] = new Atm();
		atms[4] = new Atm(400,350);

		System.out.println("============================");
		System.out.println("======= Esparev Bank =======");
		System.out.println("============================");
		System.out.print("\nCHOOSE AN ATM FROM | 1 - 5 |\n-> ");
		option = sc.nextInt();
		
		if(option >= 1 && option <= 5)
			atms[option - 1].menu();
	}
}