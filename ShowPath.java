package findpath;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//建立点击显示路线的监听器
class ShowPath implements ActionListener {
	private ArrayList<ArrayList<Station>> allPaths;
	private DataModel dm;
	private ArrayList<Integer> ways = new ArrayList<Integer>();
	private StationInMvc mvc;
	private JPanel panel = new JPanel();

	public ShowPath(ArrayList<Integer> ways, ArrayList<ArrayList<Station>> allPaths, DataModel dm, StationInMvc mvc) {
		this.ways = ways;
		this.allPaths = allPaths;
		this.dm = dm;
		this.mvc = mvc;
	}

	public void actionPerformed(ActionEvent e) {

		panel = mvc.getPanel();
		panel.removeAll();//清空上一次的结果
		
		JTextArea showRout = new JTextArea();
		showRout.setBounds(new Rectangle(10, 200, 250, 500));		
		panel.add(showRout);
		
		JLabel label = new JLabel("You have the following choices :");
		label.setBounds(new Rectangle(10, 10, 250, 30));
		panel.add(label);


		ArrayList<ArrayList<Station>> path = new ArrayList<ArrayList<Station>>();
		int k = ways.get(0);
		path.add(allPaths.get(k));
		dm.addShowList(path);
		
//建立文字显示
				ArrayList<Station> showDetail = new ArrayList<Station>();
				showDetail = path.get(0);
				ArrayList<String> showName = new ArrayList<String>();
				for (int j = 0; j < showDetail.size(); j++) {
					String name = showDetail.get(j).getName();
					showName.add(name);
				}

				String s = "";
				for (int j = 0; j < showName.size(); j++) {
					if (j == showName.size() - 1) {
						s = s + "     " + showName.get(j)+ "\n";
					}else
				s = s + "     " + showName.get(j) + "\n" + "        |" + "\n";
				}
				showRout.setText(s);

//建立左边的选择按钮
		for (int i = 0; i < ways.size(); i++) {
			int l = ways.get(i);
			JButton choiceButton = new JButton("route" + (i+1));
			choiceButton.setBackground(Color.lightGray);
			choiceButton.setBounds(new Rectangle(15 ,40 +i*40, 250, 30));

			panel.add(choiceButton);
			
			ChoosePath choosePath = new ChoosePath(l,allPaths, dm, showRout);
			choiceButton.addActionListener(choosePath);
		}
	}
}
