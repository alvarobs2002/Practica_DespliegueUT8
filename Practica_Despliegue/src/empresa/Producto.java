package empresa;
import java.io.Serializable;
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
public class Producto implements Serializable{
	/**
	 * Atributos de la clase Producto
	 */
	private String nombre;
	private String codigo;
	private double precioCompra;
	private double precioVenta;
	private int stock;
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Metodo publico Avion
	 * 
	 * @param nombre
	 * @param codgio
	 * @param precioCompra
	 * @param precioVenta
	 * @param stock
	 */
	public Producto(String nombre, String codigo, double precioCompra, double precioVenta, int stock) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.precioCompra = precioCompra;
		this.precioVenta=precioVenta;
		this.stock = stock;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta=precioVenta;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", precio de Compra= " + precioCompra + " Precio de venta "+precioVenta+", stock=" + stock + " ";
	}
}
