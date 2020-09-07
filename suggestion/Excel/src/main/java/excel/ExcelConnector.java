package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import connection.IConnector;

public class ExcelConnector implements IConnector{
	
	public ExcelConnector(){
		
	}
	
	@SuppressWarnings({ "unused", "resource" })
	@Override
	public boolean connect() {
		String nombreArchivo = MyConstantsConexiones.nombreArchivoExcelXlsx;
		String rutaArchivo =  MyConstantsConexiones.rutaArchivoExcelXlsx+ nombreArchivo;
		//String hoja = MyConstantsConexiones.hojaExcelXlsx;
		try  {
			FileInputStream file = new FileInputStream(new File(rutaArchivo));
			System.out.println("Conexión Excel correcto!");
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
	
	public static void main(String[] args) {
		ExcelConnector ec= new ExcelConnector();
		
		System.out.println(ec.connect());

	}

}
