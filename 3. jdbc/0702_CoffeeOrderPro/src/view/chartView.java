package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class chartView extends JFrame implements ActionListener {

	JButton close;
	JLabel coffee[] = new JLabel[11];
	JLabel shot[] = new JLabel[11];
	JLabel tall[] = new JLabel[11];
	JLabel grde[] = new JLabel[11];
	JLabel pric;

	public chartView() {
		super("가격표");
		setLayout(null);
		//
		pric = new JLabel();
		pric.setText("가격표");
		pric.setFont(new Font("돋움", Font.BOLD, 20));
		pric.setBounds(30, 10, 110, 40);
		add(pric);

		// 차트 끄는 버튼
		close = new JButton();
		close.setText("끄기");
		close.setBounds(250, 15, 100, 30);
		close.setFont(new Font("바탕", Font.BOLD, 13));
		close.addActionListener(this);
		add(close);
		// 메뉴 select로 뜨게 ?

		// 메뉴 UI로 구성
		String stCof[] = { "커피 목록", "헤이즐넛 카라멜 모카", "카라멜 마끼아또", "화이트 초콜릿 모카", "카라멜 모카", "카페 모카", "카라멜 라떼", "카페 라떼",
				"카푸치노", "아메리카노", "오늘의 커피" };

		// 배열로 가능한가???????????????????????????????????
		String sPrice[] = { "Short", "4800", "4300", "4300", "4300", "3800", "3800", "3300", "3300", "2800", "2500" };
		String tPrice[] = { "Tall", "5300", "4800", "4800", "4800", "4300", "4300", "3800", "3800", "3300", "3000" };
		String gPrice[] = { "Grande", "5800", "5300", "5300", "5300", "4800", "4800", "4300", "4300", "3800", "3500" };

		for (int i = 0; i < stCof.length; i++) {
			coffee[i] = new JLabel();
			coffee[i].setText(stCof[i]);
			coffee[i].setBounds(30, 70 + 40 * i, 200, 30);
			add(coffee[i]);
		}
		for (int i = 0; i < stCof.length; i++) {
			shot[i] = new JLabel();
			shot[i].setBounds(200, 70 + 40 * i, 50, 30);
			shot[i].setText(sPrice[i]);
			add(shot[i]);
		}
		for (int i = 0; i < stCof.length; i++) {
			tall[i] = new JLabel();
			tall[i].setBounds(250, 70 + 40 * i, 100, 30);
			tall[i].setText(tPrice[i]);
			add(tall[i]);
		}
		for (int i = 0; i < stCof.length; i++) {
			grde[i] = new JLabel();
			grde[i].setBounds(300, 70 + 40 * i, 100, 30);
			grde[i].setText(gPrice[i]);
			add(grde[i]);
		}

		//
		setLayout(null);
		setBounds(100, 100, 400, 600);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == close) {
			this.dispose();
		}

	}

}
