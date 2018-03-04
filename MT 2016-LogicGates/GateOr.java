package circuits;

public class GateOr extends LogicGate {
	private LogicVariable output;
	private LogicVariable input1;
	private LogicVariable input2;
	
	public GateOr(LogicVariable output, LogicVariable input1, LogicVariable input2) throws ColisionException, CycleException {
		
		//If the calculator of my input has my output as an input
		//(Confusing, I know, but that's what it is)
		if((input1.getCalculatedBy() != null && input1.getCalculatedBy().isInput(output)) || 
				(input2.getCalculatedBy() != null && input2.getCalculatedBy().isInput(output))) {
			throw new CycleException();
		}
		
		this.output = output;
		this.input1 = input1;
		this.input2 = input2;
		calcOutput();
		this.output.setCalculatedBy(this);
	}

	@Override
	public LogicVariable getOutput() {
		return output;
	}

	@Override
	public LogicVariable[] getInputs() {
		return (new LogicVariable[] {input1, input2});
	}

	@Override
	public String getSymbol() {
		return "OR";
	}
	
	@Override
	public void calcOutput() {
		this.output.setValue(this.input1.getValue() || this.input2.getValue());
	}
}
