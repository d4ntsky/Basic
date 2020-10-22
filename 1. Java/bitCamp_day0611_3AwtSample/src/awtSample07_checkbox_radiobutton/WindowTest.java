package awtSample07_checkbox_radiobutton;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class WindowTest extends JFrame implements ItemListener{

	Checkbox cb1, cb2, cb3, cb4, cb5, cb6;
	Label label1, label2;
	
	JRadioButton radioBtn;	//찾아보면 열거하지 않고 쉽게 만드는 방법이 있다. 찾아보자.
	
	public WindowTest() {
		/*
			Check Box (취미)	- 다중선택 시
			Radio Button	- 하나선택 시
			
			AWT 	: radio button이 없어서 checkbox로 사용
			swing 	: JRadioButton <찾아보기!!!
		*/
		
		// cbg1 = cb1, cb2, cb3
		CheckboxGroup cbg1 = new CheckboxGroup();
		cb1 = new Checkbox("사과", cbg1, true);
		cb2 = new Checkbox("배", cbg1, false);
		cb3 = new Checkbox("바나나", cbg1, false);
		// cbg2 = cb4, cb5, cb6
		CheckboxGroup cbg2 = new CheckboxGroup();
		cb4 = new Checkbox("빨강", cbg2, false);
		cb5 = new Checkbox("파랑", cbg2, true);
		cb6 = new Checkbox("exit");				//이벤트 발생
		//한글 오류시 -Dfile.encoding=MS949
		//
		label1 = new Label("label1");
		label2 = new Label("label2");
		
		add(cb1);
		add(cb2);
		add(cb3);
		add(cb4);
		add(cb5);
		add(cb6);
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		cb4.addItemListener(this);
		cb5.addItemListener(this);
		cb6.addItemListener(this);
		
		add(label1);
		add(label2);
		
		setLayout(new FlowLayout());
		
		//기본
		setBounds(0, 0, 640, 480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		//JOptionPane.showMessageDialog(null, "클릭");	//확인
		
		Object obj = e.getSource();
		//Button btn = (Button)e.getSource();		//두가지 비교
		
		if(obj == cb6) {
			Checkbox cb = (Checkbox)obj;
			if(cb.getState()) {			//체크 됐음
				System.exit(0);
			}else {						//체크 안 됐음
				
			}
		}
		else if(obj == cb1 || obj == cb2 || obj == cb3) {
			Checkbox cb = (Checkbox)obj;
			if(cb.getState()) {
				label1.setText(cb.getLabel());
			}
		}
		else if(obj == cb4 || obj == cb5 ) {
			Checkbox cb = (Checkbox)obj;
			if(cb.getState()) {
				label2.setText(cb.getLabel());
			}
		}
	}
}