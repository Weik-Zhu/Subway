package findpath;

import java.util.ArrayList;
import java.util.HashMap;

interface DataListener {
	public void dataChange();
}

interface DrawListener {
	public void drawChange();
}

public class DataModel {
	private ArrayList<DataListener> listener;
	private ArrayList<DrawListener> drawListeners;
	private HashMap<Station, ArrayList<Integer>> list;
	private ArrayList<ArrayList<Station>> showList;
	private ArrayList<ArrayList<Station>> stationList;

	public DataModel() {
		listener = new ArrayList<DataListener>();
		drawListeners = new ArrayList<DrawListener>();
		list = new HashMap<Station, ArrayList<Integer>>();
		showList = new ArrayList<ArrayList<Station>>();
		stationList = new ArrayList<ArrayList<Station>>();
	}

	// 清空之前的结果
	public void newList() {
		list = new HashMap<Station, ArrayList<Integer>>();
		// fireDataChange();
	}

	public void newShowList() {
		showList = new ArrayList<ArrayList<Station>>();
		// fireDrawChange();
	}

	public void newStationList() {
		stationList = new ArrayList<ArrayList<Station>>();
	}

	public void addStationlist(ArrayList<ArrayList<Station>> s) {
		stationList = s;
	}

	// 得到当前结果
	public void addList(HashMap<Station, ArrayList<Integer>> s) {
		list = s;
		fireDataChange();
	}

	public void addShowList(ArrayList<ArrayList<Station>> s) {
		showList = s;
		fireDrawChange();
	}

	public HashMap<Station, ArrayList<Integer>> getList() {
		return list;
	}

	public ArrayList<ArrayList<Station>> getShowList() {
		return showList;
	}

	public ArrayList<ArrayList<Station>> getStationlist() {
		return stationList;
	}

	public void addDataListener(DataListener l) {
		listener.add(l);
	}

	public void removeDateListener(DataListener l) {
		listener.remove(l);
	}

	public void addDrawListener(DrawListener l) {
		drawListeners.add(l);
	}

	public void fireDataChange() {
		for (DataListener l : listener) {
			l.dataChange();
		}
	}

	public void fireDrawChange() {
		for (DrawListener l : drawListeners) {
			l.drawChange();
		}
	}
}
