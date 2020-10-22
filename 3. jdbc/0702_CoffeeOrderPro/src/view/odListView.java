package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.text.html.HTMLDocument.Iterator;

import dao.CafeDao;
import dao.CustomerDao;
import dto.CafeDto;

public class odListView extends JFrame implements ActionListener {

	JButton back, close, cancel;
	JLabel label;
	JTextArea textArea;

	public odListView() {
		super("주문 내역");
		setLayout(null);

		// 주문 추가하러 돌아가는 버튼
		back = new JButton();
		back.setText("주문 추가");
		back.setBounds(10, 400, 110, 40);
		back.setFont(new Font("바탕", Font.BOLD, 13));
		back.addActionListener(this);
		add(back);
		// 종료버튼
		close = new JButton();
		close.setText("종료");
		close.setBounds(1050, 400, 110, 40);
		close.setFont(new Font("바탕", Font.BOLD, 13));
		close.addActionListener(this);
		add(close);
		// 주문 취소
		cancel = new JButton();
		cancel.setText("주문 취소");
		cancel.setBounds(900, 400, 110, 40);
		cancel.setFont(new Font("바탕", Font.BOLD, 13));
		cancel.addActionListener(this);
		add(cancel);
		//
		label = new JLabel("주문 내역");
		label.setBounds(250, 10, 100, 15);
		add(label);

		// textarea 확인 필!!!!!!1
		textArea = new JTextArea(7, 20);
		textArea.setBounds(40, 50, 1100, 320);
		textArea.setText("아이디" + '\t' + "커피종류" + '\t' + '\t' + '\t' + "컵 사이즈" + '\t' + "시럽 추가" + '\t' + "샷 추가" + '\t'
				+ "크림 추가" + '\t' + "잔 수" + '\t' + "가격" + '\t' + "총합" + '\n');
		Border border = BorderFactory.createLineBorder(Color.white);
		textArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		add(textArea);

		// DB접근 Cafe
		CafeDao cadao = CafeDao.getInstance();

		List<CafeDto> list = cadao.getOrderList();

		for (CafeDto li : list) { // 곱하기 한 부분 체크

			textArea.append(li.getId() + '\t' + li.getCoffee() + '\t' + '\t' + li.getCupsize() + '\t' + li.getAddsyrp()
					+ '\t' + li.getAddshot() + '\t' + li.getAddwhip() + '\t' + li.getCups() + '\t' + li.getPrice()
					+ '\t' + (li.getCups() * li.getPrice()) + '\n');

		}

		//
		setLayout(null);
		setBounds(100, 100, 1200, 500);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();

		if (obj == back) {
			new menuView();
			this.dispose();
		} else if (obj == cancel) {

		} else if (obj == close) {
			this.dispose();
		}
	}
}
