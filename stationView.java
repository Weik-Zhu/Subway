package findpath;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

class stationView extends JPanel implements DataListener {
	private ArrayList<ArrayList<Station>> stationList = new ArrayList<ArrayList<Station>>();
	private DataModel dm;
	private JLayeredPane layer;
	private HashMap<Station, ArrayList<Integer>> ways = new HashMap<Station, ArrayList<Integer>>();
	private StationInMvc mvc;

	public stationView(DataModel dm, StationInMvc mvc) {
		this.dm = dm;
		this.mvc = mvc;
		setOpaque(false);
		setBounds(new Rectangle(150, 50, 2000, 2000));
	}

	public void dataChange() {		
		repaint();	
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		layer = mvc.getLayer();
		ways = dm.getList();
		stationList = dm.getStationlist();

		Iterator<Station> iterator = ways.keySet().iterator();
		while (iterator.hasNext()) {

			Station ss = iterator.next();

			String s = "";
			s += ss.getName();
			final int k = s.length();
			final int x = ss.getX();
			final int y = ss.getY();
			final ovelButton button = new ovelButton(s);
			button.setBorder(null);
			button.setBounds(new Rectangle(x +140, y + 45, 10, 10));
			button.setBackground(Color.green);
			layer.add(button, new Integer(470));
	//		add(button);
			// 添加鼠标事件，鼠标进入button时放大
			MouseInputAdapter mouseHandler = new MouseInputAdapter() {

				public void mouseEntered(final MouseEvent e) {
					button.setBounds(new Rectangle(x +140 + 5 - (k * 16) / 2,
							y + 35, k * 16, 30));
					button.bigger();
				}

				public void mouseExited(final MouseEvent e) {
					button.setBounds(new Rectangle(x +140, y + 45, 10, 10));
					button.smaller();
				}
			};
			button.addMouseListener(mouseHandler);

			ShowPath showPath = new ShowPath(ways.get(ss), stationList, dm, mvc);
			button.addActionListener(showPath);
		}

		JLabel label = new JLabel(
				"You  will  arrive  at  the  stations  showed  in  the  map");
		label.setBounds(new Rectangle(600, 0, 900, 40));
		layer.add(label, new Integer(510));

	}
}
