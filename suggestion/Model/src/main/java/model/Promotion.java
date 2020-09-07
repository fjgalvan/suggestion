package model;

public class Promotion {
	String nombreLocal;
	String ubicacion;
	DateS fechaVigencia;
	Product Producto;
	String productoNombre;
	Double precio;

	public Promotion(String nombreLocal, String ubicacion, Product producto,
			Double precio, DateS fechaVigencia) {
		super();
		this.nombreLocal = nombreLocal;
		this.ubicacion = ubicacion;
		this.Producto = producto;
		this.precio = precio;
		this.fechaVigencia = fechaVigencia;
	}
	
	public Promotion(String nombreLocal, String ubicacion, String producto,
			Double precio, DateS fechaVigencia) {
		super();
		this.nombreLocal = nombreLocal;
		this.ubicacion = ubicacion;
		this.productoNombre = producto;
		this.precio = precio;
		this.fechaVigencia = fechaVigencia;
	}
	
	public void mostrarPromo(){ System.out.println("nombreLocal:" +nombreLocal+"\nubicacion:"+ubicacion+"\nProducto:"+Producto.getNombre()+Producto.getDescripcion()+"\n"+Producto.getCodigo()+"\nprecio:"+precio+"fechaVigencia:"+fechaVigencia);}
	
	public String getNombreLocal() {
		return nombreLocal;
	}

	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}

	public DateS getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(DateS fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Product getProducto() {
		return Producto;
	}

	public void setProducto(Product producto) {
		Producto = producto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getProductoNombre() {
		return productoNombre;
	}

}
