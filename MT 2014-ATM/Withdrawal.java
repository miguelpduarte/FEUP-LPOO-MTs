package atm;

public class Withdrawal extends Transaction {
	public Withdrawal(ATM atm, Session s, Card c, double amount) {
		super(atm, s, c, amount);
	}

	@Override
	public String toString() {
		
		return "Withdrawal at " + super.getAtm() +
				" of " + String.format("%.2f", super.getAmount());
				//Using String.format to get desired format of 2 decimal places
	}
}
