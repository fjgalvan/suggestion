package configuration;

import javax.swing.JButton;
import javax.swing.JPanel;

public interface IPanel{
	JPanel createPanel(); 
	JButton getBtnGuardar();
	JButton getBtnCancelar();
}
