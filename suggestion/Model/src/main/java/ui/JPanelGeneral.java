package ui;

//import java.awt.Color; 
import javax.swing.JButton;
//import javax.swing.JPanel;


public class JPanelGeneral {
	IPanel panel;
	IConfiguration config;
	JButton btnGuardar;
	JButton btnCancelar;
	
	public JPanelGeneral(){
	}
	
	public void search(IPanel panel,IConfiguration config){
		this.panel= panel;
		this.config= config;
		this.config.configureProvider(panel);
	}
	
//	public JPanel createPanel() {
//		JPanel panel = new JPanel();
//		panel.setBackground(Color.WHITE);
//		panel.setBounds(10, 11, 443, 117);
//		panel.setLayout(null);
//		
//		btnGuardar = new JButton("GUARDAR");
//		btnGuardar.setBounds(145, 75, 100, 23);
//		panel.add(btnGuardar);
//	
//		btnCancelar = new JButton("CANCELAR");
//		btnCancelar.setBounds(343, 75, 100, 23);
//		panel.add(btnCancelar);
//		
//		return panel;
//	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
	
	
}
