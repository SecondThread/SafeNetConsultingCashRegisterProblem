
/**
 * A type of Bill, such as all the $10 bills in the register
 * @author David Harmeyer
 */
public class BillType {
	/**
	 * The value of this bill, such as $50
	 */
	private int value;
	
	/**
	 * The number of this type of bill in the register
	 */
	private int quantity;
	
	/**
	 * Constructs a BillType with the specified value
	 * @param value
	 * The value of this BillType
	 */
	public BillType(int value) {
		this.value=value;
	}
	
	/**
	 * Gets number of this type of bill in the register
	 * @return
	 * How many of these bills are in the register
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Gets the value of this type of bill
	 * @return
	 * The value of this type of bill, in dollars
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Sets the quantity of this bill
	 * @param quantity
	 * The new number of bills of this type in the register
	 */
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	
	/**
	 * Decreases the quantity of this type of bill by one
	 */
	public void decrementQuantity() {
		setQuantity(getQuantity()-1);
	}
	
	/**
	 * creates a new BillType object identical to this one
	 */
	public BillType clone() {
		BillType toReturn=new BillType(value);
		toReturn.setQuantity(quantity);
		return toReturn;
	}
}
