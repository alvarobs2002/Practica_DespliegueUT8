package empresa;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
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
public class Main {
	static Empresa e=new Empresa();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Producto> lista=new ArrayList<>();
		cargarProductos(lista);
		menu(lista);
	}
	/**
	 * Metodo para introducir los productos y sus tipos
	 */
	public static void cargarProductos(ArrayList<Producto> lista) {
		lista.add(new Boligrafo("Boligrafo permanente", "99", 1,2, 10, "azul", "BIC", 5));
		lista.add(new Aspiradora("Aspiradora 3000", "98", 105.99,150, 5, "Automatica"));
		lista.add(new Telefono("HuaweiP20", "97", 299.99,399.99, 10, "Huawei", 2600, 6, 128));
	}
	/**
	 * Metodo para visualizar los productos
	 */
	public static void visualizarProductos(ArrayList<Producto> lista) {
		for (Producto producto : lista) {
			System.out.println(producto);
		}
	}
	/**
	 * Metodo para crear un menu
	 */
	public static void menu(ArrayList<Producto> lista) {
		// Crearemos un menu para llamar a los metodos
		Scanner sc=new Scanner(System.in);
		int op;
		do {
			System.out.println("Capital de la empresa: "+e.getCapital());
		System.out.println("MENU");
		System.out.println("1.Mostrar productos");
		System.out.println("2.Vender productos");
		System.out.println("3.Comprar productos");
		System.out.println("4.Añadir productos al mercado");
		System.out.println("5.Grabar productos");
		System.out.println("6.Salir");
		System.out.println("Introduce una opcion");
		op=sc.nextInt();
		while (op<1 || op>6) {
			System.out.println("Opcion incorrecta, vuelva a introducirla");
			op=sc.nextInt();
		}
		// Llamada a los metodos
		switch (op) {
		case 1:
			visualizarProductos(lista);
			break;
		case 2:
			venderProductos(lista);
			break;
		case 3:
			comprarProductos(lista);
			break;
		case 4:
			añadirProducto(lista);
			break;
		case 5:
			grabarProductos(lista);
		}
		}while(op!=6);
	}
	/**
	 * Metodo para comprar productos
	 * /**
	 * @return booleano para comprobar el codigo
	 */
	public static void comprarProductos(ArrayList<Producto> lista) {
		Scanner sc=new Scanner(System.in);
		double capital=e.getCapital();
		String codigo;
		boolean a=false;
		boolean b=false;
		int cantidad;
		int stocksuma=0;
		System.out.println("COMPRAR PRODUCTOS");
		System.out.println("Seleccione el código del producto que quiera comprar");
		codigo=sc.next();
		a=comprobarCodigo(lista,codigo);
		while (a==false) {
			System.out.println("Este codigo no existe, introducelo de nuevo");
			codigo=sc.next();
			a=comprobarCodigo(lista,codigo);
		}
		for (Producto producto : lista) {
			if (codigo.equalsIgnoreCase(producto.getCodigo())) {
				if (producto instanceof Producto) {
					if (producto.getPrecioCompra()<e.getCapital()) {
						b=true;
					}
					else {
						System.out.println("No tienes suficiente capital para comprar el producto");
					}
				}
			}
		}
		if (b==true) {
		for (Producto producto : lista) {
			if (codigo.equalsIgnoreCase(producto.getCodigo())) {
				if (producto instanceof Producto) {
					System.out.println("Introduce la cantidad que quieres comprar");
					cantidad=sc.nextInt();
					while (cantidad<0) {
						System.out.println("No puedes seleccionar una cantidad negativa");
						cantidad=sc.nextInt();
					}
					while ((producto.getPrecioCompra()*cantidad)>e.getCapital()) {
						System.out.println("No tienes suficiente capital para comprar tantas unidades, introduce otra cantidad");
						cantidad=sc.nextInt();
					}
					stocksuma=producto.getStock()+cantidad;
					producto.setStock(stocksuma);
					capital=e.getCapital()-(producto.getPrecioCompra()*cantidad);
					e.setCapital(capital);
					System.out.println("Capital actual: "+capital);
					
					
				}
			}
		}
	}
	}
	/**
	 * Metodo para vender productos
	 */
	public static void venderProductos(ArrayList<Producto> lista) {
		Scanner sc=new Scanner(System.in);
		double capital=e.getCapital();
		String codigo;
		int cantidad;
		int stockresta;
		boolean a=false;
		System.out.println("VENDER PRODUCTOS");
		System.out.println("Seleccione el código del producto que quiera vender");
		codigo=sc.next();
		a=comprobarCodigo(lista,codigo);
		while (a==false) {
			System.out.println("Este codigo no existe, introducelo de nuevo");
			codigo=sc.next();
			a=comprobarCodigo(lista,codigo);
		}
		for (Producto producto : lista) {
			if (codigo.equalsIgnoreCase(producto.getCodigo())) {
				if (producto instanceof Producto) {
					System.out.println("Introduce la cantidad que quieres comprar");
					cantidad=sc.nextInt();
					while (cantidad<0) {
						System.out.println("No puedes vender una cantidad negativa, introduce otra cantidad");
						cantidad=sc.nextInt();
					}
					while (cantidad>producto.getStock()) {
						System.out.println("No tienes suficiente stock para vender, seleccione otro");
						cantidad=sc.nextInt();
					}
					stockresta=producto.getStock()-cantidad;
					producto.setStock(stockresta);
					capital=e.getCapital()+(producto.getPrecioCompra()*cantidad);
					e.setCapital(capital);
					System.out.println("Capital actual: "+capital);
				}
			}
		}
	}
	/**
	 * Metodo para añadir productos
	 */
	public static void añadirProducto(ArrayList<Producto> lista) {
		Scanner sc=new Scanner(System.in);
		String [] telefonos={"iPhone","Nokia","Huawei","Samsung"};
		boolean a=true;
		String marcatel;
		double pulgadas;
		double bateria;
		double precioCompra;
		int memoria;
		String codigo;
		String tipo;
		System.out.println("AÑADIR PRODUCTOS AL MERCADO");
		System.out.println("Introduce el tipo de producto que quiere añadir al mercado(Aspiradora,Boligrafo,Telefono)");
		tipo=sc.next();
		while (!tipo.equalsIgnoreCase("Aspiradora")&&!tipo.equalsIgnoreCase("Boligrafo")&&!tipo.equalsIgnoreCase("Telefono")) {
			System.out.println("El tipo de producto que ha tecleado no existe, introducelo de nuevo");
			tipo=sc.next();
		}
		System.out.println("Introduce el nombre del producto");
		String nombre=sc.next();
		System.out.println("Introduce el codigo del producto");
		codigo=sc.next();
		a=comprobarCodigo(lista,codigo);
		while (a==true) {
			System.out.println("Este codigo existe, introducelo de nuevo");
			codigo=sc.next();
			a=comprobarCodigo(lista,codigo);
		}
		System.out.println("Introduce su precio de venta");
		double precioVenta=sc.nextDouble();
		while (precioVenta<0) {
			System.out.println("No puede introducir un precio negativo, introducelo de nuevo");
			precioVenta=sc.nextDouble();
		}
		if (tipo.equalsIgnoreCase("Telefono")) {
			System.out.println("Introduce la marca del telefono(iPhone, Nokia, Huawei, Samsung)");
			marcatel=sc.next();
			while (!marcatel.equalsIgnoreCase("iPhone")&&!marcatel.equalsIgnoreCase("Nokia")&&!marcatel.equalsIgnoreCase("Huawei")&&!marcatel.equalsIgnoreCase("Samsung")) {
				System.out.println("La marca del telefono introducida no es correcta, introducela de nuevo");
				marcatel=sc.next();
			}
			System.out.println("Introduce la bateria del telefono");
			bateria=sc.nextDouble();
			System.out.println("Introduce las pulgadas del telefono(4-10)");
			pulgadas=sc.nextDouble();
			while (pulgadas<4 || pulgadas>10) {
				System.out.println("Las pulgadas introducidas son incorrectas, intentalo de nuevo");
				pulgadas=sc.nextDouble();
			}
			System.out.println("Introduce la memoria del telefono(64/128/512)");
			memoria=sc.nextInt();
			while (memoria!=512 && memoria!=128 && memoria!=64) {
				System.out.println("La memoria introducida es incorrecta, vuelve a introducirla");
				memoria=sc.nextInt();
			}
			precioCompra=calcularPrecioTelefono(telefonos,marcatel,memoria);
			lista.add(new Telefono(nombre, codigo, precioCompra, precioVenta, 0, marcatel, bateria, pulgadas, memoria));
			
		}
		if (tipo.equalsIgnoreCase("Boligrafo")) {
			precioCompra=(double) (Math.random()*(11-1)+1);
			System.out.println("Introduce el color del boligrafo");
			String color=sc.next();
			System.out.println("Introduce la marca del boligrafo");
			String marca=sc.next();
			System.out.println("Introduce la longitud del boligrafo");
			double longitud=sc.nextDouble();
			while (longitud<0) {
				System.out.println("No puedes introducir una longitud negativa, intentalo de nuevo");
				longitud=sc.nextDouble();
			}
			lista.add(new Boligrafo(nombre, codigo, precioCompra, precioVenta, 0, color, marca, longitud));
		}
		if (tipo.equalsIgnoreCase("Aspiradora")) {
			precioCompra=(double) (Math.random()*(100-50)+50);
			System.out.println("Introduce el tipo de aspiradora(Manual/Automatica)");
			String tipoasp=sc.next();
			while(!tipoasp.equalsIgnoreCase("Manual")&&!tipoasp.equalsIgnoreCase("Automatica")) {
				System.out.println("El tipo de aspiradora introducido no existe, introducelo de nuevo");
				tipoasp=sc.next();
			}
			lista.add(new Aspiradora(nombre, codigo, precioCompra, precioVenta, 0, tipoasp));
		}
		
		/**
		 * Metodo para calcular precio telefono
		 * /**
		 * @return booleano que muestra el precio
		 */
	}
	public static double calcularPrecioTelefono(String[] telefonos,String marcatel, int memoria) {
		double precio=0;
		for (int i = 0; i < telefonos.length; i++) {
			if (marcatel.equalsIgnoreCase(telefonos[i])) {
				if (marcatel.equalsIgnoreCase("iPhone")) {
					precio=(100*3)+memoria;
				}
				else if(marcatel.equalsIgnoreCase("Nokia")) {
					precio=(100*2)+memoria;
				}
				else if(marcatel.equalsIgnoreCase("Huawei")) {
					precio=(100*2.5)+memoria;
				}
				else if(marcatel.equalsIgnoreCase("Samsung")) {
					precio=(100*2.75)+memoria;
				}
			}
		}
		return precio;
	}
	/**
	 * Metodo para grabar productos en un fichero
	 */
	public static void grabarProductos(ArrayList<Producto> lista) {
		try {
			FileOutputStream fos = new FileOutputStream("productos.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			oos.writeObject(lista);
			System.out.println("Los productos se han grabado correctamente");
			oos.close();
		}
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Metodo para comprobar codigo de los productos
	* /**
	 * @return booleano que indica si el codigo existe o no
	 */
	public static boolean comprobarCodigo(ArrayList<Producto> lista, String codigo) {
		for (Producto producto : lista) {
			if (producto.getCodigo().equalsIgnoreCase(codigo)) {
				return true;
			}
		}
		return false;
	}

}
