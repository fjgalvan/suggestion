package excel;

import java.io.File;   
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import provider.Suggestions;
import util.DateS;


public class ExcelValidator {
	public static final String promoLocal ="local";
	public static final String promoUbicacion ="Ubicacion";
	public static final String promoProducto ="Producto";
	public static final String promoPrecio ="Precio";
	public static final String promoFechaDeVigencia ="fechaDeVigencia";
	public static final String promolComidas ="lComidas";
	private static final String formatDate= "dd/MM/yyyy";
	private static final String errorMsg= "Se Produjo un Error!!!  ";
	private static final String regularExpressionNumeric=  "[+-]?\\d*(\\.\\d+)?";
	private Integer aux = 0;
	private Integer contCellCollValido = 0;
	private String local = "";
	private String ubicacion = "";
	private String nombreProducto = "";
	private Double precio;
	private String fechaV="";
	private DateS date;
	private DateS fechaDeVigencia;
	public List<Suggestions> listSuggestionsExcel;
	private String path;
	
	public ExcelValidator(String path) {
		listSuggestionsExcel = new ArrayList<Suggestions>();
		this.path= path;
	}

	public boolean validadorExcel() {
		boolean valido = false;
		Integer contValidadorFechas = 0;
		Integer contFilas = 0;
		Integer contColumna = 0;

		Integer contCeldas = 1;

		try (FileInputStream file = new FileInputStream(new File(this.path))) {
			@SuppressWarnings("resource")
			XSSFWorkbook worbook = new XSSFWorkbook(file);
			XSSFSheet sheet = worbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			Row row;
			while (rowIterator.hasNext()) {
				contFilas = contFilas + 1;
				row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				Cell cell;
				while (cellIterator.hasNext()) {
					cell = cellIterator.next();
					contCeldas = contCeldas + 1;
					if (contFilas == 1) {
						ValidadorDeColumnas(contColumna, cell);
						if ((contColumna == 4) && (aux < 5)) {
							return false;
						}
					}
					if (contFilas > 1) {

						try {
							contCellValidosParaSerUnaSugerencia(contColumna,
									cell.getStringCellValue());
						} catch (Exception e) {
							if (DateUtil.isCellDateFormatted(cell)) {
								SimpleDateFormat formateador = new SimpleDateFormat(
										formatDate);
								this.fechaV = formateador.format(cell
										.getDateCellValue());
								contCellValidosParaSerUnaSugerencia(
										contColumna, this.fechaV);
							} else {
								contCellValidosParaSerUnaSugerencia(
										contColumna, Double.toString(cell
												.getNumericCellValue()));
							}
						}
					}

					contColumna = contColumna + 1;
					contValidadorFechas = contValidadorFechas + 1;

				}
				contValidadorFechas = 0;
				contColumna = 0;
				if (contCellCollValido == 5) {
					listSuggestionsExcel.add(generarUnaSugerencia());
				}
				contCellCollValido = 0;

			}
		} catch (Exception e) {
			e.getMessage();
		}
		if (aux == 5) {
			valido = true;
		}
		return valido;
	}

	public Integer ValidadorDeColumnas(Integer cont, Cell cell) {

		if ((cont == 0)
				&& (cell.getStringCellValue()
						.equals(promoLocal))) {
			aux = aux + 1;
		}
		if ((cont == 1)
				&& (cell.getStringCellValue()
						.equals(promoUbicacion))) {
			aux = aux + 1;
		}
		if ((cont == 2)
				&& (cell.getStringCellValue()
						.equals(promoProducto))) {
			aux = aux + 1;
		}
		if ((cont == 3)
				&& (cell.getStringCellValue()
						.equals(promoPrecio))) {
			aux = aux + 1;
		}
		if ((cont == 4)
				&& (cell.getStringCellValue()
						.equals(promoFechaDeVigencia))) {
			aux = aux + 1;
		}

		return aux;
	}

	public Date parsearStringADate(String fecha) throws ParseException {
		SimpleDateFormat formateador = new SimpleDateFormat(formatDate);
		Date d = formateador.parse(fecha);
		return d;
	}

	public boolean isFechaVigente(String strFecha) {// if cont==4
		Date fechaActual = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat(formatDate);
		String fechaSistema = formateador.format(fechaActual);

		boolean resultado = false;
		try {
			/** Obtenemos las fechas enviadas en el formato a comparar */
			Date fechaDate1 = formateador.parse(strFecha);
			Date fechaDate2 = formateador.parse(fechaSistema);

			if (fechaDate1.before(fechaDate2)) {
				resultado = false;// "La Fecha 1 es menor ";
			} else {
				if (fechaDate2.before(fechaDate1)) {
					resultado = true;// "La Fecha 1 es Mayor ";
				} else {
					resultado = true;// "Las Fechas Son iguales ";
				}
			}
		} catch (ParseException e) {
			System.out.println(errorMsg + e.getMessage());
		}
		return resultado;
	}

	public boolean isNumeric(String str) {// if cont==3
		return (str.matches(regularExpressionNumeric) && str.equals("") == false);
	}

	public Integer contCellValidosParaSerUnaSugerencia(Integer contColumna, 
			String cell) throws ParseException {
		if (contColumna == 0) {
			this.local = cell;
			this.contCellCollValido = this.contCellCollValido + 1;
		}
		if (contColumna == 1) {
			this.ubicacion = cell;
			this.contCellCollValido = this.contCellCollValido + 1;
		}
		if (contColumna == 2) {
			this.nombreProducto = cell;
			this.contCellCollValido = this.contCellCollValido + 1;
		}
		if (contColumna == 3) {
			if (isNumeric(cell)) {
				this.precio = Double.parseDouble(cell);
				this.contCellCollValido = this.contCellCollValido + 1;
			} else {
			}
		}
		if (contColumna == 4) {
			if (isFechaVigente(cell)) {
				this.fechaDeVigencia = parsearFecha(this.fechaV);//parsearStringADate(cell);
				this.contCellCollValido = this.contCellCollValido + 1;
			}
		}
		return this.contCellCollValido;
	}

	private Suggestions generarUnaSugerencia() {
		Suggestions s = new Suggestions(this.local, this.ubicacion,
				this.nombreProducto, this.precio, this.fechaDeVigencia);
		return s;
	}
	
	private DateS parsearFecha(String f){
		String[] parts = f.split("/");
		String ddString= parts[0];
		String mmString= parts[1];
		String aaaaString= parts[2];
		date= new DateS(Integer.parseInt(ddString),Integer.parseInt(mmString),Integer.parseInt(aaaaString));
		return date;
	}

	public List<Suggestions> getListSuggestionsExcel() {
		return listSuggestionsExcel;
	}


}
