package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.MemberDao;
import db.DBClose;
import db.DBConnection;
import dto.MemberDto;


public class loginView extends JFrame implements ActionListener {
	
	//버튼(loginBtn, signinBtn) 2개 멤버로,텍스트 필드 4개
	
	JLabel ttlb, idlb, pwlb;
	JTextField idtf, pwtf;
	JButton loginBtn, signBtn;
	
	
	public loginView() {
		super("로그인");
		
		setLayout(null);
		
		//만들 부분
		ttlb = new JLabel();
		ttlb.setText("로그인 화면");
		ttlb.setFont(new Font("돋움", Font.BOLD, 12));
		ttlb.setBounds(120, 5, 90, 50);
		add(ttlb);
		
		idlb = new JLabel();
		idlb.setText("ID :");
		idlb.setFont(new Font("돋움", Font.BOLD, 18));
		idlb.setBounds(10, 50, 50, 50);
		add(idlb);
		
		pwlb = new JLabel();
		pwlb.setText("PW :");
		pwlb.setFont(new Font("돋움", Font.BOLD, 18));
		pwlb.setBounds(10, 90, 50, 50);
		add(pwlb);
		
		idtf = new JTextField();
		idtf.setBounds(70, 60, 200, 30);
		add(idtf);
		
		pwtf = new JTextField();
		pwtf.setBounds(70, 100, 200, 30);
		add(pwtf);
		
		loginBtn = new JButton("로그인");
		loginBtn.setBounds(40, 160, 100, 40);
		loginBtn.setFont(new Font("바탕", Font.BOLD, 12));
		loginBtn.addActionListener(this);
		add(loginBtn);
		
		signBtn = new JButton("회원 가입");
		signBtn.setBounds(160, 160, 100, 40);
		signBtn.setFont(new Font("바탕", Font.BOLD, 13));
		signBtn.addActionListener(this);
		add(signBtn);
		
		

		
		//
		
		setBounds(100, 100, 300, 280);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		MemberDao dao = MemberDao.getInstance();
		
		if(obj == signBtn) {	//회원가입
			new signView();
			this.dispose();
		}
		else if(obj == loginBtn){
		//(1) 시작
		MemberDto mem = dao.login(idtf.getText(), pwtf.getText());
		String id = idtf.getText().trim();
		String pw = pwtf.getText().trim();
		boolean b = dao.checkidpw(id, pw);
		
		
		if(b == false) {
			JOptionPane.showMessageDialog(null, "다시 시도 해주세요");
			idtf.setText("");
			pwtf.setText("");
		}else {
			JOptionPane.showMessageDialog(null, "로그인 되었습니다");
			
			this.dispose();
			new menuView();
		}
		//(1)끝
		
		}

	}

}

//제출과제 아님
/* 
-----------------------------
로그인
id __textfield__
pw __textfield__
  
 |login||회원가입| <둘다 버튼 클릭하면 이동
-----------------------------회원가입을 누르는 경우

		회원가입
id		 __textfield__	(id확인)<버튼
pw		 __textfield__
name	 __textfield__
email	 __textfield__
	 |회원가입|<버튼(등록됨)
	 
-----------------------------login하면 뜰 화면

		메뉴
 	 	추가		<버튼
 	   기간별 내역	<버튼
 	   항목별 검색	<버튼
 	 	
-----------------------------추가를 누르면
수입지출선택

 __textfield__금액
 __textfield__내용
 		
 		추가 			<버튼
 		메뉴로 돌아가기	<버튼

 
-----------------------------기간별 내역
 
연도 월 일 ~		
	연도 월 일 
				결과보기(버튼 select로 검색?)
		text 에일리어
		결과출력
		
		메뉴로 돌아가기
-----------------------------항목별 검색
 검색어(content)	결과보기
 
 결과출력 text아레아?
 
 메뉴로 돌아가기
*/
