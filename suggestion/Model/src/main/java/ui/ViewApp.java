package ui;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import model.Model;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JComboBox<String> comboBoxProveedor;
	public JButton btnConfigurar;
	JButton btnBuscar;
	public JButton btnGuardar;
	public JPanelGeneral pGeneral;


	/**
	 * Create the frame.
	 * @param m 
	 */
	public ViewApp(Model m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea textArea_Sugerencias = new JTextArea();
		textArea_Sugerencias.setBounds(125, 240, 477, 112);
		contentPane.add(textArea_Sugerencias);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(125, 63, 477, 142);
		contentPane.add(panel);
		panel.setLayout(null);

		btnConfigurar = new JButton("CONFIGURAR");
		btnConfigurar.setBounds(413, 12, 109, 31);
		contentPane.add(btnConfigurar);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(281, 359, 89, 31);
		contentPane.add(btnBuscar);

		JLabel lblConectores = new JLabel("PROVEEDOR");
		lblConectores.setBounds(10, 12, 102, 23);
		contentPane.add(lblConectores);

		JLabel lblPanel = new JLabel("PANEL");
		lblPanel.setBounds(10, 60, 46, 14);
		contentPane.add(lblPanel);

		JLabel lblSugerencias = new JLabel("SUGERENCIAS");
		lblSugerencias.setHorizontalAlignment(SwingConstants.LEFT);
		lblSugerencias.setBounds(10, 245, 89, 14);
		contentPane.add(lblSugerencias);

		comboBoxProveedor = new JComboBox<String>();
		comboBoxProveedor.setBounds(125, 13, 259, 31);
		contentPane.add(comboBoxProveedor);
		
		//ControllerApp c = new ControllerApp(m, this);
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
	public JButton getBtnGuardar() {
		return pGeneral.getBtnGuardar();
	}
	public JButton getBtnCancelar() {
		return pGeneral.getBtnCancelar();
	}
	
}
