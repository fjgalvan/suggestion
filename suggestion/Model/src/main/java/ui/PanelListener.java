package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Model;

public class PanelListener implements ActionListener{
	Model m;
	ViewApp v;
	public PanelListener(Model m, ViewApp v){
		this.m= m;
		this.v= v;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		v.getBtnGuardar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("GUARDAR");
			}
		});
		
	}
	
}
