package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.BaseballDao;

public class MenuView extends JFrame implements ActionListener{

	JButton button[];
	
	public MenuView() {
		super("MenuView");
		
		setLayout(null);
		
		// 추가, 삭제, 검색, 수정, 모두출력
		
		JLabel label = new JLabel("메뉴");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("바탕", Font.BOLD, 48));
		label.setBounds(200, 30, 200, 50);
		add(label);
		
		String title[] = { "선수추가", "선수삭제", "선수검색", "선수수정", "모두출력", "저  장" };
		button = new JButton[title.length];
		
		//button 
		for (int i = 0; i < title.length; i++) {
			button[i] = new JButton();
			button[i].setLabel(title[i]);
			button[i].setBounds(180, 120 + 60 * i, 260, 50);
			button[i].addActionListener(this);
			add(button[i]);
		}
		
		
		setBounds(0, 0, 640, 580);
		setBackground(Color.gray);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == button[0]) {			// insert
			new InsertView();
			this.dispose();
		}else if(obj == button[1]) {	// delete
			
		}else if(obj == button[2]) {	// select
			
		}else if(obj == button[3]) {	// update
			
		}else if(obj == button[4]) {	// all print   
			
		}else if(obj == button[5]) {	// data save   
			BaseballDao dao = BaseballDao.getInstance();
			dao.dataSave();
			JOptionPane.showMessageDialog(null, "저장 돠었습니다.");
		}
		
		
	}
}