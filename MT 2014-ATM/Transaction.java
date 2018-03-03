package atm;

public class Transaction {
	private ATM atm;
	private Session s;
	private Card c;
	private double amount;

	public Transaction(ATM atm, Session s, Card c, double amount) {
		this.atm = atm;
		this.s = s;
		this.c = c;
		this.amount = amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public ATM getAtm() {
		return atm;
	}

	public double getAmount() {
		return amount;
	}

}