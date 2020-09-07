package model;

public class Suggestions {
	private String local;
	private String ubicacion;
	private DateS fechaDeVigencia;
	private String producto;
	private Double precio;

	public Suggestions(String local, String ubicacion, String producto,
			Double precio, DateS fechaDeVigencia) {
		this.local = local;
		this.ubicacion = ubicacion;
		this.producto = producto;
		this.precio = precio;
		this.fechaDeVigencia = fechaDeVigencia;
	}

	public Suggestions(String local2, String ubicacion2, Object key,
			Object value, DateS fechaDeVigencia2) {
		// TODO Auto-generated constructor stub
	}

	// GETs
	public String getLocal() {
		return local;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public DateS getFechaDeVigencia() {
		return fechaDeVigencia;
	}
	public String getProducto() {
		return producto;
	}
	public Double getPrecio() {
		return precio;
	}
	public boolean isValidProduct(String producto) {
		Boolean isProduct=false;
		ProductsBo pBo = new ProductsBo();
		pBo.getListaDeProductos();
		for (Product prod : pBo.getListaDeProductos()) {
			if (prod.getNombre().equals(producto)) {
				isProduct= true;
			}
		}
		return isProduct;
	}

}