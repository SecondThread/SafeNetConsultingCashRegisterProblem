
/**
 * A class to represent a cash register that holds BillTypes
 * @author David Harmeyer
 *
 */
public class CashRegister {
	/**
	 * An array of BillTypes that holds a billType for $100, $50, $20, $10, $5, and $1 in that order
	 */
	BillType[] billTypes={new BillType(100), new BillType(50), new BillType(20), new BillType(10), 
				new BillType(5), new BillType(1)};
	
	/**
	 * The default constructor for a CashRegister that starts with a fully stocked CashRegister
	 */
	public CashRegister() {
		restock();
	}
	
	/**
	 * Restocks all billTypes so that they each have 10 bills
	 */
	public void restock() {
		for (BillType b:billTypes) {
			b.setQuantity(10);
		}
	}
	
	/**
	 * Withdraws the specified amount from this CashRegister using the least bills possible. This is done
	 * using a greedy algorithm. Although this would not work for the general case (id est if bills of any)
	 * the U. S. change system has been proven to be canonical, and this system therefore works with these
	 * denominations of bills, and would  also work if two dollar bills were used.
	 * @param amount
	 * The amount to be withdrawn
	 * @throws InsufficientCashException
	 * An exception if there is not a sufficient amount of cash in the register to make the cash
	 */
	public void withdrawAmount(int amount) throws InsufficientCashException {
		BillType[] startState=new BillType[billTypes.length];
		for (int i=0; i<billTypes.length; i++) {
			startState[i]=billTypes[i].clone();
		}
		for (BillType b:billTypes) {
			while(b.getQuantity()>0&&amount>=b.getValue()) {
				amount-=b.getValue();
				b.decrementQuantity();
			}
		}
		if (amount>0) {
			billTypes=startState;//don't actually withdraw any bills
			throw new InsufficientCashException();
		}
	}
	
	/**
	 * A string the represents the full state of this CashRegister
	 */
	public String toString() {
		String toReturn="Machine Balance:";
		for (BillType b:billTypes) toReturn+="\n$"+b.getValue()+" - "+b.getQuantity();
		return toReturn;
	}

	/**
	 * Gets a string representing the value of a certain BillType, which is searched for by value.
	 * @param value
	 * The value of that BillType
	 * @return
	 * A string representing the value and quantity of the BillType with the sepcified value.
	 */
	public String getPrintoutOfBill(int value) {
		for (BillType b:billTypes) {
			if (b.getValue()==value) {
				return "$"+value+" - "+b.getQuantity();
			}
		}
		return null;
	}

}