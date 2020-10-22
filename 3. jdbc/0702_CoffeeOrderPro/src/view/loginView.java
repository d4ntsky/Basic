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

import dao.CustomerDao;
import db.DBClose;
import db.DBConnection;
import dto.CustomerDto;

public class loginView extends JFrame implements ActionListener {

	// 버튼(loginBtn, signinBtn) 2개 멤버로,텍스트 필드 4개

	JLabel ttlb, idlb, pwlb;
	JTextField idtf, pwtf;
	JButton loginBtn, signBtn;

	public loginView() {
		super("로그인");

		setLayout(null);

		// 만들 부분
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
		CustomerDao cudao = CustomerDao.getInstance();

		if (obj == signBtn) { // 회원가입
			// CustomerDao cus = cudao.//
			new signView();
			this.dispose();
		} else if (obj == loginBtn) {
			CustomerDto cus = cudao.login(idtf.getText(), pwtf.getText());
			if (cus == null) {
				JOptionPane.showMessageDialog(null, "id나 password가 틀렸습니다");
			} else {
				JOptionPane.showMessageDialog(null, cus.getId() + "님 환영합니다");
				// 이쪽께 아이디 받는법
				this.dispose();
				cudao.setLoginId(cus.getId());
				new menuView();
			}
		}

	}

}