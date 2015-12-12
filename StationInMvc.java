package findpath;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 这是主函数，用来初始化各个模块和建立界面框架
public class StationInMvc extends JFrame {
	private JTextField putInLocation;
	private JTextField putInTime;
	private StationList stationList;
	private JPanel showChoice;
	private JLayeredPane layer;
	private JPanel testPanel;

	public StationInMvc() throws Exception {
		DataModel dm = new DataModel();

		layer = this.getLayeredPane();

		StationInformation stationInformation = new StationInformation();

		stationList = new StationList(stationInformation);
		
		TextView tv = new TextView(dm);
		dm.addDrawListener(tv);
		
		mapView mapView = new mapView(dm);
		dm.addDataListener(mapView);

		stationView stationView = new stationView(dm, this);
		dm.addDataListener(stationView);
		
		Controller c = new Controller(dm, this);
		
		JButton go = new JButton("go");
		go.setBackground(Color.gray);
		go.addActionListener(c);
		go.setBounds(new Rectangle(20, 120, 220, 30));

		putInLocation = new JTextField(10);
		putInLocation.setBounds(new Rectangle(150, 20, 100, 30));
		putInTime = new JTextField(10);
		putInTime.setBounds(new Rectangle(150, 70, 100, 30));
		
		JLabel putlocation = new JLabel("please put in location");
		putlocation.setBounds(new Rectangle(10, 10, 200, 50));
		JLabel puttime = new JLabel("please put in time");
		puttime.setBounds(new Rectangle(10, 60, 200, 50));
			
		JPanel panel = new JPanel();
		panel.setBounds(new Rectangle(0, 0, 270, 1000));
		panel.setLayout(null);
		panel.add(putlocation);	
		panel.add(putInLocation);
		panel.add(puttime);
		panel.add(putInTime);
		panel.add(go);
		
		showChoice = new JPanel();
		showChoice.setBounds(new Rectangle(0, 150, 270, 1000));
		showChoice.setLayout(null);
		
		testPanel = new JPanel();
		testPanel.setOpaque(false);
		testPanel.setBounds(new Rectangle(300, 50, 2000, 2000));
		
     	layer.add(tv, new Integer(500));
    	layer.add(panel, new Integer(600));
	    layer.add(stationView, new Integer(350));
	    layer.add(mapView, new Integer(50));
	    layer.add(showChoice, new Integer(700));
	    layer.add(testPanel, new Integer(350));
					
		setTitle("FindthePath");
		setSize(1550, 900);
		setLocation(60, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public JPanel getTestPanel() {
		return testPanel;
	}

	public JTextField getPutInLocation() {
		return putInLocation;
	}

	public JTextField getPutInTime() {
		return putInTime;
	}

	public StationList getStationList() {
		return stationList;
	}

	public JPanel getPanel() {
		return showChoice;
	}

	public JLayeredPane getLayer() {
		return layer;
	}

	public static void main(String[] args) throws Exception {
		new StationInMvc();
	}
}
