package trabajofinal;

public class SuperClaseEnemy {//superclase que contiene la "x" y la "y" de los enemigos

	private int id;
	private int r = 0; //rotacion
	private int x;
	private int y;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
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

	public SuperClaseEnemy() {

	}

	public SuperClaseEnemy(int id, int r, int x, int y) {//constructor de la superclase con rotacion
		setId(id);
		setR(r);
		setX(x);
		setY(y);
	}

	public SuperClaseEnemy(int id, int x, int y) {//constructor de la superclase sin rotacion
		setId(id);
		setX(x);
		setY(y);
	}

}
