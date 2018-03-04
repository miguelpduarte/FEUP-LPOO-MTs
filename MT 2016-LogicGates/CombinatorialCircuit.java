package circuits;

import java.util.HashSet;

public class CombinatorialCircuit {
	private HashSet<LogicVariable> lv_Set = new HashSet<>();
	
	public CombinatorialCircuit() {
		super();
	}

	public boolean addVariable(LogicVariable lv) {
		return lv_Set.add(lv);
	}

	public LogicVariable getVariableByName(String name) {
		if(name == null) {
			return null;
		}
		
		for(LogicVariable lv : lv_Set) {
			if(name.equals(lv.getName())) {
				return lv;
			}
		}
		
		return null;
	}
}
