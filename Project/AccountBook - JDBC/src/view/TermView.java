package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import dao.AccountBookDao;
import dao.MemberDao;
import dto.AccountBookDto;

public class TermView extends JFrame implements ActionListener {

	JTextField syearTF, smonthTF, sdayTF;
	JTextField eyearTF, emonthTF, edayTF;
	
	JButton resultBtn;
	JButton backBtn;
	
	JTextArea textArea;
	
	public TermView() {
		super("기간으로 검색하기");
		
		setLayout(null);
		
		JLabel loginLabel = new JLabel("기간별 검색  화면");
		loginLabel.setBounds(260, 10, 120, 15);
		add(loginLabel);
		
		
		JLabel label = new JLabel("시작일:");
		label.setBounds(50, 70, 100, 15);
		add(label);
		
		syearTF = new JTextField();
		syearTF.setBounds(110, 63, 100, 30);
		add(syearTF);
		
		label = new JLabel("년");
		label.setBounds(220, 70, 20, 15);
		add(label);
		
		smonthTF = new JTextField();
		smonthTF.setBounds(250, 63, 100, 30);
		add(smonthTF);
		
		label = new JLabel("월");
		label.setBounds(360, 70, 20, 15);
		add(label);
		
		sdayTF = new JTextField();
		sdayTF.setBounds(390, 63, 100, 30);
		add(sdayTF);
		
		label = new JLabel("일");
		label.setBounds(500, 70, 20, 15);
		add(label);
		
		
		label = new JLabel("종료일:");
		label.setBounds(90, 110, 100, 15);
		add(label);
		
		eyearTF = new JTextField();
		eyearTF.setBounds(150, 103, 100, 30);
		add(eyearTF);
		
		label = new JLabel("년");
		label.setBounds(260, 110, 20, 15);
		add(label);
		
		emonthTF = new JTextField();
		emonthTF.setBounds(290, 103, 100, 30);
		add(emonthTF);
		
		label = new JLabel("월");
		label.setBounds(400, 110, 20, 15);
		add(label);
		
		edayTF = new JTextField();
		edayTF.setBounds(430, 103, 100, 30);
		add(edayTF);
		
		label = new JLabel("일");
		label.setBounds(540, 110, 20, 15);
		add(label);
		
		resultBtn = new JButton("결과 보기");
		resultBtn.addActionListener(this);
		resultBtn.setBounds(150, 150, 350, 40);
		add(resultBtn);	
		
		textArea = new JTextArea(7, 20); 
		textArea.setBounds(80, 200, 470, 150);
		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		textArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		add(textArea);
		
		backBtn = new JButton("메  뉴");
		backBtn.addActionListener(this);
		backBtn.setBounds(480, 360, 120, 40);
		add(backBtn);
		
		getContentPane().setBackground(new Color(0, 222, 0));
		setBounds(100, 100, 640, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();

		if(btn == resultBtn) {
		//	JOptionPane.showMessageDialog(null, "resultBtn");
			String syear = syearTF.getText().substring(2);	// 2020 -> 20만을 취득
			String smonth = two( smonthTF.getText() );		// two는 밑에 정의되어 있음	
			String sday = two( sdayTF.getText() );
			
			String sdate = syear + smonth + sday;
			
			String eyear = eyearTF.getText().substring(2);
			String emonth = two( emonthTF.getText() );
			String eday = two( edayTF.getText() );
			
			String edate = eyear + emonth + eday;
			
			// login id 취득
			String id = MemberDao.getInstance().getLoginID();
		
			// 확인용
			String str = sdate + " " + edate + " " + id;			
			JOptionPane.showMessageDialog(null, str);
			
			// DB 접근
			AccountBookDao dao = AccountBookDao.getInstance();
			
			List<AccountBookDto> list = dao.getABookList(id, sdate, edate);
			
			for (AccountBookDto a : list) {		
				
				String io;
				if(a.getIo_kind().equals("i"))  io = "수입";
				else							io = "지출";
				
				// textArea에 출력
				textArea.append("[" + a.getWdate() + "]" +
								a.getContent() + ", " +
								"금액:" + a.getAmount() + "원 " +
								io + "\n");
			}
			
		}
		else if(btn == backBtn) {
			new MenuView();
			this.dispose();			
		}
		
	}
	
	public String two(String str) {		// 1 ~ 9 -> 01 ~ 09
		return str.length()==2?str:"0" + str;
	}

}





