package configuration;

import java.awt.Color; 
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import twitter.Comunes;
import ui.IPanel;

public class TwitterPanel extends Observable implements IPanel {
	JTextArea textArea_usuarioTwitter;
	JTextArea textArea_ultimosTweets;
	JButton btnGuardar;
	JButton btnCancelar;
	@Override
	public JPanel createPanel() {//JComponent
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 11, 443, 117);
		panel.setLayout(null);
		
		JLabel lblUsuarioTwitter = new JLabel("USUARIO TWITTER : ");
		lblUsuarioTwitter.setBounds(10, 11, 141, 23);
		panel.add(lblUsuarioTwitter);
		
		JLabel lblUltimosTweets = new JLabel("ULTIMOS TWEETS : ");
		lblUltimosTweets.setBounds(10, 42, 141, 23);
		panel.add(lblUltimosTweets);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(145, 75, 100, 23);
		panel.add(btnGuardar);
		btnGuardar.addActionListener(i->{
			this.setChanged();
			this.notifyObservers(this);
		});
		
		textArea_usuarioTwitter = new JTextArea();
		textArea_usuarioTwitter.setBounds(145, 10, 287, 21);
		panel.add(textArea_usuarioTwitter);
		
		textArea_ultimosTweets = new JTextArea();
		textArea_ultimosTweets.setBounds(145, 41, 100, 21);
		panel.add(textArea_ultimosTweets);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(343, 75, 100, 23);
		panel.add(btnCancelar);
		btnCancelar.addActionListener(i->{
			textArea_usuarioTwitter.setText("");
			textArea_ultimosTweets.setText("");
		});
		
		return panel;
	}
	
	public String getUserTwitter(){
		
		if(Comunes.isUserTwitter(textArea_usuarioTwitter.getText().toString())){
			return textArea_usuarioTwitter.getText().toString();
		}
		else{
			JOptionPane.showMessageDialog(null, "Elija un usuario twitter válido");
			return "";
		}
	}
	public Integer getLastTweets(){
		if(Comunes.isNumeric(textArea_ultimosTweets.getText())){
			return Integer.parseInt((textArea_ultimosTweets.getText().toString()));
		}
		else{
			JOptionPane.showMessageDialog(null, "Elija un valor numérico válido, últimos tweets");
			return 0;
		}
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	
}
