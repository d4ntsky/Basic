package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.BaseballDao;
import dto.Human;
import dto.Pitcher;
import view.InsertView;
import view.MenuView;

public class PitcherPanel extends JPanel implements ActionListener{

	JLabel label[] = new JLabel[6];
	JTextField textField[] = new JTextField[6];
	
	JButton menuBtn, insertBtn;
	
	InsertView insertview;
	
	public PitcherPanel(InsertView insertview) {
		setLayout(null);
		
		this.insertview = insertview;
		
		String title[] = { "이름:", "나이:", "신장:", "승:", "패:", "방어율" };
		
		for (int i = 0; i < title.length; i++) {
			label[i] = new JLabel();
			label[i].setText( title[i] );
			label[i].setFont(new Font("돋움", Font.BOLD, 18));
			label[i].setBounds(30, 50 + 40 * i, 100, 30);
			
			textField[i] = new JTextField();
			textField[i].setBounds(180, 50 + 40 * i, 200, 30);
			
			add(label[i]);
			add(textField[i]);
		}
		
		menuBtn = new JButton("메뉴");
		menuBtn.setBounds(150, 320, 150, 50);
		menuBtn.addActionListener(this);
		add(menuBtn);
		
		insertBtn = new JButton("추가");
		insertBtn.setBounds(320, 320, 150, 50);
		insertBtn.addActionListener(this);
		add(insertBtn);
				
		setBounds(0, 0, 640, 450);
		setBackground(new Color(200, 128, 0));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == menuBtn) {
		//	JOptionPane.showMessageDialog(null, "menuBtn");
			insertview.dispose();
			new MenuView();
		}
		else if(obj == insertBtn) {
			
			BaseballDao ball = BaseballDao.getInstance();	
			Human human = null;
			
			for (int i = 0; i < textField.length; i++) {
				if(textField[i].getText().equals("")) {
					JOptionPane.showMessageDialog(null, "모두 작성해 주십시오");
					return;
				}
			}			
			
			String name = textField[0].getText();
			int age = Integer.parseInt(textField[1].getText());
			double height = Double.parseDouble(textField[2].getText());
			int win = Integer.parseInt(textField[3].getText());
			int lose = Integer.parseInt(textField[4].getText());
			double defence = Double.parseDouble(textField[5].getText());
			
			human = new Pitcher(0, name, age, height, win, lose, defence)	;		
			
			boolean b = ball.insert(human);
			if(b) {
				JOptionPane.showMessageDialog(null, "성공적으로 추가하였습니다");
				
				for (int i = 0; i < textField.length; i++) {
					textField[i].setText("");
				}
			}else {
				JOptionPane.showMessageDialog(null, "추가되지 않았습니다");
			}			
			
		}
	}
}