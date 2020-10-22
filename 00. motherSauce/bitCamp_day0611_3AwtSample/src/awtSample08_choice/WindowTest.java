package awtSample08_choice;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowTest extends Frame implements WindowListener {
	
	Choice choice;//select option              Swing -> JComboBox
	Label label;
	
	public WindowTest() {
		
		setLayout(new FlowLayout());
		
		choice = new Choice();
		choice.add("사과");
		choice.add("배");
		choice.add("귤");
		choice.add("감");
		choice.add("포도");
		
		choice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				label.setText(choice.getSelectedItem());
			}
		});
		add(choice);
		
		label = new Label("옆으로 튀오나올 과일");
		add(label);
		
		setBounds(0, 0, 640, 480);
		setVisible(true);
		addWindowListener(this);
	}
	
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
