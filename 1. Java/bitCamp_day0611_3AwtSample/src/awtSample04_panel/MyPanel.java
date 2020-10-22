package awtSample04_panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class MyPanel extends Panel{
	
	public MyPanel() {
		
		setLayout(new GridLayout(3,1));
		setBackground(Color.red);
		
		Label label1 = new Label("MyPanel label 1");
		add(label1);
		
		Label label2 = new Label("MyPanel label 2");
		add(label2);
		
		Label label3 = new Label("MyPanel label 3");
		add(label3);
	}
}
