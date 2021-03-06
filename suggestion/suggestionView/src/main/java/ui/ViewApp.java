package ui;
 
import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String config = "CONFIGURAR";
	private static final String load= "BUSCAR";
	private static final String provider= "PROVEEDOR";
	private static final String configuration= "CONFIGURACION: ";
	private static final String suggestion= "SUGERENCIAS";
	private static final String chooseMsgProvider= "Elegir Proveedor!";
	private static final String chooseFood= "elija un tipo de comida!";
	private static final String scrap= "chatarras";
	private static final String desserts= "postres";
	private static final String healthy= "sanas";
	private static final String pasta= "pastas";
	private static final String filters= "FILTROS: ";
	private static final String chooseMsgPriceMax="elija un rango de precio máximo!";
	private static final String low= "barato";
	private static final String medium= "regular";
	private static final String big= "caro";
	
	private JPanel contentPane;
	private JPanel panel;
	private JComboBox<String> comboBoxProveedor;
	public JComboBox<String> comboBox_comida;
	public JComboBox<String> comboBox_precio;
	public JButton btnConfigurar;
	JButton btnBuscar;
	private JTextArea textArea_Sugerencias;
	
	public ViewApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textArea_Sugerencias = new JTextArea();
		textArea_Sugerencias.setBounds(125, 240, 477, 112);
		textArea_Sugerencias.setEditable(false);
		textArea_Sugerencias.setVisible(true);
		
		JScrollPane scroll = new JScrollPane (textArea_Sugerencias, 
			      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(125, 301, 477, 112);
		contentPane.add(scroll);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(125, 63, 477, 142);
		contentPane.add(panel);
		panel.setLayout(null);

		btnConfigurar = new JButton(config);
		btnConfigurar.setBounds(413, 12, 109, 31);
		contentPane.add(btnConfigurar);

		btnBuscar = new JButton(load);
		btnBuscar.setBounds(295, 424, 89, 31);
		contentPane.add(btnBuscar);

		JLabel lblConectores = new JLabel(provider);
		lblConectores.setBounds(10, 12, 102, 23);
		contentPane.add(lblConectores);

		JLabel lblPanel = new JLabel(configuration);
		lblPanel.setBounds(10, 63, 109, 14);
		contentPane.add(lblPanel);

		JLabel lblSugerencias = new JLabel(suggestion);
		lblSugerencias.setHorizontalAlignment(SwingConstants.LEFT);
		lblSugerencias.setBounds(10, 307, 105, 14);
		contentPane.add(lblSugerencias);
		
		comboBoxProveedor = new JComboBox<String>();
		comboBoxProveedor.setBounds(125, 13, 259, 31);
		comboBoxProveedor.addItem(chooseMsgProvider);
		contentPane.add(comboBoxProveedor);
		
		comboBox_comida = new JComboBox<String>();
		comboBox_comida.setBounds(125, 226, 216, 20);
		comboBox_comida.addItem(chooseFood);
		comboBox_comida.addItem(scrap);
		comboBox_comida.addItem(desserts);
		comboBox_comida.addItem(healthy);
		comboBox_comida.addItem(pasta);
		contentPane.add(comboBox_comida);
		
		JLabel lblFiltros = new JLabel(filters);
		lblFiltros.setBounds(10, 229, 102, 14);
		contentPane.add(lblFiltros);
		
		comboBox_precio = new JComboBox<String>();
		comboBox_precio.setBounds(386, 226, 216, 20);
		comboBox_precio.addItem(chooseMsgPriceMax);
		comboBox_precio.addItem(low);
		comboBox_precio.addItem(medium);
		comboBox_precio.addItem(big);
		contentPane.add(comboBox_precio);
	}
	
	public void nuevoPanel(JPanel panelActual){
		panel.removeAll();
		panel.add(panelActual);
		panel.repaint();
		panel.revalidate();
	}
	public void loadProviders(List<String> ls){
		for(int i = 0; i < ls.size(); i++) {
			getComboBoxProveedor().addItem(ls.get(i).toString());;
		}
	}
	public void loadPanel(JComponent jComponent){
		setPanel((JPanel) jComponent);
	}

	public JPanel getContentPane() {
		return contentPane;
	}
	public JComboBox<String> getComboBoxProveedor() {
		return comboBoxProveedor;
	}
	public JComboBox<String> getComboBox_comida() {
		return comboBox_comida;
	}
	public JComboBox<String> getComboBox_precio() {
		return comboBox_precio;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public void addLoadPanelListener(ActionListener listen) {
		btnConfigurar.addActionListener(listen);
	}
	public JButton getBtnConfigurar() {
		return btnConfigurar;
	}
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	public JTextArea getTextArea_Sugerencias() {
		return textArea_Sugerencias;
	}
}
