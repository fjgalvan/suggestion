package provider;

import util.DateS;

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
}