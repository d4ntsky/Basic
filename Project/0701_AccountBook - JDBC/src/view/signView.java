package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.MemberDao;
import dto.MemberDto;


public class signView extends JFrame implements ActionListener {
	
	JLabel label[] = new JLabel[4];
	JTextField textField[] = new JTextField[4];
	JButton idckBtn, gaipBtn, Btn1st;
	JLabel signScr;
	
	public signView() {
		super("회원가입");
		setLayout(null);
		
		//
		signScr = new JLabel();
		signScr.setText("회원 가입 화면");
		signScr.setFont(new Font("돋움", Font.BOLD, 12));
		signScr.setBounds(110, 5, 100, 30);
		add(signScr);
		
		String title[] = { "ID:", "PW:", "이름:", "E-mail:"};
		
		for (int i = 0; i < title.length; i++) {
			label[i] = new JLabel();
			label[i].setText( title[i] );
			label[i].setFont(new Font("돋움", Font.BOLD, 10));
			label[i].setBounds(30, 70 + 40 * i, 100, 30);
			
			textField[i] = new JTextField();
			textField[i].setBounds(100, 70 + 40 * i, 130, 30);
			
			add(label[i]);
			add(textField[i]);
		}
		idckBtn = new JButton("Check");
		idckBtn.setBounds(250, 70, 60, 30);
		idckBtn.setFont(new Font("바탕", Font.BOLD, 8));
		idckBtn.addActionListener(this);
		add(idckBtn);
		
		gaipBtn = new JButton("가입하기");
		gaipBtn.setBounds(90, 250, 150, 40);
		gaipBtn.setFont(new Font("바탕", Font.BOLD, 14));
		gaipBtn.addActionListener(this);
		add(gaipBtn);
		
		Btn1st = new JButton("로그인 화면으로");
		Btn1st.setBounds(180, 330, 140, 30);
		Btn1st.setFont(new Font("바탕", Font.BOLD, 10));
		Btn1st.addActionListener(this);
		add(Btn1st);
		
		//
		
		setBounds(100, 100, 340, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	//	JOptionPane.showMessageDialog(null, "버튼 클릭");
		
		JButton btn = (JButton)e.getSource();
		String btnTitle = btn.getLabel();
		
		if(btnTitle.equals("Check")) {
		//	JOptionPane.showMessageDialog(null, "Check 버튼 클릭");
			
			// id 확인
			//싱글턴을 통해 가져옴
			MemberDao dao = MemberDao.getInstance();
			
			String id = textField[0].getText().trim();	//DB 가져온거
			boolean b = dao.getId(id);
			
			if(b == true) {
				JOptionPane.showMessageDialog(null, "사용할 수 없는 ID입니다");
				textField[0].setText("");
			}else {
				JOptionPane.showMessageDialog(null, "이 ID는 사용할 수 있습니다");		
			}
				
		}
		else if(btnTitle.equals("가입하기")) {				//값 비교 가져온 값
			if(textField[0].getText().equals("") ||
			   textField[1].getText().equals("") ||
			   textField[2].getText().equals("") ||
			   textField[3].getText().equals("") ) {
				JOptionPane.showMessageDialog(null, "모두 기입해주세요");
				return;
			}
			//넣는 부분
			MemberDao dao = MemberDao.getInstance();
			
			boolean b = dao.addMember(new MemberDto(textField[0].getText(), textField[1].getText(), textField[2].getText(), textField[3].getText(), 0));
			
			if(b) {
				JOptionPane.showMessageDialog(null, "성공적으로 가입되었습니다");
				this.dispose();
				new loginView();
			}
			
		}else if(btnTitle.equals("로그인 화면으로")) {
				this.dispose();
				new loginView();
		}

	}
		
}
	

//-----------원래1 회원가입 버튼
	/*	JButton btn2 = (JButton)e.getSource();
		String btnTitle2 = btn2.getLabel();
		
		if(btnTitle2.equals("가입하기")) {
			//JOptionPane.showMessageDialog(null, "가입 버튼 클릭");
			
			// id 확인
			//싱글턴을 통해 가져옴
			MemberDao dao = MemberDao.getInstance();
			
			int count = dao.addMember(textField[0].getText().trim(), 
									  textField[1].getText().trim(),
									  textField[2].getText().trim(),
									  textField[3].getText().trim());
			
			if(count == 1) {
				System.out.println("데이터가 " + count + "개 추가 되었습니다");
			}else {
				System.out.println("다시 입력해주세요");*/