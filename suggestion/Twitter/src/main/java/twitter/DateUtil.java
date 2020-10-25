package twitter;

import java.util.Calendar;
import java.util.Date;


public class DateUtil {
	static Date date= new Date();
	static Calendar c;
	
	public DateUtil(){
		c = Calendar.getInstance();
	}
	
	public static void FechaActualMostrar(){
		String dia = Integer.toString(c.get(Calendar.DATE));
		String mes = Integer.toString(c.get(Calendar.MONTH));
		String annio = Integer.toString(c.get(Calendar.YEAR));
		System.out.println(dia +"-"+ mes +"-"+ annio);
	}
	
	public Integer getDiaActual(){
		return c.get(Calendar.DATE);
	}
	
	public Integer getMesActual(){
		return c.get(Calendar.MONTH)+1;
	}
	
	public Integer getAnnioActual(){
		return c.get(Calendar.YEAR);
	}
}
