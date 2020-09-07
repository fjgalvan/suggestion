package model;


import java.io.FileReader; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;


public class ProductsBo {
	public static final String ROUTE_PRODUCTOS = "src/main/resources/Productos.properties";
	private List<Product> listaProducto= new ArrayList<Product>(); //se cargan todos los productos que hay
	//cuando tenga todas las promociones cargarlo junto con los properties de los productos que yo manejo
	public ProductsBo(){
		
	}
	
	@SuppressWarnings("rawtypes")
	public List<Product> getListaDeProductos(){//Producto(Integer codigo,String nombre, String descripcion)
		
		Properties p1 = new Properties();
		try { p1.load(new FileReader(ROUTE_PRODUCTOS));
		} catch (IOException e) { e.printStackTrace();}
		
		int i=0;
		for (Enumeration e = p1.keys(); e.hasMoreElements() ; ) {
		    // Obtenemos el objeto
		    Object obj = e.nextElement();
		    //System.out.println(obj + ": " + p1.getProperty(obj.toString()));
		    
		    String[] parts = p1.getProperty(obj.toString()).split("-");
			Product prod= new Product(i, parts[0], parts[1]);
			listaProducto.add(prod);
			i++;
		}
		
		return listaProducto;
	}

	public void mostrarListaDeProductos() {
		for (Product prod: listaProducto) {
		    System.out.println(prod.getCodigo());
		    System.out.println(prod.getNombre());
		    System.out.println(prod.getDescripcion()+"\n");
		}
		
	}
	
}
