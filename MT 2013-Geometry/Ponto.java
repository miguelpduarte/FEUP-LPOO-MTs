package geometria;

public class Ponto implements Comparable<Ponto> {
	private int X;
	private int Y;
	
	public Ponto(int x, int y) {
		X = x;
		Y = y;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	@Override
	public String toString() {
		return "(" + X + ", " + Y + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + X;
		result = prime * result + Y;
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
		if (!(obj instanceof Ponto)) {
			return false;
		}
		Ponto other = (Ponto) obj;
		if (X != other.X) {
			return false;
		}
		if (Y != other.Y) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Ponto p) {
		if(this.X == p.X) {
			return Integer.compare(this.Y, p.Y);
		}
		return Integer.compare(this.X, p.X);
	}
	
	
}
