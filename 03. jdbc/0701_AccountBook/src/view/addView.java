package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.AccountBookDao;
import dao.MemberDao;
import dto.AccountBookDto;

public class addView extends JFrame implements ActionListener {
	
	JLabel label;
	JComboBox<String> cho;
	JTextField amou, cont;
	JButton addBtn, menuBtn;
	
	public addView() {
		super("추가");
		setLayout(null);
		//
		String selec[] = 
			{"수입", "지출"};
		cho = new JComboBox<String>(selec);
		cho.setBounds(10,10,70,30);
		add(cho);
		cho.addActionListener(this);
		
	
		
		JLabel amo = new JLabel();
		amo.setText("금액");
		amo.setBounds(10, 60, 50, 30);
		add(amo);
		
		amou = new JTextField();
		amou.setBounds(70, 60, 200, 30);
		add(amou);
		
		JLabel con = new JLabel();
		con.setText("내용");
		con.setBounds(10, 100, 50, 30);
		add(con);
		
		cont = new JTextField();
		cont.setBounds(70, 100, 200, 30);
		add(cont);
		
		addBtn = new JButton();
		addBtn.setText("추가");
		addBtn.setBounds(130, 150, 60, 30);
		addBtn.addActionListener(this);
		add(addBtn);
		
		menuBtn = new JButton();
		menuBtn.setText("메뉴로 돌아가기");
		menuBtn.setBounds(100, 210, 180, 30);
		menuBtn.addActionListener(this);
		add(menuBtn);
		
		//
		setBounds(100, 100, 300, 280);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼
				Object obj = e.getSource();
		
		String id = MemberDao.getInstance().getLoginID();
		
		int index = cho.getSelectedIndex();
		String io_kind = "o";
		if(index == 0) 	io_kind = "i";
		
		int amount = Integer.parseInt(amou.getText());
		String content = cont.getText();
		
		AccountBookDao dao = AccountBookDao.getInstance();
		boolean b = dao.addAccount(new AccountBookDto(0, id, io_kind, amount, content, ""));
			if(b == true) {
				JOptionPane.showMessageDialog(null, "정상적으로 추가되었습니다");
				
				//초기화?
				cho.setSelectedIndex(0);
				cont.setText("");
				amou.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "추가되지 않았습니다");	
			}
		if(obj == addBtn) {	
			//기입 똑바로
			if(amou.getText().equals("") ||
			   cont.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "빈 칸 없이 기입 해주세요");
				return;
			}
/*
			//(2)
			//아이템리스너로 값을 받은거랑 금액,내용 
			아이템리스너로 받은값 넣기
			cho.getSelectedItem()
			cho.getSelectedItem().toString()
			//INSERT INTO로
		AccountBookDao bdao = AccountBookDao.getInstance();
		
			boolean b = bdao.addAccountBook
					(new AccountBookDto(label.get(),amou.getText(),cont.getText()));
*/
			
			JOptionPane.showMessageDialog(null, "추가되었습니다");
			new menuView();
			this.dispose();
		}
		else if(obj == menuBtn){
			new menuView();
			this.dispose();
		}
	}

}

/*
CREATE TABLE ACCOUNTBOOK(
	SEQ NUMBER(8),
	ID VARCHAR2(30),				-- 외래키
	IO_KIND VARCHAR2(1),			-- 수입/지출(IN/OUT)
	AMOUNT NUMBER(9),				-- 금액
	CONTENT VARCHAR2(200),			-- 사용내역
	WDATE DATE,						-- 입력일 - 적은 날짜가 SYSDATE
	CONSTRAINT FK_ID FOREIGN KEY(ID)
	REFERENCES MEMBER(ID)
);
 */
