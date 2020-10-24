package connection;

import java.io.File;

public class ConnectorSearcher {
	public static final String pathFile = "C:\\MecanismosDeConexionExterna";
	private File path;
	
	public ConnectorSearcher(){
		path = new File(pathFile);
	}

	public File getPath() {
		return path;
	}

	public void setPath(File path) {
		this.path = path;
	}
}
