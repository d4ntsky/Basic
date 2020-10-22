package awtSample03_layout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener {
	
	public WindowTest() {
		super("Layout");
		
		//setLayout(new FlowLayout());
		//setLayout(new GridLayout(3,1));//3행 1열 //Grid 격자
		setLayout(null);
		
		//Label
		Label label1 = new Label("Label 1");
		label1.setBackground(new Color(255, 0, 0));
		//추가
		label1.setBounds(150, 30, 50, 30);
		
		add(label1);
		
		
		//Label
		Label label2 = new Label("Lable 2");
		label2.setBackground(Color.yellow);
		//추가
		label2.setBounds(150, 80, 70,30);
		
		add(label2);
		
		
		//Button
		Button button = new Button();
		button.setLabel("Button");
		button.setBounds(150, 150, 100, 30);
		add(button);
		
		
		//----------------
		setBounds(0, 0, 640, 480);
		setVisible(true);
		
		addWindowListener(this);		
		
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void windowClosed(WindowEvent e) {
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
