package awtSample01_window;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener{
						//상속받은 부분 확인
	public WindowTest() {
		
		setSize(640,480);	// 윈도우 폭, 높이		Win32 API
		setLocation(0, 0);	// 윈도우 실행 위치
		setVisible(true);	// 윈도우 시각화
		//---------------------------------기본
		
		// Listener 
		addWindowListener(this);//현재클래스에 리스너를 장착
		
		//C# -> web(ASP.net)
		//많이 쓰는 PHP > JSP > ASP
		//PHP 확장성 0
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowActivated");
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowClosed");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowClosing");
		System.exit(0);//끄는 동작 실행 코드
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeactivated");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeiconified");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowIconified");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowOpened");
	}
	
	
	
}