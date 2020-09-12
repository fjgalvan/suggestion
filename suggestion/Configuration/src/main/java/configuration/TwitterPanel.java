package configuration;

import java.awt.Color; 

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ui.IPanel;

public class TwitterPanel implements IPanel{
	JTextArea textArea_usuarioTwitter;
	JTextArea textArea_ultimosTweets;
	@Override
	public JPanel createPanel() {//JComponent
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(10, 11, 443, 117);
		panel.setLayout(null);
		
		JLabel lblUsuarioTwitter = new JLabel("USUARIO TWITTER : ");
		lblUsuarioTwitter.setBounds(10, 11, 141, 23);
		panel.add(lblUsuarioTwitter);
		
		JLabel lblUltimosTweets = new JLabel("ULTIMOS TWEETS : ");
		lblUltimosTweets.setBounds(10, 42, 141, 23);
		panel.add(lblUltimosTweets);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(145, 75, 100, 23);
		panel.add(btnGuardar);
		
		textArea_usuarioTwitter = new JTextArea();
		textArea_usuarioTwitter.setBounds(145, 10, 287, 21);
		panel.add(textArea_usuarioTwitter);
		
		textArea_ultimosTweets = new JTextArea();
		textArea_ultimosTweets.setBounds(145, 41, 100, 21);
		panel.add(textArea_ultimosTweets);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(343, 75, 100, 23);
		panel.add(btnCancelar);
		
		return panel;
	}
	
	public String getUserTwitter(){
		return textArea_usuarioTwitter.getText().toString();
	}
	
	public Integer getLastTweets(){
		return Integer.parseInt((textArea_ultimosTweets.getText().toString()));
	}
}
