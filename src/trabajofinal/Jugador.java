package trabajofinal;

import edu.uc3m.game.GameBoardGUI;

public class Jugador {//clase Jugador con campos id, x, y, vidas que le quedan y numero de vidas del jugador, nivel de juego, velocidad de juego, numero de disparos y de aciertos y un campo para las funciones de la GUI
	private int playerhealth;
	private int maxhealth;
	private int playerpts;
	private int nivel;
	private int veljuego;
	private int ndisparos;
	private int naciertos;
	private int x;
	private int y;
	private int id;
	protected GameBoardGUI gui;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getPlayerhealth() {
		return playerhealth;
	}

	public void setPlayerhealth(int playerhealth) {
		this.playerhealth = playerhealth;
	}

	public int getMaxhealth() {
		return maxhealth;
	}

	public void setMaxhealth(int maxhealth) {
		this.maxhealth = maxhealth;
	}

	public int getPlayerpts() {
		return playerpts;
	}

	public void setPlayerpts(int playerpts) {
		this.playerpts = playerpts;
	}

	public int getVeljuego() {
		return veljuego;
	}

	public void setVeljuego(int veljuego) {
		this.veljuego = veljuego;
	}

	public int getNdisparos() {
		return ndisparos;
	}

	public void setNdisparos(int ndisparos) {
		this.ndisparos = ndisparos;
	}

	public int getNaciertos() {
		return naciertos;
	}

	public void setNaciertos(int naciertos) {
		this.naciertos = naciertos;
	}

	public GameBoardGUI getGui() {
		return gui;
	}

	public void setGui(GameBoardGUI gui) {
		gui.gb_addSprite(getId(), "player.png", true);
		gui.gb_moveSpriteCoord(getId(), getX(), getY());
		gui.gb_setSpriteVisible(getId(), true);
		this.gui = gui;

	}

	public Jugador(int playerhealth, int maxhealth, int playerpts, int nivel, int veljuego, int ndisparos,
			int naciertos, int id, int x, int y, GameBoardGUI gui) {//constructor de la clase Jugador, incluye la primera actualización de los campos información del juego
		setId(id);
		setPlayerhealth(playerhealth);
		setMaxhealth(maxhealth);
		setPlayerpts(playerpts);
		setNivel(nivel);
		setVeljuego(veljuego);
		setNdisparos(ndisparos);
		setNaciertos(naciertos);
		setX(x);
		setY(y);
		gui.gb_setTextLevel("Nivel del juego:");
		gui.gb_setValueLevel(nivel);
		gui.gb_setPortraitPlayer("galagaLogo.jpg");
		gui.gb_setTextPlayerName("Alvaro y Raul");
		gui.gb_setTextAbility1("Disparos:");
		gui.gb_setTextAbility2("Aciertos:");
		gui.gb_setValueAbility1(ndisparos);
		gui.gb_setValueAbility2(naciertos);
		gui.gb_setValueHealthCurrent(playerhealth);
		gui.gb_setValueHealthMax(maxhealth);
		gui.gb_setTextPointsUp("Puntos:");
		gui.gb_setTextPointsDown("Velocidad:");
		gui.gb_setValuePointsUp(playerpts);
		gui.gb_setValuePointsDown(veljuego);
		setGui(gui);

	}

}
