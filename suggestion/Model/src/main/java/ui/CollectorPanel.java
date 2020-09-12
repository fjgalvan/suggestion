package ui;
  
import java.util.ArrayList;
import java.util.List;

import connection.ConnectorSearcher;
import connection.MyClassLoader;

public class CollectorPanel {
	private List<IPanel> listPanel;

	public CollectorPanel() {

		listPanel = new ArrayList<IPanel>();
	}

	public List<IPanel> loadPanel(List<String> classesToLoad) {
		MyClassLoader mecanismos = new MyClassLoader();
		// Se castea automáticamente a IConector en la asignación!!
		listPanel = mecanismos.load(ConnectorSearcher.rutaFile,classesToLoad);
		return listPanel;
	}

	public List<IPanel> getPanel() {
		return listPanel;
	}


}
