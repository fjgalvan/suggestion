package ui;

import java.util.List;

import model.Suggestions;


public interface IConfiguration {
	//Agarro todos los datos de los campos que sean
	public void getData(IPanel panel);
	//Lógica para uno
	public List<Suggestions> buscar();
}
