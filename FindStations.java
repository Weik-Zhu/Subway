package findpath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
//��������·�����㷨��ͨ������ÿһ����һվ���ҽ��
public class FindStations {
	private StationInMvc mvc;
	private StationList stationList;

	public FindStations(StationInMvc mvc) {
		this.mvc = mvc;
		this.stationList = mvc.getStationList();
	}

	public ArrayList<ArrayList<Station>> getPath() {
//��stationList���ҳ���վ�����û������һ�£�
		int j = stationList.getList().size() + 1;
		for (int i = 0; i < stationList.getList().size(); i++) {
			if (mvc.getPutInLocation().getText()
					.equals(stationList.getList().get(i).getName())) {
				j = i;
				break;
			}
		}
		int count = 0;
//�õ���վ
		Station head = stationList.getList().get(j);
		int target = Integer.parseInt(mvc.getPutInTime().getText());
		ArrayList<ArrayList<Station>> allLists = new ArrayList<ArrayList<Station>>();
//��������list�������ɸѡ���
		ArrayList<ArrayList<String>> allLists1 = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> allLists2 = new ArrayList<ArrayList<String>>();
		
		ArrayList<Station> list = new ArrayList<Station>();
		head.setWasVisited(true);
		list.add(head);
//��վ����·������ʼ�ݹ麯��
		findPaths(head, target, count, list, allLists, allLists1, allLists2);
		head.setWasVisited(false);
		return allLists;
	}

	public boolean findPaths(Station head, int target, int count,
			ArrayList<Station> list, ArrayList<ArrayList<Station>> allLists,
			ArrayList<ArrayList<String>> allLists1,
			ArrayList<ArrayList<String>> allLists2) {
		// if time is out,we stop
		if (count > target) {
			return true;
		}
		// get all the next stations we can reach
		HashMap<Station, Integer> nexts = head.getNexts();

		// use iterator
		Iterator<Station> iterator = nexts.keySet().iterator();

		int isEnd = 0;

		// if iterator has next, it means having the next station to be reached
		while (iterator.hasNext()) {

			// get the next station
			Station ss = iterator.next();

			// judge this station whether be visited
			if (ss != null)
				if (!ss.isVisited()) {

					isEnd++;
					// get the time
					int val = nexts.get(ss);

					// add the time up
					count += val;

					// note this station be visited
					ss.setWasVisited(true);

					// add this station into the list
					list.add(ss);

					// change the name of the first station then use the same
					// method again
					boolean ismax = findPaths(ss, target, count, list,
							allLists, allLists1, allLists2);
					if (ismax == true)
						isEnd--;

					/*
					 * when the method return,which means the time has out,we
					 * remove the last station then judge again until it match
					 * the condition.
					 */

					// note the station not be visited because it has been
					// remove from the path
					list.get(list.size() - 1).setWasVisited(false);

					// minus the time of last station
					count -= nexts.get(list.get(list.size() - 1));

					// remove the last station from the path
					list.remove(list.size() - 1);
				}
		}
		// the station do not have any next stations so that save the path
//һ���ǳ�ȥһЩû�б�Ҫ�Ľ��������path 1:��1,2,3,4,5����path 2 ��1,7,8,4����path 1 ���Ե���5����path 2 ����4��4 ������path 1 ���ʱ�Ͳ�Ҫpath 2 �ˡ�
		if (isEnd == 0) {
			ArrayList<Station> temp = new ArrayList<Station>();
			ArrayList<String> temp1 = new ArrayList<String>();
			ArrayList<String> temp2 = new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				temp.add(list.get(i));
				temp1.add(list.get(i).getName());
				temp2.add(list.get(i).getName());
			}
			int k = list.size() - 1;
			String lastStation = temp1.get(k);
//�ж��¼����·���Ƿ�֮ǰ·������
			boolean include = false;
			for (int i = 0; i < allLists1.size(); i++) {
				ArrayList<String> tempList = new ArrayList<String>();
				tempList = allLists1.get(i);
				include = tempList.contains(lastStation);
				if (include == true)
					break;
			}
//�ж�֮ǰ·���Ƿ񱻵�ǰ·������
			if (include == false) {
				ArrayList<Integer> thePath = new ArrayList<Integer>();
				temp1.remove(k);
				for (int i = 0; i < allLists2.size(); i++) {
					int j = allLists2.get(i).size();
					String station = allLists2.get(i).get(j - 1);
					include = temp1.contains(station);
					if (include == true)
						thePath.add(i);
				}
//��ȥ��������·��
				if (thePath.size() > 0) {
					for (int i = thePath.size() - 1; i >= 0; i--) {
						int l = thePath.get(i);
						allLists.remove(l);
						allLists1.remove(l);
						allLists2.remove(l);
					}
				}
//����ɸѡ֮����ϵ�·��
				allLists.add(temp);				
				allLists1.add(temp1);
				allLists2.add(temp2);
			}
		}
		return false;
	}
}
