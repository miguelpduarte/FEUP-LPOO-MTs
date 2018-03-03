package atm;

public class ATM {
	private int ID;
	private String location;
	private String agency;
	
	
	public ATM(int iD, String location, String agency) {
		ID = iD;
		this.location = location;
		this.agency = agency;
	}


	public int getID() {
		return ID;
	}


	@Override
	public String toString() {
		return "ATM " + ID + " (" + location + ", "	+ agency + ")";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((agency == null) ? 0 : agency.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
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
		if (!(obj instanceof ATM)) {
			return false;
		}
		ATM other = (ATM) obj;
		if (ID != other.ID) {
			return false;
		}
		if (agency == null) {
			if (other.agency != null) {
				return false;
			}
		} else if (!agency.equals(other.agency)) {
			return false;
		}
		if (location == null) {
			if (other.location != null) {
				return false;
			}
		} else if (!location.equals(other.location)) {
			return false;
		}
		return true;
	}
	
}
