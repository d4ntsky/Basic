package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class periodView extends JFrame implements ActionListener {
	
	JButton menuBtn, srchBtn;
	JTextArea result;
	
	//array로 묶을 것	
	String yer1[] = {};
	String mon1[] = {"1","2","3","4"};
	String day1[] = {"19","20","21"};
	String yer2[] = {"2001","2002","2003"};
	String mon2[] = {"1","2","3","4"};
	String day2[] = {"19","20","21"};
	JComboBox<String> scdate1, scdate2, scdate3, scdate4, scdate5, scdate6;
	JLabel label1, label2, label3, label4, label5, label6;
	
	public periodView() {
		super("기간별 조회");
		setLayout(null);
		//
		//콤보박스																				//array로 묶을 것	
		//-----------------------------
		//array로 묶을 것	
		scdate1 = new JComboBox<String>(yer1);
		scdate1.setBounds(10,10,70,30);
		add(scdate1);
		scdate1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				label1.setText((String)scdate1.getSelectedItem());
			}
		});
		label1 = new JLabel("year1");
		
		
		//-----------------------------
		scdate2 = new JComboBox<String>(mon1);
		scdate2.setBounds(90,10,70,30);
		add(scdate2);
		scdate1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				label2.setText((String)scdate2.getSelectedItem());
			}
		});
		label2 = new JLabel("month1");
		
		
		//-----------------------------
		scdate3 = new JComboBox<String>(day1);
		scdate3.setBounds(170,10,70,30);
		add(scdate3);
		scdate1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				label3.setText((String)scdate3.getSelectedItem());
			}
		});
		label3 = new JLabel("day1");
		
		
		//-----------------------------
		scdate4 = new JComboBox<String>(yer2);
		scdate4.setBounds(10,40,70,30);
		add(scdate4);
		scdate4.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				label4.setText((String)scdate4.getSelectedItem());
			}
		});
		label4 = new JLabel("year2");
		
		
		//-----------------------------
		scdate5 = new JComboBox<String>(mon2);
		scdate5.setBounds(90,40,70,30);
		add(scdate5);
		scdate1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				label5.setText((String)scdate5.getSelectedItem());
			}
		});
		label5 = new JLabel("month2");
		
		//-----------------------------
		scdate6 = new JComboBox<String>(day2);
		scdate6.setBounds(170,40,70,30);
		add(scdate6);
		scdate1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				label6.setText((String)scdate6.getSelectedItem());
			}
		});
		label6 = new JLabel("day1");
		
		/*
		(3)
		
		
		 */
		
		
		
		//--
		JPanel panel = new JPanel();
		
		result = new JTextArea();	//ex)자기소개서 쓸때 쓸 수 있는 칸
		result.setLineWrap(true);	//테두리선 설정
		
		JScrollPane scrPane = new JScrollPane(result);	//scrollbar
		scrPane.setPreferredSize(new Dimension(560, 300));	//사이즈
		scrPane.setBounds(5, 70, 565, 300);
		add(scrPane);
		//--
		
		
		srchBtn = new JButton();
		srchBtn.setText("검색");
		srchBtn.setBounds(510, 10, 60, 30);
		srchBtn.addActionListener(this);
		add(srchBtn);
		
		menuBtn = new JButton();
		menuBtn.setText("메뉴로 돌아가기");
		menuBtn.setBounds(380, 400, 180, 30);
		menuBtn.addActionListener(this);
		add(menuBtn);
		//					300 280
		setBounds(100, 100, 600, 480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == menuBtn){
			new menuView();
			this.dispose();
		}
	}

}
