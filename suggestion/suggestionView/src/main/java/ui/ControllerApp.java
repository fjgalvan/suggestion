package ui; 

import java.awt.event.ActionEvent;     
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import configuration.IConfiguration;
import configuration.IPanel;
import provider.IFactory;
import provider.IProvider;
import provider.Suggestions;
import model.Model;


public class ControllerApp implements ActionListener, Observer {
	private static final String errorProvider= "Elija un proveedor válido";
	private static final String errorConfiguration= "Elija una configuración válida y elija los filtros!";
	private Model model;
	private ViewApp view;
	private List<IFactory> factory;
	private IFactory factoryChose;
	private IConfiguration config;
	
	public ControllerApp(Model m, ViewApp v) {
		this.model = m;
		this.view = v;
		
		this.view.getBtnConfigurar().addActionListener(i->setPanel());
		this.view.getComboBoxProveedor().addActionListener(i->setFactoryChoose());
		this.view.getBtnBuscar().addActionListener(i->getSuggestion());
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
	public void init( List<String> listFactoriesName){
		List<IFactory> factories= this.model.initFactories(listFactoriesName);
		this.view.loadProviders(factories.stream().map(i->i.getProviderName()).collect(Collectors.toList()));
		this.factory= factories;
		this.view.setVisible(true);
	}
	public void setFactoryChoose(){
		String provider= view.getComboBoxProveedor().getSelectedItem().toString();
		try{factoryChose= this.factory.stream().filter(i->i.getProviderName().equals(provider)).findFirst().get();
			config= factoryChose.getConfiguration();}
		catch(Exception e) {
			 JOptionPane.showMessageDialog(null, errorProvider);
		}
	}
	public void setPanel(){
		try{view.nuevoPanel(factoryChose.getPanel(Arrays.asList(this)).createPanel());}
		catch(Exception e) {
			 JOptionPane.showMessageDialog(null, errorProvider);
		}
	}
	public void getSuggestion(){
		try{
			String chooseFood= view.getComboBox_comida().getSelectedItem().toString();
			String choosePrice= view.getComboBox_precio().getSelectedItem().toString();
			this.view.getTextArea_Sugerencias().setText("");
			Iterator<Suggestions> nombreIterator = this.model.getFilteredSuggestions(chooseFood, choosePrice).iterator();
			
			while (nombreIterator.hasNext()) {
				Suggestions elemento = nombreIterator.next();
				this.view.getTextArea_Sugerencias().append(elemento.getLocal()+", "+elemento.getUbicacion()+
				", "+elemento.getProducto()+", $"+elemento.getPrecio()+", "+elemento.getFechaDeVigencia().getDate()+"\n");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, errorConfiguration);
		}
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		IProvider providerWithNewConfig= config.configureProvider((IPanel) arg);
		this.model.setProvider(providerWithNewConfig);
	}
}
