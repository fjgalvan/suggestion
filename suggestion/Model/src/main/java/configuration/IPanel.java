package configuration;

import javax.swing.JButton;
import javax.swing.JPanel;

public interface IPanel{
	public final static Integer xPanel= 10;
	public final static Integer yPanel= 11;
	public final static Integer widthPanel= 443;
	public final static Integer heightPanel= 117;

	public final static Integer xGuardar= 145;
	public final static Integer yGuardar= 75;
	public final static Integer widthGuardar= 100;
	public final static Integer heightGuardar= 23;
	
	public final static Integer xCancelar= 343;
	public final static Integer yCancelar= 75;
	public final static Integer widthCancelar= 100;
	public final static Integer heightCancelar= 23;
	
	JPanel createPanel(); 
	JButton getBtnGuardar();
	JButton getBtnCancelar();
}
