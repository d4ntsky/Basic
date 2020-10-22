package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class menuView extends JFrame implements ActionListener {
	
	JButton addBtn, periBtn, contBtn;
	public menuView() {
		super("메뉴");
		setLayout(null);
		
		//
		
		JLabel men = new JLabel();
		men.setText("메뉴");
		men.setFont(new Font("돋움", Font.BOLD, 18));
		men.setBounds(90, 10 , 100, 30);
		add(men);
		
	
		addBtn = new JButton("추가");
		addBtn.setBounds(80, 50, 110, 40);
		addBtn.setFont(new Font("바탕", Font.BOLD, 13));
		addBtn.addActionListener(this);
		add(addBtn);
		
		periBtn = new JButton("기간별 검색");
		periBtn.setBounds(80, 100, 110, 40);
		periBtn.setFont(new Font("바탕", Font.BOLD, 13));
		periBtn.addActionListener(this);
		add(periBtn);
		
		contBtn = new JButton("항목별 검색");
		contBtn.setBounds(80, 150, 110, 40);
		contBtn.setFont(new Font("바탕", Font.BOLD, 13));
		contBtn.addActionListener(this);
		add(contBtn);
		
		
		//
		setBounds(100, 100, 300, 280);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == addBtn) {	//회원가입
			new addView();
			this.dispose();
		}
		else if(obj == periBtn){
			//로그인과 패스워드를 입력한게 맞을 때
			new periodView();
			this.dispose();
		}
		else if(obj == contBtn){
			//로그인과 패스워드를 입력한게 맞을 때
			new contentView();
			this.dispose();
		}
	}

}
