package isii.ataques;

public class Ataque {
	
	private int da�o;
	private int exito;
	
	public Ataque(int da�o, int exito) {
		this.da�o = da�o;
		this.exito = exito;
	}
	
	public int getDa�o() {
		return da�o;
	}
	
	public int getExito() {
		return exito;
	}
}
