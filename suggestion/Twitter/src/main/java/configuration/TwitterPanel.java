package configuration;

import java.awt.Color;  
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import configuration.IPanel;
import twitter.Util;

public class TwitterPanel extends Observable implements IPanel {
	private static final String userNameLabel= "USUARIO TWITTER : ";
	private static final String lastTweetsLabel= "ULTIMOS TWEETS : ";
	private static final String saveButtonName= "GUARDAR";
	private static final String errorChooseUserMsg= "Elija un usuario twitter válido";
	private static final String errorChooseNumericMsg= "Elija un valor numérico válido, últimos tweets";
	
	private JTextArea textArea_usuarioTwitter;
	private JTextArea textArea_ultimosTweets;
	private JButton btnGuardar;
	private JButton btnCancelar;
	@Override
	public JPanel createPanel() {//JComponent
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(xPanel,yPanel,widthPanel,heightPanel);
		panel.setLayout(null);
		
		JLabel lblUsuarioTwitter = new JLabel(userNameLabel);
		lblUsuarioTwitter.setBounds(10, 11, 141, 23);
		panel.add(lblUsuarioTwitter);
		
		JLabel lblUltimosTweets = new JLabel(lastTweetsLabel);
		lblUltimosTweets.setBounds(10, 42, 141, 23);
		panel.add(lblUltimosTweets);
		
		btnGuardar = new JButton(saveButtonName);
		btnGuardar.setBounds(xGuardar,yGuardar,widthGuardar,heightGuardar);
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
		btnCancelar.setBounds(xCancelar,yCancelar,widthCancelar,heightCancelar);//(343, 75, 100, 23);
		panel.add(btnCancelar);
		btnCancelar.addActionListener(i->{
			textArea_usuarioTwitter.setText("");
			textArea_ultimosTweets.setText("");
		});
		
		return panel;
	}
	
	public String getUserTwitter(){
		
		if(Util.isUserTwitter(textArea_usuarioTwitter.getText().toString())){
			return textArea_usuarioTwitter.getText().toString();
		}
		else{
			JOptionPane.showMessageDialog(null, errorChooseUserMsg);
			return "";
		}
	}
	public Integer getLastTweets(){
		if(Util.isNumeric(textArea_ultimosTweets.getText())){
			return Integer.parseInt((textArea_ultimosTweets.getText().toString()));
		}
		else{
			JOptionPane.showMessageDialog(null, errorChooseNumericMsg);
			return 0;
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
