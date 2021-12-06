package trabajofinal;

import edu.uc3m.game.GameBoardGUI;

public class Torpedo {//clase Torpedo con campos id, x, y, y uno para las funciones de la GUI
private int id;
private int x;
private int y;
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

public GameBoardGUI getGui() {
	return gui;
}

public void setGui(GameBoardGUI gui) {
	gui.gb_addSprite(getId(),"torpedo100.png", true);
	gui.gb_moveSpriteCoord(getId(),getX(),getY());
	gui.gb_setSpriteVisible(getId(),false);
	this.gui = gui;
}

public Torpedo(int id, int x, int y, GameBoardGUI gui) {
	setId(id);
	setX(x);
	setY(y);
	setGui(gui);
}

public void dispararTorpedo(int x, int y) {//metodo dispararTorpedo
	this.x = x;
	this.y = y;
	
	
	
}
}
