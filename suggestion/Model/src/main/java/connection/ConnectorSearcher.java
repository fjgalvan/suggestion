package connection;

import java.io.File;

public class ConnectorSearcher {
	public static final String rutaFile = "C:\\MecanismosDeConexionExterna";
	File path = new File(rutaFile);
	
	public ConnectorSearcher(){
	}

	public File getPath() {
		return path;
	}

	public void setPath(File path) {
		this.path = path;
	}
}
