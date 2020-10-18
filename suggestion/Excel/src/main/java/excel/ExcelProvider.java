package excel;

import java.util.ArrayList;
import java.util.List;
import model.IProvider;
import model.Suggestions;


public class ExcelProvider implements IProvider{
	
	private List<Suggestions> listSuggestionsExcel;
	private ExcelConnector ec;
	public String path;
	
	
	public ExcelProvider(String path){
		this.path= path;
		listSuggestionsExcel = new ArrayList<Suggestions>();
		ec= new ExcelConnector(this.path);
	}
	
	@Override
	public List<Suggestions> getSuggestions() {
		if(ec.connect()){
			ExcelValidator ev= new ExcelValidator(this.path);
			if(ev.validadorExcel()){
				listSuggestionsExcel= ev.getListSuggestionsExcel();
			}			
		}
		return listSuggestionsExcel;		
	}
}
