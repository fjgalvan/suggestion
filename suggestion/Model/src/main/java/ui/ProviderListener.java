package ui;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


import model.Model;


public class ProviderListener implements ActionListener {
	Model m;
	ViewApp v;
	public ProviderListener(Model m, ViewApp v){
		this.m= m;
		this.v= v;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		v.getBtnConfigurar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(v.getComboBoxProveedor().getSelectedItem().toString().equals("twitter.TwitterProvider")){
					v.nuevoPanel(loadPanel().get(0).createPanel());
				}
				if(v.getComboBoxProveedor().getSelectedItem().toString().equals("excel.ExcelProvider")){
					v.nuevoPanel(loadPanel().get(1).createPanel());
				}
			}
			
			public List<IPanel> loadPanel(){
				List<String> classesToLoad = new ArrayList<String>();
				classesToLoad.add("configuration.TwitterPanel");
				classesToLoad.add("configuration.ExcelPanel");

				CollectorPanel panel = new CollectorPanel();
				panel.loadPanel(classesToLoad);
				return panel.getPanel();
			}
		});	
	}
}
