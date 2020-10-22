package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class contentView extends JFrame implements ActionListener {

	JButton menuBtn, srchBtn;
	JTextField serch;
	JTextArea result;
	
	public contentView() {
		super("항목별 조회");
		setLayout(null);
		//
		JLabel srch = new JLabel();
		srch.setText("내역 입력");
		srch.setBounds(10, 10, 60, 30);
		add(srch);
		
		serch = new JTextField();
		serch.setBounds(70, 10, 140, 30);
		add(serch);
		
		srchBtn = new JButton();
		srchBtn.setText("검색");
		srchBtn.setBounds(215, 10, 60, 30);
		srchBtn.addActionListener(this);
		add(srchBtn);
		//-내용 출력되는 곳
		JPanel panel = new JPanel();
		
		result = new JTextArea();	//ex)자기소개서 쓸때 쓸 수 있는 칸
		result.setLineWrap(true);	//테두리선 설정
		
		JScrollPane scrPane = new JScrollPane(result);	//scrollbar
		scrPane.setPreferredSize(new Dimension(560, 300));	//사이즈
		scrPane.setBounds(5, 45, 565, 300);
		add(scrPane);
		//-
		menuBtn = new JButton();
		menuBtn.setText("메뉴로 돌아가기");
		menuBtn.setBounds(380, 400, 180, 30);
		menuBtn.addActionListener(this);
		add(menuBtn);
		//
		setBounds(100, 100, 600, 480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == menuBtn){
			new menuView();
			this.dispose();
			//(4)필드 값을 받아서 select 조건 content
		}
	}

}

//항목 검색 검색어는 컨텐츠로 ...
