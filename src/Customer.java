
package question;

public class Customer {
	
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private int ID;
	public String name;
	private int age;
	private Operator operator;
	private Bill bill;
	private double limitingAmount;
	protected int talkingMinute;
	protected int messageSent;
	protected double internetUsed;
	
	public Customer(int ID, String name, int age, Operator operator, double limitingAmount) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.operator = operator;
		this.limitingAmount = limitingAmount ;
		this.bill = new Bill(limitingAmount);
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
		
	

	public void talk(int minute, Customer other) {
		if (this != other) {
			if (this.bill.check(operator.calculateTalkingCost(minute, this))) {
				this.bill.add(operator.calculateTalkingCost(minute, this));
				this.talkingMinute += minute;
				other.talkingMinute += minute;
				this.operator.talkingService += minute;
				other.operator.talkingService += minute;
				
			}
		}
		
	}
	
	public void message(int quantity, Customer other) {
		if (this != other) {
			if (this.bill.check(operator.calculateMessageCost(quantity, this, other))) {
				this.bill.add(operator.calculateMessageCost(quantity, this, other));
				this.messageSent += quantity;
				operator.messageService += quantity;
			}
		}
		
	}
	
	public void connection(double amount) {
		if (this.bill.check(operator.calculateNetworkCost(amount))) {
			this.bill.add(operator.calculateNetworkCost(amount));
			this.internetUsed += amount;
			operator.internetService += amount;
		}
		
	}
	
	
	

	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

