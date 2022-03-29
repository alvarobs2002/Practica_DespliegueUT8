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

public class Boligrafo extends Producto{
	/**
	 * Atributos de la clase Boligrafo que que hereda algunos de la clase Producto
	 */
	private String color;
	private String marca;
	private double longitud;
	/**
	 * Metodo publico Aspiradora
	 * 
	 * @param nombre
	 * @param codgio
	 * @param precioCompra
	 * @param precioVenta
	 * @param stock
	 * @param color
	 * @param marca
	 * @param longuitud
	 */
	public Boligrafo(String nombre, String codigo, double precioCompra, double precioVenta, int stock, String color, String marca, double longitud) {
		super(nombre, codigo, precioCompra, precioVenta, stock);
		this.color=color;
		this.marca=marca;
		this.longitud=longitud;
		// TODO Auto-generated constructor stub
	}
	public Boligrafo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Boligrafo(String color, String marca, double longitud) {
		super();
		this.color = color;
		this.marca = marca;
		this.longitud = longitud;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	@Override
	public String toString() {
		return super.toString() +"color=" + color + ", marca=" + marca + ", longitud=" + longitud + "]";
	}
	
}
