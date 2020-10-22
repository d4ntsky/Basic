package awtSample09_jcombobox;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WindowTest extends JFrame {
	
	String fruit[] = {"사과","배","귤","감","포도"};
	JLabel label;
	JComboBox<String> cbb;
	
	public WindowTest() {
		
		setLayout(new FlowLayout());
		
		cbb = new JComboBox<String>(fruit);
		add(cbb);
		
		cbb.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				label.setText((String)cbb.getSelectedItem());
				
			}
			
		});
		
		label = new JLabel("고른 과일");
		add(label);

		setBounds(0, 0, 640, 480);
		setVisible(true);
	}
}