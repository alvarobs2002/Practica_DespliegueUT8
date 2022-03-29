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
public class Aspiradora extends Producto {
	/**
	 * Atributos de la clase Aspiradora que que hereda algunos de la clase Producto
	 */
	private String tipo;

	public Aspiradora() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Metodo publico Aspiradora
	 * 
	 * @param nombre
	 * @param codgio
	 * @param precioCompra
	 * @param precioVenta
	 * @param stock
	 * @param tipo
	 */
	public Aspiradora(String nombre, String codigo, double precioCompra, double precioVenta, int stock, String tipo) {
		super(nombre, codigo, precioCompra, precioVenta, stock);
		this.tipo=tipo;
		// TODO Auto-generated constructor stub
	}

	public Aspiradora(String tipo) {
		super();
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return super.toString()+"tipo=" + tipo + "]";
	}
}
