import java.util.HashMap;
import java.util.Map;

public class MoveSet {

	private Map<Integer, Move> moveMap = new HashMap<Integer,Move>();
	private int id;
	
	public MoveSet(int id)
	{
		this.id = id;
		
		if(id == 0)
		{
			moveMap.put(0, new Move(10, "Tackle", 95, "Normal"));
			moveMap.put(1, new Move(0, "Tail whip", 100, "Normal"));
			moveMap.put(2, new Move(40, "Bite", 85, "Dark"));
			moveMap.put(3, new Move(50, "Leaf Attack", 80, "Plant"));
		}
		
		if(id == 1)
		{ 
			moveMap.put(0, new Move(10, "Tackle", 95, "Normal"));
			moveMap.put(1, new Move(0, "Tail whip", 100, "Normal"));
			moveMap.put(2, new Move(40, "Bite", 85, "Dark"));
			moveMap.put(3, new Move(50, "Fire Attack", 80, "Fire"));
		}
		
		if(id == 2)
		{ 
			moveMap.put(0, new Move(10, "Tackle", 95, "Normal"));
			moveMap.put(1, new Move(0, "Tail whip", 100, "Normal"));
			moveMap.put(2, new Move(40, "Bite", 85, "Dark"));
			moveMap.put(3, new Move(50, "Water Attack", 80, "Water"));
		}
	}

	public Map<Integer, Move> getMoveMap() {
		return moveMap;
	}

	public void setMoveMap(Map<Integer, Move> moveMap) {
		this.moveMap = moveMap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MoveSet [moveMap=" + moveMap.toString() + "]";
	}
	
	
	
	
}
