package windowChange1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowOne extends Frame {
	
	public WindowOne() {
		
		setLayout(null);
		
		Button btn = new Button("move window");
		btn.setBounds(100, 100, 100, 30);	//윈도우 바뀌는 버튼
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				//부분 멈춤일때는 쓰면 안됨
				//System.exit(0);
				dispose();				//자신만 닫히고 
				
				
				
				new WindowTwo();
					
				
			}
		});
		add(btn);
		
		
		
		
		//----------------------------------
		setBounds(0, 0, 640, 480);
		setVisible(true);
		setBackground(Color.red);			//처음 빨간색으로 설정
	}
	
}

