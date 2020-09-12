package configuration;

import java.awt.Color; 

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ui.IPanel;

public class ExcelPanel implements IPanel{
	JTextArea textArea_rutaExcel;
	@Override
	public JPanel createPanel() {//JComponent
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(10, 11, 443, 117);
		panel.setLayout(null);
		
		JLabel lblRutaExcel = new JLabel("RUTA EXCEL:");
		lblRutaExcel.setBounds(10, 11, 75, 23);
		panel.add(lblRutaExcel);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(145, 75, 100, 23);
		panel.add(btnGuardar);
		
		textArea_rutaExcel = new JTextArea();
		textArea_rutaExcel.setBounds(91, 10, 340, 21);
		panel.add(textArea_rutaExcel);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(343, 75, 100, 23);
		panel.add(btnCancelar);
		
		return panel;
	}
	
	public String getPath(){
		return textArea_rutaExcel.getText().toString();
	}
}