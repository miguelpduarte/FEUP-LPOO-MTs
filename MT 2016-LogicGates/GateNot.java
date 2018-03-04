package circuits;

public class GateNot extends LogicGate {
	private LogicVariable output;
	private LogicVariable input;
	
	public GateNot(LogicVariable output, LogicVariable input) throws ColisionException, CycleException {
		
		//If the calculator of my input has my output as an input
		//(Confusing, I know, but that's what it is)
		if(input.getCalculatedBy() != null && input.getCalculatedBy().isInput(output)) {
			throw new CycleException();
		}
		
		this.output = output;
		this.input = input;
		calcOutput();
		this.output.setCalculatedBy(this);
	}

	@Override
	public LogicVariable getOutput() {
		return output;
	}

	@Override
	public LogicVariable[] getInputs() {
		return (new LogicVariable[] {input});
	}

	@Override
	public String getSymbol() {
		return "NOT";
	}

	@Override
	public void calcOutput() {
		output.setValue(!this.input.getValue());
	}
}
