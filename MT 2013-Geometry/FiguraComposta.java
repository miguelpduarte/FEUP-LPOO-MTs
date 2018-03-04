package geometria;

public class FiguraComposta extends Figura implements Countable {
	private Figura[] figuras;
	
	public FiguraComposta(Figura[] figuras) {
		this.figuras = figuras;
	}

	@Override
	public double getArea() {
		double result = 0;
		
		for(Figura f : figuras) {
			result += f.getArea();
		}
		
		return result;
	}

	@Override
	public double getPerimetro() {
		double result = 0;
		
		for(Figura f : figuras) {
			result += f.getPerimetro();
		}
		
		return result;
	}

	@Override
	public int count() {
		return figuras.length;
	}

}
