package findpath;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
//把按钮变为圆形
public class ovelButton extends JButton{
	private int r = 10 ;
	private String s;
	public ovelButton(String s){
		this.s = s;
	}
	public void bigger(){
		r = 30;
         repaint();
	}
	public void smaller(){
		r = 10;
         repaint();
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.green);
		g.fillOval((getWidth()-r)/2, (getHeight()-r)/2 , r, r);
		g.setColor(Color.red);
		g.drawString(s, 5, 20);
		
	}
}
