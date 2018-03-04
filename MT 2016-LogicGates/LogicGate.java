package circuits;

public abstract class LogicGate {
	
	public abstract LogicVariable getOutput();
	
	public abstract LogicVariable[] getInputs();
	
	public abstract String getSymbol();
	
	public String getFormula() {
		String formula = getSymbol() + "(";
		
		for(LogicVariable lv : getInputs()) {
			formula += lv.getFormula() + ",";
		}
		
		//Removing last ',' and adding final ')'
		formula = formula.substring(0, formula.lastIndexOf(","));
		formula += ")";
		
		return formula;
	}
	
	public abstract void calcOutput();
	
	public boolean isInput(LogicVariable lv) {
		for(LogicVariable input_lv : getInputs()) {
			if(input_lv.equals(lv)) {
				return true;
			}
		}
		
		return false;
	}
}
