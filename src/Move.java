
public class Move {

	private int damage;
	private String moveName;
	private int accuracy;
	private String type;
	 
	
	 

	public Move(int damage, String moveName, int accuracy, String type) {
		super();
		this.damage = damage;
		this.moveName = moveName;
		this.accuracy = accuracy;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return moveName;
	}

	public void setName(String moveName) {
		this.moveName = moveName;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	@Override
	public String toString() {
		return "\nMove [damage=" + damage + ", moveName=" + moveName + ", accuracy=" + accuracy + ", type=" + type + "]";
	}
	
	
	
}
