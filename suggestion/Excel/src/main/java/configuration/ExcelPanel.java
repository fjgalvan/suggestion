package configuration;

import java.awt.Color;  
import java.io.File;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import ui.IPanel;

public class ExcelPanel extends Observable implements IPanel{
	JTextArea textArea_rutaExcel;
	JButton btnGuardar;
	JButton btnCancelar;
	JButton btnAbrir;
	@Override
	public JPanel createPanel() {//JComponent
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(10, 11, 443, 117);
		panel.setLayout(null);
		
		JLabel lblRutaExcel = new JLabel("RUTA EXCEL:");
		lblRutaExcel.setBounds(10, 11, 75, 23);
		panel.add(lblRutaExcel);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(145, 75, 100, 23);
		panel.add(btnGuardar);
		btnGuardar.addActionListener(i->{
			this.setChanged();
			this.notifyObservers(this);
		});//Paso el panel
		
		textArea_rutaExcel = new JTextArea();
		textArea_rutaExcel.setBounds(91, 10, 340, 21);
		panel.add(textArea_rutaExcel);
		textArea_rutaExcel.setEditable(false);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(343, 75, 100, 23);
		panel.add(btnCancelar);
		
		btnAbrir = new JButton("ABRIR");
		btnAbrir.setBounds(343, 35, 100, 23);
		panel.add(btnAbrir);
		btnAbrir.addActionListener(i->{
			JFileChooser jf = new JFileChooser();
			FileFilter filtro= new FileNameExtensionFilter("Archivos Excel (.xlsx)","xlsx");
			jf.setFileFilter(filtro);
			jf.showOpenDialog(panel);
			File archivo = jf.getSelectedFile();
			if(archivo != null){
				textArea_rutaExcel.setText(archivo.getAbsolutePath());
			}
		});
		
		return panel;
	}
	
	public String getPath(){
		return textArea_rutaExcel.getText().toString();
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

}