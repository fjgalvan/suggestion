package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class ViewApp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewApp frame = new ViewApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(125, 154, 254, 62);
		contentPane.add(textArea_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(125, 63, 254, 76);
		contentPane.add(panel);
		
		JButton btnConfigurar = new JButton("CONFIGURAR");
		btnConfigurar.setBounds(414, 26, 109, 23);
		contentPane.add(btnConfigurar);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(175, 227, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblConectores = new JLabel("CONECTOR");
		lblConectores.setBounds(10, 12, 102, 23);
		contentPane.add(lblConectores);
		
		JLabel lblPanel = new JLabel("PANEL");
		lblPanel.setBounds(10, 60, 46, 14);
		contentPane.add(lblPanel);
		
		JLabel lblRecomendacin = new JLabel("RECOMENDACIÒN");
		lblRecomendacin.setBounds(10, 159, 89, 14);
		contentPane.add(lblRecomendacin);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(125, 13, 259, 31);
		contentPane.add(comboBox);
	}
}
