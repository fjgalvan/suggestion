package model;

import java.util.Iterator;
import java.util.List;

public class Model {
	private IProvider provider;
	ProviderManager pm;
	
	public Model(){
		pm = new ProviderManager();
	}
	
	public void inicializar() {
		// Leo todos los Productos que tengo en ProductosBo
		ProductsBo pBo = new ProductsBo();
		pBo.getListaDeProductos();
	}
	
//	public IProvider getProviders(String nameProvider){
//		this.provider= pm.loadProvider(nameProvider);
//		return this.provider;
//	}
	
	public List<Suggestions> getSuggestion(){
		return this.provider.getSuggestions();
	}
	
	public void setProvider(IProvider p){
		this.provider= p;
	}

	public void printSuggestions(List<Suggestions> l){
		System.out.println("printSuggestions");
		Iterator<Suggestions> nombreIterator = l.iterator();
		while (nombreIterator.hasNext()) {
			Suggestions elemento = nombreIterator.next();
			System.out.println("elemento: ");
			System.out.println(elemento.getLocal()+", "+elemento.getUbicacion()+
			", "+elemento.getProducto()+", "+elemento.getPrecio()+", "+elemento.getFechaDeVigencia().getDate()+"\n");
		}
		
	}
	
}
