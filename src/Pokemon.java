import java.awt.Image;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Pokemon {

	private int id;
	private int currentHp;
	private int maxHp;
	private String name;
	private int attack;
	private int defense;
	private MoveSet moveSet;
	private Random randy = new Random();
	private Image img; // = ImageIO.read(getClass().getResource("resources/squirt120.png"));
	private Image deadImg;

	public Pokemon(int id, String name) {
		this.id = id;
		this.name = name;
		this.maxHp = randy.nextInt(20, 25);
		this.currentHp = maxHp;
		this.attack = randy.nextInt(10, 15);
		this.defense = randy.nextInt(10, 14);
		this.moveSet = new MoveSet(this.id);
		try {

			if (id == 0) {
				this.img = ImageIO.read(getClass().getResource("resources/bulba120.png"));
				this.deadImg = ImageIO.read(getClass().getResource("resources/deadBulba120.png"));
			}
			if (id == 1) {
				this.img = ImageIO.read(getClass().getResource("resources/char120.png"));
				this.deadImg = ImageIO.read(getClass().getResource("resources/deadChar120.png"));
			}
			if (id == 2) {
				this.img = ImageIO.read(getClass().getResource("resources/squirt120.png"));
				this.deadImg = ImageIO.read(getClass().getResource("resources/deadSquirt120.png"));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error in Pokemon creation icon ... " + e);
		}
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	
	public Image getDeadImg() {
		return deadImg;
	}

	public void setDeadImg(Image deadImg) {
		this.deadImg = deadImg;
	}

	public MoveSet getMoveSet() {
		return moveSet;
	}

	public void setMoveSet(MoveSet moveSet) {
		this.moveSet = moveSet;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", hp=" + maxHp + ", name=" + name + ", attack=" + attack + ", defense=" + defense
				+ ", \nmoveSet=" + moveSet.toString() + "]";
	}

}
