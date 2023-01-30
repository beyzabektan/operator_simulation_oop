
package question;

public class Bill {

	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private double limitingAmount;
	private double currentDebt = 0;
	protected double moneySpent = 0;
	
	
	public Bill(double limitingAmount) {
		this.limitingAmount = limitingAmount;		
		
	}
	
	
	public boolean check(double amount) {
		if ((amount + currentDebt) <= limitingAmount) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void add(double amount) {
		this.currentDebt += amount;
	}
	
	public void pay(double amount) {
		if (amount <= currentDebt) {
			this.currentDebt -= amount;
			this.moneySpent += amount;
		}
		else {
			this.moneySpent += currentDebt;
			this.currentDebt = 0;
		}
	}
	
	public void changeTheLimit(double amount) {
		if (currentDebt <= amount) {
			this.limitingAmount = amount;
			
		}
		
	}
	

	public double getLimitingAmount() {
		return limitingAmount;
	}


	public double getCurrentDebt() {
		return currentDebt;
	}



	
	


	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

