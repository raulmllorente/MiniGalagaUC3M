package trabajofinal;

import edu.uc3m.game.GameBoardGUI;

public class EnemyZako extends SuperClaseEnemy {
	private String image = "enemy3G0.png";//establecemos la imagen por defecto del enemigo Zako
	private int reward = 100;//establecemos los puntos que consigue el jugador al eliminar a un enemigo Zako
	private int health;
	protected GameBoardGUI gui;

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}

	public GameBoardGUI getGui() {
		return gui;
	}

	public void setGui(GameBoardGUI gui) {
		gui.gb_addSprite(getId(), getImage(), true);
		gui.gb_moveSpriteCoord(getId(), getX(), getY());
		gui.gb_setSpriteVisible(getId(), true);

		this.gui = gui;
	}

	public EnemyZako() {

	}

	public EnemyZako(int id, int r, int x, int y, String image, int health) {
		super(id + 300, r, x, y);
		setImage(image);
		setHealth(health);
	}

	public EnemyZako(int id, int x, int y, String image, int health) {
		super(id + 300, x, y);
		setImage(image);
		setHealth(health);
	}

	public boolean isAlive() {
		if (health == 0)
			return false;
		else
			return true;
	}

	public void mover(EnemyZako enemiesz, int x, int y, String imgzako) {//metodo para mover a los Zako
		enemiesz.setImage(imgzako);
		enemiesz.setX(x);
		enemiesz.setY(y);
		gui.gb_addSprite(getId(), getImage(), true);
		gui.gb_moveSpriteCoord(getId(), getX(), getY());
		gui.gb_setSpriteVisible(getId(), true);

	}
	
	public void entradazako(EnemyZako enemiesz, int x, int y, String imgzako, int num) {//metodo entrada Zako para la presentacion
		
		
		enemiesz.setId(num+300);//set de id en 300
		enemiesz.setX(x);
		enemiesz.setY(y);
		enemiesz.setImage(imgzako);
	
}
}
