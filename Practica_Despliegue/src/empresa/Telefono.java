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
public class Telefono extends Producto {
	/**
	 * Atributos de la clase Telefono que que hereda algunos de la clase Producto
	 */
	private String marca;
	private double bateria;
	private double pulgadas;
	private int memoria;
	/**
	 * Metodo publico Avion
	 * 
	 * @param nombre
	 * @param codgio
	 * @param precioCompra
	 * @param precioVenta
	 * @param stock
	 * @param marca
	 * @param bateria
	 * @param pulgada
	 * @param memoria
	 */
	public Telefono() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Telefono(String nombre, String codigo, double precioCompra, double precioVenta, int stock, String marca, double bateria, double pulgadas, int memoria) {
		super(nombre, codigo, precioCompra, precioVenta, stock);
		this.marca=marca;
		this.bateria=bateria;
		this.pulgadas=pulgadas;
		this.memoria=memoria;
		// TODO Auto-generated constructor stub
	}
	public Telefono(String marca, double bateria, double pulgadas, int memoria) {
		super();
		this.marca = marca;
		this.bateria = bateria;
		this.pulgadas = pulgadas;
		this.memoria = memoria;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getBateria() {
		return bateria;
	}
	public void setBateria(double bateria) {
		this.bateria = bateria;
	}
	public double getPulgadas() {
		return pulgadas;
	}
	public void setPulgadas(double pulgadas) {
		this.pulgadas = pulgadas;
	}
	public int getMemoria() {
		return memoria;
	}
	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}
	@Override
	public String toString() {
		return super.toString() +"marca=" + marca + ", bateria=" + bateria + ", pulgadas=" + pulgadas + ", memoria=" + memoria
				+ "]";
	}
}
