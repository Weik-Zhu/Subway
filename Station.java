package findpath;

import java.util.HashMap;
//这是车站类
public class Station {
    private String name;
//防止死循环而设置被访问过
    private boolean visited;
//存放下一站的信息
    private HashMap<Station, Integer> nexts;
//每一站的坐标
    private int x;
    private int y;
    
    public Station(String name) {
        this.name = name;
        this.visited = false;
        this.nexts = new HashMap<Station, Integer>();
    }
    
    public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
   public void setY(int y) {
		this.y = y;
	}
	public String getName(){
    	return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setWasVisited(boolean visited) {
        this.visited = visited;
    }

    public HashMap<Station, Integer> getNexts() {
        return nexts;
    }

    public void setNexts(HashMap<Station, Integer> nexts) {
        this.nexts = nexts;
    }
}

