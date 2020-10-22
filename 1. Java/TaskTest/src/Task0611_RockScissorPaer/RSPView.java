package Task0611_RockScissorPaer;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RSPView extends JFrame implements ActionListener {

	JLabel frontLabel;
	JLabel label[];
	JButton RSPbutton[];
	
	RSPGame game = new RSPGame(); 		//RSP 게임을 만든 후
	
	public RSPView() {
			super("가위 바위 보");
			
			//UI 꾸미기
			setLayout(null);
			
			frontLabel = new JLabel("? 승 ? 패 ? 무");
			frontLabel.setBounds(70, 50, 500, 30);
			frontLabel.setBackground(Color.yellow);
			frontLabel.setHorizontalAlignment(JLabel.CENTER);	//중앙에 위치하게
			frontLabel.setOpaque(true);							//불투명하게..확인
			add(frontLabel);
			
			label = new JLabel[5]; //JLabel은 swing기어이며 한글이 안 깨져서 낫다.?
			
			label[0] = new JLabel("Player");
			label[0].setBounds(70, 100, 150, 30);
			label[0].setBackground(Color.darkGray);
			label[0].setHorizontalAlignment(JLabel.CENTER);
			label[0].setOpaque(true);
			label[0].setForeground(Color.white);				//폰트색깔
			add(label[0]);
			
			label[0] = new JLabel("Player");
			label[0].setBounds(70, 100, 150, 30);
			label[0].setBackground(Color.darkGray);
			label[0].setHorizontalAlignment(JLabel.CENTER);
			label[0].setOpaque(true);
			label[0].setForeground(Color.white);				
			add(label[0]);
			
			label[1] = new JLabel("Computer");
			label[1].setBounds(420, 100, 150, 30);
			label[1].setBackground(Color.darkGray);
			label[1].setHorizontalAlignment(JLabel.CENTER);
			label[1].setOpaque(true);
			label[1].setForeground(Color.white);				
			add(label[1]);
			
			label[2] = new JLabel("player's");
			label[2].setBounds(70, 150, 150, 60);
			label[2].setBackground(Color.blue);
			label[2].setHorizontalAlignment(JLabel.CENTER);
			label[2].setOpaque(true);
			label[2].setForeground(Color.white);				
			add(label[2]);
			
			label[3] = new JLabel("result");
			label[3].setBounds(245, 150, 150, 60);
			label[3].setBackground(Color.green);
			label[3].setHorizontalAlignment(JLabel.CENTER);
			label[3].setOpaque(true);
			label[3].setForeground(Color.white);				
			add(label[3]);
		
			label[4] = new JLabel("Computer's");
			label[4].setBounds(420, 150, 150, 60);
			label[4].setBackground(Color.red);
			label[4].setHorizontalAlignment(JLabel.CENTER);
			label[4].setOpaque(true);
			label[4].setForeground(Color.white);				
			add(label[4]);
			
			RSPbutton = new JButton[3];
			String btnTitle[] = {"가위","바위","보"};
			for (int i = 0; i < btnTitle.length; i++) {
				RSPbutton[i] = new JButton(btnTitle[i]);
				RSPbutton[i].setBounds( 120 + 140 * i , 250, 120, 50);
				RSPbutton[i].addActionListener(this);
				add(RSPbutton[i]);
			}
			
			//기본
			setSize(640, 480);
			setLocation(100, 0);
			setBackground(Color.white);//색깔 넣기
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Jframe용 닫기?
			
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		String title = btn.getLabel();
		
		game.init();			//restart가 있으면 init에서 restart까지 다 해야
		
		if(title.equals("가위")) {
			game.setUrsNum(0);
		}
		else if(title.equals("바위")) {
			game.setUrsNum(1);
		}
		else if(title.equals("보")) {
			game.setUrsNum(2);
		}
		
		//각각 가위바위보중 뭘 냈는지 받는
		label[2].setText(game.getUrs());
		label[4].setText(game.getCom());
		
		//승패무 를 가려주는 부분
		String msg = game.play();
		label[3].setText(msg);
		
		//승패 전적을 남기는 부분
		int win = game.getWin();
		int lose = game.getLose();
		int draw = game.getDraw();
		frontLabel.setText(win + "승 " + lose + "패 " + draw + "무");
			
	}

}

