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
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				if(v.getComboBoxProveedor().getSelectedItem().toString().equals("Twitter")){
//					v.nuevoPanel(loadPanel().get(0).createPanel());
//				}
//				if(v.getComboBoxProveedor().getSelectedItem().toString().equals("Excel")){
//					v.nuevoPanel(loadPanel().get(1).createPanel());
//				}
//			}
			
		});	
	}
}
