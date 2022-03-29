package empresa;
/**
 * <h1>Ejercicio con JavaDoc
 * <h1/>
 * <h2>Desarrollar una aplicación de una empresa para comprar y vender productos.
 * <h2/>
 * @author Alvaro Bernardo
 * @since 29/3/22
 * @version 1.0
 *
 */
public class Empresa {
	/**
	 * Atributos de la clase Empresa
	 */
	private double capital=1000;

	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Metodo publico Empresa
	 * 
	 * @param capital
	 */
	public Empresa(double capital) {
		super();
		this.capital = capital;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}
}