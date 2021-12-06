package trabajofinal;

import edu.uc3m.game.GameBoardGUI;

public class EnemyGoei extends SuperClaseEnemy {

	private String image = "enemy2G0.png";//establecemos la imagen por defecto del enemigo Goei
	private int reward = 250;//establecemos los puntos que consigue el jugador al eliminar a un enemigo Goei
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

	public EnemyGoei() {

	}

	public EnemyGoei(int id, int r, int x, int y, String image, int health) {
		super(id + 200, r, x, y);
		setImage(image);
		setHealth(health);
	}

	public EnemyGoei(int id, int x, int y, String image, int health) {
		super(id + 200, x, y);
		setImage(image);
		setHealth(health);
	}

	public boolean isAlive() {
		if (health == 0)
			return false;
		else
			return true;
	}

	public void mover(EnemyGoei enemiesg, int x, int y, String imggoei) {//metodo para mover a los Goei
		enemiesg.setImage(imggoei);
		enemiesg.setX(x);
		enemiesg.setY(y);
		gui.gb_addSprite(getId(), getImage(), true);
		gui.gb_moveSpriteCoord(getId(), getX(), getY());
		gui.gb_setSpriteVisible(getId(), true);

	}

	public void entradagoei(EnemyGoei enemiesg, int x, int y, String imggoei, int num) {//metodo entrada Goei para la presentacion
		
		
		enemiesg.setId(num+200);//set de id en 200
		enemiesg.setX(x);
		enemiesg.setY(y);
		enemiesg.setImage(imggoei);
	
}
}
