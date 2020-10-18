package ui; 

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import model.IFactory;
import model.IProvider;
import model.Model;
import model.Suggestions;


public class ControllerApp implements ActionListener, Observer {
	private Model m;
	private ViewApp v;
	private List<IFactory> factory;
	private IFactory factoryChose;
	private IConfiguration config;
	
	public ControllerApp(Model m, ViewApp v) {
		this.m = m;
		this.v = v;
		
		this.v.getBtnConfigurar().addActionListener(i->setPanel());
		this.v.getComboBoxProveedor().addActionListener(i->setFactoryChoose());
		this.v.getBtnBuscar().addActionListener(i->getSuggestion());
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
	public void init( List<IFactory> factory){
		this.factory= factory;
	}
	public void setFactoryChoose(){
		String provider= v.getComboBoxProveedor().getSelectedItem().toString();
		try{factoryChose= this.factory.stream().filter(i->i.getProviderName().equals(provider)).findFirst().get();
			config= factoryChose.getConfiguration();}
		catch(Exception e) {
			 JOptionPane.showMessageDialog(null, "Elija un proveedor válido");
		}
	}
	public void setPanel(){
		try{v.nuevoPanel(factoryChose.getPanel(Arrays.asList(this)).createPanel());}
		catch(Exception e) {
			 JOptionPane.showMessageDialog(null, "Elija un proveedor válido");
		}
	}
	public void getSuggestion(){
		String chooseFood= v.getComboBox_comida().getSelectedItem().toString();
		String choosePrice= v.getComboBox_precio().getSelectedItem().toString();
		this.v.getTextArea_Sugerencias().setText("");
		this.m.getSuggestion();
		Iterator<Suggestions> nombreIterator = this.m.getFilteredSuggestions(chooseFood, choosePrice).iterator();
		
		while (nombreIterator.hasNext()) {
			Suggestions elemento = nombreIterator.next();
			this.v.getTextArea_Sugerencias().append(elemento.getLocal()+", "+elemento.getUbicacion()+
			", "+elemento.getProducto()+", $"+elemento.getPrecio()+", "+elemento.getFechaDeVigencia().getDate()+"\n");
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		IProvider providerWithNewConfig= config.configureProvider((IPanel) arg);
		this.m.setProvider(providerWithNewConfig);
	}
}
