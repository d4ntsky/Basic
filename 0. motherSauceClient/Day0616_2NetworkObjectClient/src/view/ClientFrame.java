package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import thread.WriteThread;

public class ClientFrame extends JFrame implements ActionListener{
	public JTextArea txtA = new JTextArea();
		
	JButton btnTransfer = new JButton("전송");
	JButton btnExit = new JButton("닫기");
		
	JPanel p1 = new JPanel();
	
	public boolean isFirst = true;
	
	public Socket socket;
	WriteThread wt;
		
	public ClientFrame(Socket socket) {		
		this.socket = socket;
		wt = new WriteThread(this);
		new IdClass(wt, this);
		
		add("Center", txtA);
		
		//p1.add(txtF);
		p1.add(btnTransfer);
		p1.add(btnExit);
		add("South", p1);
		
		//메세지를 전송하는 클래스 생성.		
		btnTransfer.addActionListener(this);
		btnExit.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 350, 300);
		setVisible(false);	
	}
	
	public void actionPerformed(ActionEvent e){
		String id = IdClass.getId();
		
		if(e.getSource() == btnTransfer){//전송버튼 눌렀을 경우
			
			SingletonClass sc = SingletonClass.getInstance();
			if(sc.ns.getNumber() == sc.ns.getPlay()){
				wt.sendMsg();
			//	txtA.append("["+id+"]" + "\n");				
			}else{
				JOptionPane.showMessageDialog(null, "당신 차례가 아닙니다");
			}
			
		}else{
			this.dispose();
		}
	}
}