package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.AccountBookDao;
import dao.MemberDao;
import dto.AccountBookDto;

public class InsertView extends JFrame implements ActionListener {

	JComboBox<String> choice;
	
	JTextField amountTextF;
	JTextField contentTextF;
	
	JButton insertBtn;
	JButton backBtn;
	
	public InsertView() {
		super("추가하기");
		
		setLayout(null);
		
		JLabel loginLabel = new JLabel("추가 화면");
		loginLabel.setBounds(300, 10, 120, 15);
		add(loginLabel);
				
		String ctitle[] = {
				"수입",
				"지출"				
		};
		choice = new JComboBox<String>(ctitle);
		choice.setBounds(250, 80, 150, 30);
		choice.setBackground(Color.white);				
		add(choice);
		
		JLabel amountLabel = new JLabel("금액:");
		amountLabel.setBounds(100, 150, 100, 15);
		add(amountLabel);
		
		JLabel contentLabel = new JLabel("내용:");
		contentLabel.setBounds(100, 210, 100, 15);
		add(contentLabel);
		
		amountTextF = new JTextField();
		amountTextF.setBounds(150, 140, 350, 30);
		add(amountTextF);
		
		contentTextF = new JTextField();
		contentTextF.setBounds(150, 200, 350, 30);
		add(contentTextF);
				
		insertBtn = new JButton("추  가");
		insertBtn.addActionListener(this);
		insertBtn.setBounds(250, 260, 150, 50);
		add(insertBtn);	
		
		backBtn = new JButton("메  뉴");
		backBtn.addActionListener(this);
		backBtn.setBounds(480, 360, 120, 40);
		add(backBtn);			
		
		getContentPane().setBackground(new Color(0, 128, 0));
		setBounds(100, 100, 640, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();

		if(btn == insertBtn) {
		//	JOptionPane.showMessageDialog(null, "insertBtn");
			
			String id = MemberDao.getInstance().getLoginID();
			
			int index = choice.getSelectedIndex();
			String io_kind = "o";
			if(index == 0) 	io_kind = "i";
							
			int amount = Integer.parseInt(amountTextF.getText());
			String content = contentTextF.getText();
			
			AccountBookDao dao = AccountBookDao.getInstance();
			boolean b = dao.addAccount(new AccountBookDto(0, id, io_kind, amount, content, ""));
			if(b == true) {
				JOptionPane.showMessageDialog(null, "정상적으로 추가되었습니다");
				
				// 초기화
				choice.setSelectedIndex(0);				
				contentTextF.setText("");
				amountTextF.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "추가되지 않았습니다");
			}
			
		}
		else if(btn == backBtn) {
			new MenuView();
			this.dispose();			
		}
	}

}
