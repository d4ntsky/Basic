package view;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.CafeDao;
import dao.CustomerDao;
import dto.CafeDto;

public class menuView extends JFrame implements ActionListener {

	JButton chartBtn, ordaBtn, Btn1st;
	String coffee[] = { "커피 목록", "헤이즐넛 카라멜 모카", "카라멜 마끼아또", "화이트 초콜릿 모카", "카라멜 모카", "카페 모카", "카라멜 라떼", "카페 라떼", "카푸치노",
			"아메리카노", "오늘의 커피" };
	JComboBox<String> cho;
	JTextField manyCup;

	JPanel cPan, sPan, oPan;
	Checkbox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cbn;
	Label label1, label2, label3;
	CheckboxGroup cbg1, cbg2;

	int cofprice[] = { 0, 4800, 4300, 4300, 4300, 3800, 3800, 3300, 3300, 2800, 2500 };

	public menuView() {
		super("메뉴");
		setLayout(null);

		//

		JLabel menu = new JLabel();
		menu.setText("Coffee Cafe");
		menu.setFont(new Font("돋움", Font.BOLD, 30));
		menu.setBounds(10, 10, 200, 30);
		add(menu);

		JLabel jan = new JLabel();
		jan.setText("잔");
		jan.setFont(new Font("돋움", Font.BOLD, 30));
		jan.setBounds(200, 400, 200, 30);
		add(jan);

		chartBtn = new JButton("가격표 보기");
		chartBtn.setBounds(430, 10, 110, 40);
		chartBtn.setFont(new Font("바탕", Font.BOLD, 13));
		chartBtn.addActionListener(this);
		add(chartBtn);

		ordaBtn = new JButton("주문");
		ordaBtn.setBounds(300, 350, 110, 30);
		ordaBtn.setFont(new Font("바탕", Font.BOLD, 13));
		ordaBtn.addActionListener(this);
		add(ordaBtn);

		Btn1st = new JButton("로그인 화면으로");
		Btn1st.setBounds(430, 420, 140, 30);
		Btn1st.setFont(new Font("바탕", Font.BOLD, 10));
		Btn1st.addActionListener(this);
		add(Btn1st);

		// 커피 선택바
		cho = new JComboBox<String>(coffee);
		cho.setBounds(10, 80, 300, 50);
		cho.setFont(new Font("바탕", Font.BOLD, 18));
		add(cho);
		cho.addActionListener(this);

		// panel
		// --------------------------------------------
		cPan = new JPanel();
		cPan.setBounds(15, 140, 150, 180);
		cPan.setBackground(Color.white);
		add(cPan);
		// 라됴버튼
		cbg1 = new CheckboxGroup();
		cb1 = new Checkbox(" Short",  cbg1, true);
		cb2 = new Checkbox(" Tall",   cbg1, false);
		cb3 = new Checkbox(" Grande", cbg1, false);
		// 이벤트 발생
		// 한글 오류시 -Dfile.encoding=MS949
		//
		label1 = new Label(" Size");
		cPan.add(label1);
		cPan.add(cb1);
		cPan.add(cb2);
		cPan.add(cb3);
		/*
		 * cb1.addItemListener(this); cb2.addItemListener(this);
		 * cb3.addItemListener(this);
		 */
		cPan.setLayout(new GridLayout(4, 1));

		// --------------------------------------------

		sPan = new JPanel();
		sPan.setBounds(175, 140, 150, 180);
		sPan.setBackground(Color.white);
		add(sPan);
		label2 = new Label("Syrup");
		cbg2 = new CheckboxGroup();
		cb4 = new Checkbox("Vanilla", cbg2, false);
		cb5 = new Checkbox("Caramel", cbg2, false);
		cb6 = new Checkbox("Hazelnut", cbg2, false);
		cbn = new Checkbox("no", cbg2, true);

		// --------------------------------------------
		
		sPan.add(label2);
		sPan.add(cb4);
		sPan.add(cb5);
		sPan.add(cb6);
		sPan.add(cbn);
		sPan.setLayout(new GridLayout(5, 1));

		// --------------------------------------------

		oPan = new JPanel();
		oPan.setBounds(335, 140, 150, 180);
		oPan.setBackground(Color.white);
		add(oPan);
		cb7 = new Checkbox(" extra Shot", false);
		cb8 = new Checkbox(" whip Cream", false);
		label3 = new Label(" Others");
		oPan.add(label3);
		oPan.add(cb7);
		oPan.add(cb8);
		oPan.setLayout(new GridLayout(4, 1));

		// --------------------------------------------

		manyCup = new JTextField();
		manyCup.setBounds(10, 400, 150, 20);
		add(manyCup);

		// --------------------------------------------
		
		setBounds(100, 100, 600, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ----

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();

		if (obj == chartBtn) {
			new chartView();
		} else if (obj == ordaBtn) {

			String id = CustomerDao.getInstance().getLoginID();

			int index = cho.getSelectedIndex();
			String coffee_kind = "";
			int cup = 0;
			int price = 0;

			switch (index) {
			case 0:
				JOptionPane.showMessageDialog(null, "커피 종류를 선택해주세요");
				break;
			case 1:
				coffee_kind = "헤이즐넛 카라멜 모카";
				price = cofprice[1];
				break;
			case 2:
				coffee_kind = "카라멜 마끼아또 ";
				price = cofprice[2];
				break;
			case 3:
				coffee_kind = "화이트 초코 모카";
				price = cofprice[3];
				break;
			case 4:
				coffee_kind = "카라멜 모카" + '\t';
				price = cofprice[4];
				break;
			case 5:
				coffee_kind = "카페 모카" + '\t';
				price = cofprice[5];
				break;
			case 6:
				coffee_kind = "카라멜 라떼" + '\t';
				price = cofprice[6];
				break;
			case 7:
				coffee_kind = "카페 라떼" + '\t';
				price = cofprice[7];
				break;
			case 8:
				coffee_kind = "카푸치노" + '\t';
				price = cofprice[8];
				break;
			case 9:
				coffee_kind = "아메리카노" + '\t';
				price = cofprice[9];
				break;
			case 10:
				coffee_kind = "오늘의 커피" + '\t';
				price = cofprice[10];
				break;
			}

			String cho_size = "Short";
			cho_size = cbg1.getSelectedCheckbox().getLabel();

			if (cho_size.equals(" Tall")) {
				price = price + 500;
			} else if (cho_size.equals(" Grande")) {
				price = price + 1000;
			}

			String ad_syrp = cbg2.getSelectedCheckbox().getLabel();
			if (ad_syrp == null) {
				ad_syrp = "무";
			}

			String ad_shot = "x";
			if (cb7.getState() == true) {
				ad_shot = "o";
			} else if (cb7.getState() == false) {
				ad_shot = "x";
			}
			;

			String ad_whip = "x";
			if (cb8.getState() == true) {
				ad_whip = "o";
			} else if (cb8.getState() == false) {
				ad_whip = "x";
			}
			;

			// exception?
			cup = Integer.parseInt(manyCup.getText());

			CafeDao cadao = CafeDao.getInstance();
			// 확인 비교 해야되는 곳

			boolean b = cadao.addOrder(new CafeDto(id, coffee_kind, cho_size, ad_syrp, ad_shot, ad_whip, cup, price));
			if (b == true) {

				new odListView();
				this.dispose();

				// 초기화 위 초기화 겹치나?
				cho.setSelectedIndex(0);
				manyCup.setText("");

			} else {
				JOptionPane.showMessageDialog(null, "추가되지 않았습니다");
			}
		} else if (obj == Btn1st) {
			new loginView();
			this.dispose();
		}

	}
}
