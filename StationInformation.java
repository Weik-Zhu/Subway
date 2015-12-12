package findpath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
//从文件中读入每站的数据，包括坐标，下一站，到达下一站的时间，并转化为我的数据结构
public class StationInformation {
	private ArrayList<String>stations = new ArrayList<String>();
	private ArrayList<Integer>locationX = new ArrayList<Integer>();
	private ArrayList<Integer>locationY = new ArrayList<Integer>();
	ArrayList<ArrayList<String>>nextStation = new ArrayList<ArrayList<String>>();
public StationInformation()  throws Exception{
	FileReader fr = new FileReader("C:\\Users\\I310838\\Desktop\\project information\\station Information.txt");
	BufferedReader br = new BufferedReader(fr);
	
	String line = null;
	while((line=br.readLine()) != null) {
		String[] temp = line.split("	");
		stations.add(temp[0]);
		locationX.add(Integer.parseInt(temp[2]));
		locationY.add(Integer.parseInt(temp[3]));
		ArrayList<String>tempArrayList = new ArrayList<String>();
        for (int i = 4; i < temp.length; i++) {
        tempArrayList.add(temp[i]);			
		}
        nextStation.add(tempArrayList);		
		}
      }
public ArrayList<String> getStations() {
	return stations;
}
public ArrayList<Integer> getLocationX() {
	return locationX;
}
public ArrayList<Integer> getLocationY() {
	return locationY;
}
public ArrayList<ArrayList<String>> getNextStation() {
	return nextStation;
}

}
