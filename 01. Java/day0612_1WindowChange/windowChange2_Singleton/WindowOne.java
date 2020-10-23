package windowChange2_Singleton;

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
				//System.exit(0);
				
				
				SingletonClass sc = SingletonClass.getInstance();
				sc.one.setVisible(false);
				sc.two.setVisible(true);

					
				
			}
		});
		add(btn);
		
		
		
		
		//----------------------------------
		setBounds(0, 0, 640, 480);
		setVisible(false);								//꺼둠
		setBackground(Color.red);			
	}
	
}