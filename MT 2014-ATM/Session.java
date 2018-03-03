package atm;

import java.util.ArrayList;

public class Session implements Countable {
	private ATM atm;
	private ArrayList<Transaction> transactions = new ArrayList<>();

	public Session(ATM atm) {
		this.atm = atm;
	}

	public ATM getATM() {
		return atm;
	}

	public void addTransaction(Transaction t) {
		transactions.add(t);
	}

	@Override
	public int count() {
		return transactions.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atm == null) ? 0 : atm.hashCode());
		result = prime * result
				+ ((transactions == null) ? 0 : transactions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Session)) {
			return false;
		}
		Session other = (Session) obj;
		if (atm == null) {
			if (other.atm != null) {
				return false;
			}
		} else if (!atm.equals(other.atm)) {
			return false;
		}
		if (transactions == null) {
			if (other.transactions != null) {
				return false;
			}
		} else if (!transactions.equals(other.transactions)) {
			return false;
		}
		return true;
	}
	
	
}
