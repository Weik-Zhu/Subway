package findpath;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class fingLocation extends JFrame {
	public fingLocation(){
		
		

	View view = new View();
	
	JButton go = new JButton("go");


	JTextField putInLocation = new JTextField(10);
	JTextField putInTime = new JTextField(5);

	JLabel putlocation = new JLabel("please put in location");
	JLabel puttime = new JLabel("please put in time");
	
	JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
	panel.add(putlocation);
	panel.add(putInLocation);
	panel.add(puttime);
	panel.add(putInTime);
	panel.add(go);
	add(panel, BorderLayout.NORTH);
	
	add(view, BorderLayout.CENTER);
	
	setTitle("FindthePath");
	setSize(1500, 900);
	setLocation(60, 0);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);

	
}
	
	public static void main(String[] args) throws Exception {
		new fingLocation();
	}
}

class View extends JPanel  {
	private Image image = null;
	private ImageIcon icon1 = new ImageIcon(
			"C:\\Users\\I310838\\Desktop\\subwayline.jpg");

	public View() {
	}

	public void dataChange() {
		repaint();
	}

	public void paint(Graphics g) {

			image = icon1.getImage();
			g.drawImage(image, 0, 0, null);
	        g.setColor(Color.black);
	       // g.fillOval(188, 445, 10, 10);
	       // g.fillOval(212, 466, 10, 10);
	       // g.fillOval(255, 466, 10, 10);
	       // g.fillOval(290, 466, 10, 10);
	       //g.fillOval(323, 466, 10, 10);
	       // g.fillOval(355, 466, 10, 10);
	        //g.fillOval(390, 466, 10, 10);
	        //g.fillOval(436, 466, 10, 10);
	        //g.fillOval(469, 466, 10, 10);
	       // g.fillOval(515, 466, 10, 10);
	        //g.fillOval(550, 466, 10, 10);
	        //g.fillOval(591, 466, 10, 10);
	       // g.fillOval(654, 466, 10, 10);
	        //g.fillOval(701, 466, 10, 10);
	        //g.fillOval(749, 466, 10, 10);
	        //g.fillOval(791, 466, 10, 10);
	       // g.fillOval(816, 466, 10, 10);
	        //g.fillOval(872, 466, 10, 10);
	       // g.fillOval(913, 466, 10, 10);
	        //g.fillOval(953, 466, 10, 10);
	       // g.fillOval(997, 466, 10, 10);
	       // g.fillOval(1032, 469, 10, 10);
	       // g.fillOval(1063, 469, 10, 10);
	      //  g.fillOval(1095, 472, 10, 10);
	       // g.fillOval(1125, 472, 10, 10);
	        //g.fillOval(1160, 472, 10, 10);
	      //  g.fillOval(1195, 472, 10, 10);
	       // g.fillOval(1235, 472, 10, 10);       
	       // g.fillOval(1255, 480, 10, 10);
	      //  g.fillOval(1270, 495, 10, 10);
	       // g.fillOval(1283, 507, 10, 10);
	       // g.fillOval(1297, 520, 10, 10);
	       // g.fillOval(1315, 535, 10, 10);
	        g.fillOval(1330, 550, 10, 10);
		
		}
	}
