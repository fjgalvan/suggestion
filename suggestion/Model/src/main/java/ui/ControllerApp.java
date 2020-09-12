package ui;

import javax.swing.JTextArea;

import model.Model;


public class ControllerApp {
	Model m;
	ViewApp v;
	static JTextArea t;
	
	public ControllerApp(Model m, ViewApp v) {
		// Asignamos un modelo a nuestro controlador.
		this.m = m;
		this.v = v;
		
		v.addLoadPanelListener(new ProviderListener(m,v));
	}
	
	
}
