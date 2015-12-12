package findpath;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

//±³¾°
class mapView extends JPanel implements DataListener {
	private Image image = null;
	private ImageIcon icon1 = new ImageIcon(
			"C:\\Users\\I310838\\Desktop\\project information\\subwayline.jpg");
	private ImageIcon icon2 = new ImageIcon(
			"C:\\Users\\I310838\\Desktop\\project information\\subwayline2.jpg");
	private ArrayList<ArrayList<Station>> DrawList = new ArrayList<ArrayList<Station>>();
	private DataModel dm;

	public mapView(DataModel dm) {
		this.dm = dm;
		setBounds(new Rectangle(150, 0, 2000, 2000));
	}

	public void dataChange() {
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		DrawList = dm.getStationlist();
		if (DrawList.size() == 0) {
			image = icon1.getImage();
			g.drawImage(image, 0, 50, null);
		} else {
			image = icon2.getImage();
			g.drawImage(image, 0, 50, null);
			g.setColor(Color.black);
			g.drawOval(DrawList.get(0).get(0).getX(), DrawList.get(0).get(0)
					.getY() + 50, 10, 10);
			g.setColor(Color.magenta);
			g.fillOval(DrawList.get(0).get(0).getX(), DrawList.get(0).get(0)
					.getY()+ 50, 10, 10);
		}
	}
}

