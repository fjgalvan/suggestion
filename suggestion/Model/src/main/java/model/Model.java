package model;

public class Model {
	
	public Model(){

	}
	
	
	public void inicializar() {
		// Leo todos los Productos que tengo en ProductosBo
		ProductsBo pBo = new ProductsBo();
		pBo.getListaDeProductos();
	}
}
