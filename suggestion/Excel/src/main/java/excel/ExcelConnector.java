package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import connection.IConnector;

public class ExcelConnector implements IConnector{
	String path;
	
	public ExcelConnector(String path){
		this.path= path;
	}
	
	@SuppressWarnings({ "unused", "resource" })
	@Override
	public boolean connect() {
		try  {
			FileInputStream file = new FileInputStream(new File(this.path));
			return true;
		}catch (IOException e) {
			System.out.println("Se Produjo un Error de Conexion con Excel!!!  "+e.getMessage());
			return false;
		}
		
	}

	@Override
	public boolean disconnect() {
		return false;
	}


}
