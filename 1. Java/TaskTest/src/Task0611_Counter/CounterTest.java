package Task0611_Counter;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CounterTest extends Frame implements WindowListener,ActionListener {
		
	Label label;
	Button button1, button2, button3;
	
	public CounterTest() {
		setLayout(null);
	
		label = new Label("label");
		label.setBounds(100, 100, 350, 30);
		label.setBackground(Color.yellow);
		add(label);
		
		button1 = new Button();
		button1.setLabel("button one");
		button1.setBounds(100, 160, 150, 30);
		button1.addActionListener(this);
		add(button1);
		
		button2 = new Button("button two");
		button2.setBounds(300, 160, 150, 30);
		button2.addActionListener(this);
		add(button2);
		
		button3 = new Button("reset");
		button3.setBounds(200, 210, 150, 30);
		button3.addActionListener(this);
		add(button3);
		
		
		
		
		
		setBounds(0, 0, 680, 400);
		setVisible(true);
		addWindowListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent co) {
		
		int num;
		String nums;
		
		Button btn = (Button)co.getSource();
		String btnTitle = btn.getLabel(); //레이블 명칭이 타이틀로
	
		if(btnTitle.equals("button one")) {
			nums = (num + 1) + "";
			label.setText(nums);
			;
				
		}
		else if(btnTitle.equals("button two")) {
		
			label.setText("two button click");
			
		}
		else if(btnTitle.equals("reset")) {
		
			label.setText("0");
			
			
			}
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
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
