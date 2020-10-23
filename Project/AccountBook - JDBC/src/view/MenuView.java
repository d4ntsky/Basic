package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.MemberDao;

public class MenuView extends JFrame implements ActionListener {
	
	JButton insertBtn, termBtn, searchBtn;

	public MenuView() {		
		String login_id = MemberDao.getInstance().getLoginID();
		setTitle(login_id);
		
		setLayout(null);
		
		JLabel menuLabel = new JLabel("메뉴");
		menuLabel.setBounds(160, 50, 120, 50);
		menuLabel.setFont(new Font(null, Font.BOLD, 32));	
		menuLabel.setForeground(Color.white);
		add(menuLabel);		
		
		insertBtn = new JButton("추가");
		insertBtn.setBounds(135, 170, 120, 50);
		insertBtn.addActionListener(this);
		add(insertBtn);
		
		termBtn = new JButton("기간별 내역");
		termBtn.setBounds(135, 250, 120, 50);
		termBtn.addActionListener(this);
		add(termBtn);
		
		searchBtn = new JButton("항목별 검색");
		searchBtn.setBounds(135, 330, 120, 50);
		searchBtn.addActionListener(this);
		add(searchBtn);
		
		
		getContentPane().setBackground(new Color(0, 0, 255));
		setBounds(100, 100, 400, 600);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton btn = (JButton)e.getSource();
		
		if(btn == insertBtn) {
		//	JOptionPane.showMessageDialog(null, "insertBtn");
			new InsertView();
			this.dispose();
		}
		else if(btn == termBtn) {
			new TermView();
			this.dispose();
		}
		else if(btn == searchBtn) {
			
		}
	}

}
