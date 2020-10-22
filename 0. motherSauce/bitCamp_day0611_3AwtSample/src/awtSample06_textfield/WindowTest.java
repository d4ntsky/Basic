package awtSample06_textfield;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

public class WindowTest extends JFrame /*implements ActionListener*/ {
	
	JTextField textField;	
	JTextArea textArea;
	
	JButton btn1, btn2;
	
	public WindowTest() {
		super("textfield");
		
		//패널1 패널: 페이지 위의 페이지
		JPanel panel = new JPanel();
		
		textArea = new JTextArea();	//ex)자기소개서 쓸때 쓸 수 있는 칸
		textArea.setLineWrap(true);	//테두리선 설정
		
		JScrollPane scrPane = new JScrollPane(textArea);	//scrollbar
		scrPane.setPreferredSize(new Dimension(400, 300));	//사이즈
		panel.add(scrPane);
		
		//패널2
		JPanel botpan = new JPanel();
		
		textField = new JTextField(20);	//20칸 정도 준비 
		
		btn1 = new JButton("next insert");	//글 내용 뒤에 추가
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!textField.getText().equals("")) {//빈문자 안보내짐
					String msg = textField.getText() + "\n";
					textArea.append(msg);
					
					textField.setText("");						//내보내고 창 비워주는 
				}
			}

		});
		
		/*
		actionlistener 인터페이스 추가를 안했을시
		btn1.addActionListener(new ActionListner());
		위에 걸 치면 추상 메소드로 밑에 부분이 자동으로 뜬다.
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
		*/
		
		btn2 = new JButton("prev insert");	//글 내용 앞에 추가
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.insert(textField.getText() + "\n", textArea.getLineStartOffset(0));//뒷부분
				} catch (BadLocationException e1) {

					e1.printStackTrace();
				}
				textField.setText("");
			}
		});
		
		botpan.add(textField);
		botpan.add(btn1);
		botpan.add(btn2);
		
		Container contentPane = getContentPane();
		
		contentPane.add(panel, BorderLayout.CENTER);	//중앙배치
		contentPane.add(botpan, BorderLayout.SOUTH);	//밑에쪽
		
		//기본
		setBounds(0, 0, 640, 480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Jframe용 닫기?
	}
}
