package awtSample02_label;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class WindowTest extends Frame implements WindowListener {
								//class 만들때 superclass에는 frame interface에는 windowListener를 하면 한 번에 됨
	public WindowTest() {
		
		super("Lable"); //==setTitle()
//		setSize(640, 480);
//		setLocation(0, 0);	
		//==
		setBounds(0, 0, 640, 480);
		
		setVisible(true);
		
		addWindowListener(this);
		//기본
		
		Label label = new Label();
		label.setText("Label");
		add(label);
		
		Label label1 = new Label("Label 입니다");	//한글깨짐
		add(label1);
		//프로퍼티스>디버그세팅>mainClass>edit>argument -Dfile.encoding=MS949붙이는거 확인
		
		//lable과 lable1이 둘 다 보여야하지만 label1만 뜨는 이유?		
		
		System.out.println("WindowTest WindowTest()");
		
		//MeesageBox
		JOptionPane.showMessageDialog(null, "WindowTest() 실행"); 
		
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
			System.exit(0);								//종료
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
