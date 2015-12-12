package findpath;

import java.util.HashMap;
//���ǳ�վ��
public class Station {
    private String name;
//��ֹ��ѭ�������ñ����ʹ�
    private boolean visited;
//�����һվ����Ϣ
    private HashMap<Station, Integer> nexts;
//ÿһվ������
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

