import java.util.Objects;


public class User {
	private String name;

	public User(String name) {
		//super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		/*
		//Minha versão de equals, null safe e tudo mas mais curta
		if (obj instanceof User) {
			return Objects.equals(((User) obj).name, this.name);
		} else {
			return false;
		}
		*/
		
		//Auto gen de eclipse, mas como pinta, fica esta
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
		
	}
}
