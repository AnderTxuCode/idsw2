package isii.ataques;

public class ArmaHeroina extends AtaqueVampiresa{
	
	protected int durabilidad;
	
	public ArmaHeroina(int da�o, int exito) {
		super(da�o, exito);
		durabilidad = 100;
	}
}
