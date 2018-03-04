package circuits;

public class LogicVariable {
	private String name;
	private boolean value;
	private LogicGate calculatedBy;

	public LogicVariable(String name, boolean value) {
		this.name = name;
		this.value = value;
		this.calculatedBy = null;
	}

	public LogicVariable(String name) {
		this(name, false);
	}

	public String getName() {
		return name;
	}

	public boolean getValue() {
		if(calculatedBy != null) {
			//Recalculating output to be safe even if input value changed
			//(can't be done in set since we can change inputs and the output wouldn't be affected since the inputs don't know what they're "connected" to)
			calculatedBy.calcOutput();
		}
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	public LogicGate getCalculatedBy() {
		return calculatedBy;
	}

	public void setCalculatedBy(LogicGate calculatedBy) throws ColisionException {
		if(this.calculatedBy != null) {
			throw new ColisionException();
		}
		this.calculatedBy = calculatedBy;
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LogicVariable)) {
			return false;
		}
		LogicVariable other = (LogicVariable) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	public String getFormula() {
		if (calculatedBy == null) {
			return name;
		} else {
			return calculatedBy.getFormula();
		}
	}
	
}
