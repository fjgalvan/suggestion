package configuration;

import java.awt.Color;    
import java.io.File;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import configuration.IPanel;

public class ExcelPanel extends Observable implements IPanel{
	private static final String pathLabel= "RUTA EXCEL:";
	private static final String saveButtonName= "GUARDAR";
	private static final String cancelButtonName= "CANCELAR";
	private static final String openButtonName= "ABRIR";
	private static final String helpExtention= "Archivos Excel (.xlsx)";
	private static final String extentionExcelFile= "xlsx";
	private static final String errorPathMsg= "Elija una ruta válida!";
	private static final String okPathMsg= "configuración exitosa!";
	
	private JTextArea textArea_rutaExcel;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnAbrir;
	@Override
	public JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(xPanel,yPanel,widthPanel,heightPanel);
		panel.setLayout(null);
		
		JLabel lblRutaExcel = new JLabel(pathLabel);
		lblRutaExcel.setBounds(10, 11, 75, 23);
		panel.add(lblRutaExcel);
		
		btnGuardar = new JButton(saveButtonName);
		btnGuardar.setBounds(xGuardar, yGuardar, widthGuardar, heightGuardar);
		panel.add(btnGuardar);
		btnGuardar.addActionListener(i->{
			this.setChanged();
			this.notifyObservers(this);
		});
		
		textArea_rutaExcel = new JTextArea();
		textArea_rutaExcel.setBounds(91, 10, 340, 21);
		panel.add(textArea_rutaExcel);
		textArea_rutaExcel.setEditable(false);
		
		btnCancelar = new JButton(cancelButtonName);
		btnCancelar.setBounds(xCancelar, yCancelar, widthCancelar, heightCancelar);
		panel.add(btnCancelar);
		btnCancelar.addActionListener(i->{
			textArea_rutaExcel.setText("");
		});
		
		btnAbrir = new JButton(openButtonName);
		btnAbrir.setBounds(343, 35, 100, 23);
		panel.add(btnAbrir);
		btnAbrir.addActionListener(i->{
			JFileChooser jf = new JFileChooser();
			FileFilter filtro= new FileNameExtensionFilter(helpExtention,extentionExcelFile);
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
		if(excel.Util.isAbsolutePath(textArea_rutaExcel.getText().toString())){
			JOptionPane.showMessageDialog(null, okPathMsg);
			return textArea_rutaExcel.getText().toString();
		}
		else{
			JOptionPane.showMessageDialog(null, errorPathMsg);
			return "";
		}
	}
	@Override
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	@Override
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

}