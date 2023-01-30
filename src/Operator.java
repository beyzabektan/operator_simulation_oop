
package question;

public class Operator {
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private int ID;
	private double talkingCharge;
	private double messageCost;
	private double networkCharge;
	private int discountRate;
	protected int talkingService;
	protected int messageService;
	protected double internetService;
	
	public Operator(int ID, double talkingCharge, double messageCost, double networkCharge, int discountRate) {
		this.ID = ID;
		this.talkingCharge = talkingCharge;
		this.messageCost = messageCost;
		this.networkCharge = networkCharge;
		this.discountRate = discountRate;
		
	}
	
	public double getTalkingCharge() {
		return talkingCharge;
	}

	public void setTalkingCharge(double talkingCharge) {
		this.talkingCharge = talkingCharge;
	}

	public double getMessageCost() {
		return messageCost;
	}

	public void setMessageCost(double messageCost) {
		this.messageCost = messageCost;
	}

	public double getNetworkCharge() {
		return networkCharge;
	}

	public void setNetworkCharge(double networkCharge) {
		this.networkCharge = networkCharge;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}


	public double calculateTalkingCost(int minute, Customer customer) {
		if ((customer.getAge() < 18) || (customer.getAge() > 65)) {
			return minute * (talkingCharge * (1-(discountRate/100.0)));
		}
		else {
			return minute * talkingCharge;
			
		}
	}
	
	public double calculateMessageCost(int quantity, Customer customer, Customer other) {
		if (other.getOperator().ID == customer.getOperator().ID) {
			return quantity * (messageCost * (1-discountRate/100.0));
		}
		else {
			return quantity * messageCost;
		}
	}
	
	public double calculateNetworkCost(double amount) {
		return amount * networkCharge;
	}


	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

