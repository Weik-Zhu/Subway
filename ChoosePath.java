package findpath;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextArea;

public class ChoosePath implements ActionListener {
	private ArrayList<ArrayList<Station>> allPaths;
	private DataModel dm;
	private int i ;
	private JTextArea showRout;
	
	public ChoosePath(int i, ArrayList<ArrayList<Station>> allPaths, DataModel dm, JTextArea showRout) {
		this.allPaths = allPaths;
		this.dm = dm;
		this.i = i;
		this.showRout = showRout;
	}

	public void actionPerformed(ActionEvent arg0) {

		ArrayList<ArrayList<Station>> path = new ArrayList<ArrayList<Station>>();
		path.add(allPaths.get(i));
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
		
	}

}
