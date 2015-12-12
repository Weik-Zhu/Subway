package findpath;
import java.util.ArrayList;
import java.util.HashMap;
//用StationInformation从文件里读取的信息来生成每个车站类，并将相应的数据存入每个站中
public class StationList {
	private ArrayList<Station> stationlist ;
	private HashMap<String, Station> map;
    private StationInformation information;
    
	public StationList(StationInformation stationInformation) throws Exception{
	stationlist = new ArrayList<Station>();
	map = new HashMap<String, Station>();	
	this.information = stationInformation;
	
	for(int i=0;i<information.getStations().size();i++){		
		Station s = new Station(information.getStations().get(i));
		map.put(information.getStations().get(i), s);	
	}
	
	for(int i=0;i<information.getStations().size();i++){
		Station ss = map.get(information.getStations().get(i));
		ss.setX(information.getLocationX().get(i));
		ss.setY(information.getLocationY().get(i));
		
		ArrayList<String> nextStationList = information.getNextStation().get(i);
		HashMap<Station, Integer> nexts = new HashMap<Station, Integer>();
		
		for (int j = 0; j < nextStationList.size(); j+=2) {
		 	String nextOne = nextStationList.get(j);
			Station sss = map.get(nextOne);
			String time = nextStationList.get(j+1);
		 	String[] temp = time.split(":");
		 	int k = Integer.parseInt((temp[1]));
		    nexts.put(sss, k);
		}
		
		ss.setNexts(nexts);		
		stationlist.add(ss);		
	}
	
  }
	public ArrayList<Station> getList(){
		return stationlist;
	}
}

