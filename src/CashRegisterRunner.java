import java.util.Scanner;

/**
 * The runner class that contains the main method for the Cash Register Class
 * @author David Harmeyer
 *
 */
public class CashRegisterRunner {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		CashRegister register=new CashRegister();
		
		outer: while (true) {
			String nextLine=scanner.nextLine();
			if (nextLine.isEmpty()) {
				System.out.println("Failure: Invalid Command");
				break outer;
			}
			
			switch(nextLine.charAt(0)) {
			case 'R':
				register.restock();
				System.out.println(register);
				break;
			case 'W':
				withdraw(nextLine, register);
				System.out.println(register);
				break;
			case 'I':
				viewQuantityLeft(nextLine, register);
				break;
			case 'Q':
				break outer;
			default:
				System.out.println("Failure: Invalid Command");
				break outer;	
			}
		}
		scanner.close();
	}
	
	/**
	 * Withdraws an amount which is specified by the user on the line from the register
	 * @param line
	 * The command line inputed to the console or command prompt
	 * @param register
	 * The register from which the money should be removed
	 */
	private static void withdraw(String line, CashRegister register) {
		int valueToWithdraw=Integer.parseInt(line.substring(line.indexOf('$')+1).trim());
		try {
			register.withdrawAmount(valueToWithdraw);
			System.out.println("Sucess: Dispensed $"+valueToWithdraw);
		}
		catch(InsufficientCashException ICE/* ICE BABY*/) {
			System.out.println("Failure: Insufficient funds");
		}
	}
	
	/**
	 * Prints the state of the cash register for all denominations of bills in the line, in the order they appear
	 * @param line
	 * The command line inputed to the console or command prompt
	 * @param register
	 * The register of which the data should be printed
	 */
	private static void viewQuantityLeft(String line, CashRegister register) {
		String[] parts=line.split("\\$");
		for (int i=1; i<parts.length; i++) {
			int value=Integer.parseInt(parts[i].trim());
			System.out.println(register.getPrintoutOfBill(value));
		}
	}
}
