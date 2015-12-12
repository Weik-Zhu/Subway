package findpath;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JPanel;

class TextView extends JPanel implements DrawListener {
	private DataModel dm;
	private ArrayList<ArrayList<Station>> DrawList;
	public TextView(DataModel dm) {
		this.dm = dm;
		setOpaque(false);
		setBounds(new Rectangle(150, 50, 2000, 2000));
	}
	
	public void drawChange() {
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		// 拿到allList，这是所有结果，然后开始画paths
		DrawList = dm.getShowList();
		if (DrawList.size() == 0) {
		} else {
			for (int i = 0; i < DrawList.size(); i++) {
				ArrayList<Station> path = new ArrayList<Station>();
				path = DrawList.get(i);
				for (int j = 0; j < path.size(); j++) {
					g.setColor(Color.white);
					g2d.setStroke(new BasicStroke(5));
					if (j != path.size() - 1)
						g.drawLine(path.get(j).getX() + 5,
								path.get(j).getY() + 5,
								path.get(j + 1).getX() + 5, path.get(j + 1)
										.getY() + 5);
					g.setColor(Color.BLACK);
					g2d.setStroke(new BasicStroke(2));
					g.drawOval(path.get(j).getX(), path.get(j).getY(), 10, 10);

					if (j == 0)
						g.setColor(Color.magenta);
					else if (j == path.size() - 1)
						g.setColor(Color.red);
					else
						g.setColor(Color.orange);
					g.fillOval(path.get(j).getX(), path.get(j).getY(), 10, 10);

				}
			}
		}
	}
}
