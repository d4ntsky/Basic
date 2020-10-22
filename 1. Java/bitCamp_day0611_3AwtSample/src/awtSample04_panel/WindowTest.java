package awtSample04_panel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener {

	public WindowTest() {
		super("panel");
		
		setLayout(new GridLayout(2,1));
		// Panel : Frame(Window) 위의 Frame
		//			종이 위의 종이
		
		/*
		Label label = new Label("label");
		add(label);
		*/
		//myPanel 추가
		MyPanel mypanel = new MyPanel();
		add(mypanel);
		
		
		// Panel
		Panel panel = new Panel();
		panel.setBackground(Color.blue);
		panel.setLayout(new GridLayout(1,2)); //
		add(panel);
		
		Label label1 = new Label("labeL 1");
		panel.add(label1);
		
		Button button = new Button("Button");
		panel.add(button);
		
		//레이블을 안쓰면 화면이 안보이는 부분도 발생
		
		setBounds(0,0,800,600);
		setVisible(true);
		addWindowListener(this);
	}
	
	
	@Override
	public void windowActivated(WindowEvent arg0) {
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