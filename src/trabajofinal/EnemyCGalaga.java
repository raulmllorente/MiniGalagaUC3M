package trabajofinal;

import edu.uc3m.game.GameBoardGUI;

public class EnemyCGalaga extends SuperClaseEnemy {
	private String image = "enemy1G0.png";//establecemos la imagen por defecto del enemigo Capitan Galaga
	private int reward = 500;//establecemos los puntos que consigue el jugador al eliminar a un enemigo Capitan Galaga
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

	public EnemyCGalaga() {

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

	public EnemyCGalaga(int id, int r, int x, int y, String image, int health) {
		super(id + 100, r, x, y);
		setImage(image);
		setHealth(health);
	}

	public EnemyCGalaga(int id, int x, int y, String image, int health) {
		super(id + 100, x, y);
		setImage(image);
		setHealth(health);
	}

	public boolean isAlive() {
		if (health == 0)
			return false;
		else
			return true;
	}

	public void mover(EnemyCGalaga enemiesc, int x, int y, String imgcgalaga) {//metodo para mover a los Capitanes Galaga
		enemiesc.setImage(imgcgalaga);
		enemiesc.setX(x);
		enemiesc.setY(y);
		gui.gb_addSprite(getId(), getImage(), true);
		gui.gb_moveSpriteCoord(getId(), getX(), getY());
		gui.gb_setSpriteVisible(getId(), true);
	}
	
	public void entradacgalaga(EnemyCGalaga enemiesc, int x, int y, String imgcgalaga, int num) {//metodo entrada Capitanes Galaga para la presentacion
		
			enemiesc.setId(num+100);//set de id en 100
			enemiesc.setX(x);
			enemiesc.setY(y);
			enemiesc.setImage(imgcgalaga);
		
	}

}
