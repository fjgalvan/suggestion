package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import connection.IConnector;

public class ExcelConnector implements IConnector{
	private static final String errorMsg= "Se Produjo un Error de Conexion con Excel!!!  ";
	private String path;
	private FileInputStream file;
	
	public ExcelConnector(String path){
		this.path= path;
	}
	
	@Override
	public boolean connect() {
		try  {
			this.setFile(new FileInputStream(new File(this.path)));
			return true;
		}catch (IOException e) {
			System.out.println(errorMsg + e.getMessage());
			return false;
		}
		
	}

	@Override
	public boolean disconnect() {
		this.setFile(null);
		return false;
	}

	public FileInputStream getFile() {
		return file;
	}

	public void setFile(FileInputStream file) {
		this.file = file;
	}


}
