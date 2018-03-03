package atm;

public class Deposit extends Transaction {

	public Deposit(ATM atm, Session s, Card c, double amount) {
		super(atm, s, c, amount);
	}

}
