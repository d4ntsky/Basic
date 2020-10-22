package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import thread.WriteThread;

public class IdClass extends JFrame implements ActionListener{
	static JTextField tf = new JTextField(8);
	JButton btn = new JButton("입력");	
	
	WriteThread wt;	
	ClientFrame cf;
	
	public IdClass(){}
	public IdClass(WriteThread wt, ClientFrame cf) {
		super("아이디");		
		this.wt = wt;
		this.cf = cf;		
		
		setLayout(new FlowLayout());
		add(new JLabel("아이디"));
		add(tf);
		add(btn);
		
		btn.addActionListener(this);
		
		setBounds(300, 300, 250, 100);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {		
		wt.sendMsg();	
		cf.isFirst = false;
		cf.setVisible(true);
		this.dispose();
	}
	
	static public String getId(){
		return tf.getText();
	}
}