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
	
	public List<Suggestions> getSuggestion(){
		return this.provider.getSuggestions();
	}
	
	public void setProvider(IProvider p){
		this.provider= p;
	}

	public IProvider getProvider() {
		return provider;
	}
	
}
