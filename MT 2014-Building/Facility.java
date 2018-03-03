
public abstract class Facility {
	private String name;
	
	public Facility(String name) throws IllegalArgumentException {
		if(name == null) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	//Auto eclipse code : Ctrl+3 > "generate hash" > Enter
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facility other = (Facility) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public abstract boolean canEnter(User u);
}
