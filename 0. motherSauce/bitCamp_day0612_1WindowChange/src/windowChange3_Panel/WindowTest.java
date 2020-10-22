package windowChange3_Panel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WindowTest extends JFrame {
	
	Panel panel1, panel2;
	JButton btn;

	public WindowTest() {
		
		
		
		panel1 = new Panel();
		panel1.setLayout(null);
		panel1.setBackground(Color.green);
		add(panel1);
		
		btn = new JButton("go panel2");
		btn.setBounds(10, 40, 100, 100);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource();
				panel1.setVisible(false);
				panel2 = new Panel();;
				panel2.setBackground(Color.red);
				panel2.setVisible(true);
			}
			
		});
		panel1.add(btn);
			
		
		
		//------------------------------------------------
		setBounds(0, 0, 640, 480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}
	
}

