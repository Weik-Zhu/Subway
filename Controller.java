package findpath;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLayeredPane;

class Controller implements ActionListener {
	private DataModel dm;
	private StationInMvc mvc;
	private ArrayList<ArrayList<Station>> allPaths;
	private HashMap<Station, ArrayList<Integer>> ways = new HashMap<Station, ArrayList<Integer>>();

	public Controller(DataModel dm, StationInMvc mvc) {
		this.dm = dm;
		this.mvc = mvc;
	}

	// 点击事件后，执行findStation算法来得到所有结果
	public void actionPerformed(ActionEvent evt) {

		FindStations findStations = new FindStations(mvc);
		allPaths = findStations.getPath();

		ArrayList<Station> lastStation = new ArrayList<Station>();
		for (int i = 0; i < allPaths.size(); i++) {
			ArrayList<Station> temp = allPaths.get(i);
			Station lastsStation = temp.get(temp.size() - 1);

			if (ways.containsKey(lastsStation)) {
				ways.get(lastsStation).add(i);
			} else {
				ArrayList<Integer> templistList = new ArrayList<Integer>();
				templistList.add(i);
				ways.put(lastsStation, templistList);
			}
			
			lastStation.add(lastsStation);
		}
	//	dm.newList();
	//	dm.newStationList();
		dm.addStationlist(allPaths);
		dm.addList(ways);
	}
}