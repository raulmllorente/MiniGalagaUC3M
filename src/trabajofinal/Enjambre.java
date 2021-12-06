package trabajofinal;

import edu.uc3m.game.GameBoardGUI;

public class Enjambre {
	//metodo para mover a los Capitanes Galaga
	private EnemyZako[] enemiesz;
	private EnemyGoei[] enemiesg; 
	private EnemyCGalaga[] enemiesc;
	private int nivel;
	protected GameBoardGUI gui;
	
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public EnemyZako[] getEnemiesz() {
		return enemiesz;
	}
	public void setEnemiesz(EnemyZako[] enemiesz) {//establecemos en el set de los enemigos Zako las propiedades iniciales
		int x = 50;
		int y = 50 + 10*(getNivel() - 1);
		int x2 = x;
		int y2 = y;
		int j = 0, cont = 1, vuelta = 1;
		for(int i=0; i < enemiesz.length; i++) {
			enemiesz[i].setImage("enemy3G0.png");
			enemiesz[i].setX(x);
			enemiesz[i].setY(y);
			enemiesz[i].setHealth(1);
				if (cont == 8) {
					j = -1;
					cont = 0;
					vuelta++;
				}
				if (cont < 8) {
					cont++;
				}
			x = x2 + 10*(j+1);
			y = y2 + 10*(vuelta - 1);
			j++;
		}
		this.enemiesz = enemiesz;
	}
	
	
	public EnemyGoei[] getEnemiesg() {
		return enemiesg;
	}
	public void setEnemiesg(EnemyGoei[] enemiesg) {//establecemos en el set de los enemigos Goei las propiedades iniciales
		int x = 65;
		int x2 = x;
		int y = 30;
		int y2 = y;
		int j = 0, cont = 1, vuelta = 1;
		for(int i=0; i < enemiesg.length; i++) {
			enemiesg[i].setImage("enemy2G0.png");
			enemiesg[i].setX(x);
			enemiesg[i].setY(y);
			enemiesg[i].setHealth(1);
			if (cont == 5) {
				j = -1;
				cont = 0;
				vuelta++;
			}
				
			if (cont < 5) {
				cont++;
			}
			x = x2 + 10*(j+1);
			y = y2 + 10 * (vuelta-1);
			j++;
		}
		this.enemiesg = enemiesg;
	}
	
	
	public EnemyCGalaga[] getEnemiesc() {
		return enemiesc;
	}
	public void setEnemiesc(EnemyCGalaga[] enemiesc) {//establecemos en el set de los enemigos Capitan Galaga las propiedades iniciales
		int x = (170 / 2) - (5 + 10 * (getNivel() -1)), x2 = x;
		int y = 20;
		for(int i=0; i < enemiesc.length; i++) {
			enemiesc[i].setImage("enemy1G0.png");
			enemiesc[i].setX(x);
			enemiesc[i].setY(y);
			enemiesc[i].setHealth(2);
			x = x2 + 10*(i+1);
		}
		this.enemiesc = enemiesc;
	}
	
	public GameBoardGUI getGui() {
		return gui;
	}
	public void setGui(GameBoardGUI gui) {
		this.gui = gui;
	}
	
	public Enjambre(EnemyZako[] enemiesz, EnemyGoei[] enemiesg, EnemyCGalaga[] enemiesc, int nivel, GameBoardGUI gui) {//constructor de la clase Enjambre
		setNivel(nivel);
		setEnemiesz(enemiesz);
		setEnemiesg(enemiesg);
		setEnemiesc(enemiesc);
		setGui(gui);
		
	}
	
	//metodo moverenjambre en el que controlamos movimiento del enjambre
	public void moverenjambre(EnemyZako[] enemiesz, EnemyGoei[] enemiesg, EnemyCGalaga[] enemiesc, int velocidad, Jugador jugador, Torpedo torpedo) throws InterruptedException{
		
		int j = 1, i = 0, ic = 0, kc = 0, ig = 0, kg = 0, iz = 0, kz = 0;
		boolean alcanzado = false, acabar = false;
		int movimientos, velocidad1, num_alcanzados = 0;

		if (velocidad < 0) //calculo de numero de movimientos en función de si desplaza a la derecha o la izquierda
			movimientos = ((enemiesz[0].getX())/(-velocidad) - (10/(-velocidad)) - 1);//desplazamiento a la izquierda
		else
		    movimientos = ((170 - enemiesz[enemiesz.length-1].getX())/velocidad - (10/velocidad) - 1);//desplazamiento a la derecha
		
		  while (!acabar && j <= movimientos) {//el enjambre se  mueve hacia uno de los lados mientras no ha recorrido todas las posiciones y hay enemigos por alcanzar
			
			  while (ic < enemiesc.length) {//controlamos movimiento de los Capitanes Galaga con cambio de imagen
			  	enemiesc[ic].setX(enemiesc[ic].getX() + velocidad);
			  	while (kc <= ic) {	
			  		if (enemiesc[kc].getImage().equals("enemy1G0.png")) {//control del cambio de imagen cuando NO han sido alcanzados por un torpedo
						 enemiesc[ic].setImage("enemy1G1.png");
						 enemiesc[kc].getGui().gb_setSpriteImage(enemiesc[kc].getId(), enemiesc[kc].getImage());
					}
					else 
						if (enemiesc[kc].getImage().equals("enemy1G1.png")) {//control del cambio de imagen cuando han sido alcanzados por un torpedo
							enemiesc[ic].setImage("enemy1G0.png");
							enemiesc[kc].getGui().gb_setSpriteImage(enemiesc[kc].getId(),enemiesc[kc].getImage());
						}
						else
					  		if (enemiesc[kc].getImage().equals("enemy9G0.png")) {
								enemiesc[ic].setImage("enemy9G1.png");
								enemiesc[kc].getGui().gb_setSpriteImage(enemiesc[kc].getId(),enemiesc[kc].getImage());
							}
					  		else
					  			if (enemiesc[kc].getImage().equals("enemy9G1.png")) {
									enemiesc[ic].setImage("enemy9G0.png");
									enemiesc[kc].getGui().gb_setSpriteImage(enemiesc[kc].getId(),enemiesc[kc].getImage());
								}
					kc++;
					
				}
			  		enemiesc[ic].getGui().gb_moveSpriteCoord(enemiesc[ic].getId(), enemiesc[ic].getX()%(10*16), enemiesc[ic].getY());//movimiento en horizontal de los Capitanes Galaga
				ic++;
			}	
				ic = 0;
				kc = 0;
				Thread.sleep(1000/30);	
			
			
			  while (ig < enemiesg.length) {// controlamos movimiento de los enemigos Goei con cambio de imagen
				enemiesg[ig].setX(enemiesg[ig].getX() + velocidad);
				  while (kg <= ig) {
					if (enemiesg[kg].getImage().equals("enemy2G0.png")) {//control del cambio de imagen
						enemiesg[ig].setImage("enemy2G1.png");
						enemiesg[kg].getGui().gb_setSpriteImage(enemiesg[kg].getId(), enemiesg[kg].getImage());
					}
					else 
						if (enemiesg[kg].getImage().equals("enemy2G1.png")) {
							enemiesg[ig].setImage("enemy2G0.png");
							enemiesg[kg].getGui().gb_setSpriteImage(enemiesg[kg].getId(),enemiesg[kg].getImage());
						}
					kg++;
				}
					enemiesg[ig].getGui().gb_moveSpriteCoord(enemiesg[ig].getId(), enemiesg[ig].getX()%(10*16), enemiesg[ig].getY());//movimiento en horizontal de los enemigos Goei
				ig++;
			}
			
				ig = 0;
				kg = 0;
				Thread.sleep(1000/30);
			
			
			  while (iz< enemiesz.length) {//controlamos el movimiento de los enemigos Zako con cambio de imagen
				enemiesz[iz].setX(enemiesz[iz].getX() + velocidad);
				while (kz <= iz) {
					if (enemiesz[kz].getImage().equals("enemy3G0.png")) {//control del cambio de imagen
						enemiesz[iz].setImage("enemy3G1.png");
						enemiesz[kz].getGui().gb_setSpriteImage(enemiesz[kz].getId(), enemiesz[kz].getImage());
					}
					else 
						if (enemiesz[kz].getImage().equals("enemy3G1.png")) {
							enemiesz[iz].setImage("enemy3G0.png");
							enemiesz[kz].getGui().gb_setSpriteImage(enemiesz[kz].getId(),enemiesz[kz].getImage());
						}
						kz++;
				}
					enemiesz[iz].getGui().gb_moveSpriteCoord(enemiesz[iz].getId(), enemiesz[iz].getX()%(10*16), enemiesz[iz].getY());//movimiento en horizontal de los enemigos Zako
					iz++;
			}
				iz = 0;
				kz = 0;
				Thread.sleep(1000/30);
			
			j++;
			
			switch(jugador.getGui().gb_getLastAction()) {//switch para controlar las acciones del jugador(moverse a la izquierda/derecha y disparar torpedos)
					case "right": {//movimiento de nave a la derecha
						if (jugador.getX()+ 3 <= 160) {
							jugador.setX(jugador.getX()+3);
							jugador.getGui().gb_moveSpriteCoord(jugador.getId(),jugador.getX(), jugador.getY());
						}
						break;
					}
					case "left": {//movimiento de nave a la izquierda
						if (jugador.getX()-3 >= 5) {
							jugador.setX(jugador.getX()-3);
							jugador.getGui().gb_moveSpriteCoord(jugador.getId(),jugador.getX(), jugador.getY());
						}
						break;
					}
					case "space": {//disparo de torpedos de la nave
						alcanzado = false;
						torpedo.setX(jugador.getX());
						torpedo.setY(jugador.getY());
						torpedo.gui.gb_setSpriteVisible(torpedo.getId(),true);
						jugador.setNdisparos(jugador.getNdisparos()+1);
						jugador.gui.gb_setValueAbility1(jugador.getNdisparos());
						if (velocidad < 0)
							velocidad1 = -velocidad;
							else
								velocidad1 = velocidad;
						while (!alcanzado && torpedo.getY() >= 10) {//controlamos como debe avanzar el torpedo en funcion de si ha alcanzado o no a un enemigo y si ha llegado al limite de la interfaz de juego
							torpedo.setY(torpedo.getY() - velocidad1*27);
							torpedo.getGui().gb_moveSpriteCoord(torpedo.getId(),torpedo.getX(), torpedo.getY());
							
							alcanzado = false;
							i = 0;
							while (!alcanzado && i < enemiesz.length) {//controlamos si el jugador ha alcanzado a algun Zako, haciendo invisible al enemigo y dando los puntos y aciertos correspondientes al jugador 
								if (enemiesz[i].getHealth() > 0 && Math.abs(enemiesz[i].getX() - torpedo.getX()) < 15 && Math.abs(enemiesz[i].getY() - torpedo.getY()) < 15) { 
									alcanzado = true;
									enemiesz[i].gui.gb_setSpriteVisible(enemiesz[i].getId(), false);
									torpedo.gui.gb_setSpriteVisible(torpedo.getId(),false);
									enemiesz[i].setHealth(enemiesz[i].getHealth()-1);
									jugador.setNaciertos(jugador.getNaciertos()+1);
									jugador.gui.gb_setValueAbility2(jugador.getNaciertos());
									jugador.setPlayerpts(jugador.getPlayerpts()+enemiesz[i].getReward());
									jugador.gui.gb_setValuePointsUp(jugador.getPlayerpts());
									jugador.gui.gb_println("Has alcanzado un enemigo Zako. ¡¡¡Enhorabuena!!!");
								}
								i++;
							}
							
							i = 0;
							while (!alcanzado && i < enemiesg.length) {//controlamos si el jugador ha alcanzado a algun enemigo Goei, haciendolo invisible y aumentando los puntos y el número de aciertos 
								if (enemiesg[i].getHealth() > 0 && Math.abs(enemiesg[i].getX() - torpedo.getX()) < 15 && Math.abs(enemiesg[i].getY() - torpedo.getY()) < 15) { 
									alcanzado = true;
									enemiesg[i].gui.gb_setSpriteVisible(enemiesg[i].getId(), false);
									torpedo.gui.gb_setSpriteVisible(torpedo.getId(),false);
									enemiesg[i].setHealth(enemiesg[i].getHealth()-1);
									jugador.setNaciertos(jugador.getNaciertos()+1);
									jugador.gui.gb_setValueAbility2(jugador.getNaciertos());
									jugador.setPlayerpts(jugador.getPlayerpts()+enemiesg[i].getReward());
									jugador.gui.gb_setValuePointsUp(jugador.getPlayerpts());
									jugador.gui.gb_println("Has alcanzado un enemigo Goei. ¡¡¡Enhorabuena!!!");
								}
								i++;
							}
							
							i = 0;
							while (!alcanzado && i < enemiesc.length) {//controlamos si el jugador ha alcanzado a algun Capitan Galaga, haciendo invisible al enemigo y dando los puntos y aciertos correspondientes al jugador
								if (enemiesc[i].getHealth() > 0 && Math.abs(enemiesc[i].getX() - torpedo.getX()) < 10 && Math.abs(enemiesc[i].getY() - torpedo.getY()) < 10) { 
									alcanzado = true;
									enemiesc[i].setHealth(enemiesc[i].getHealth()-1);
									if (enemiesc[i].getHealth() == 1) {
										enemiesc[i].gui.gb_setSpriteVisible(enemiesc[i].getId(), false);	
										if (enemiesc[i].getImage().equals("enemy1G0.png"))//controlamos que se ha alcanzado por primera vez al Capitan Galaga cambiando su sprite por el de color morado(enemy9G0.png y enemy9G1.png)
											enemiesc[i].setImage("enemy9G0.png");
										else 
											enemiesc[i].setImage("enemy9G1.png");
										enemiesc[i].getGui().gb_setSpriteImage(enemiesc[i].getId(),enemiesc[i].getImage());
										enemiesc[i].gui.gb_setSpriteVisible(enemiesc[i].getId(), true);
									}
									torpedo.gui.gb_setSpriteVisible(torpedo.getId(),false);
									jugador.setPlayerpts(jugador.getPlayerpts()+enemiesc[i].getReward());
									jugador.gui.gb_setValuePointsUp(jugador.getPlayerpts());
									jugador.gui.gb_println("Capitán Galaga tocado, te queda un disparo para eliminarle. ¡¡¡Enhorabuena!!!");
									
								}
								if (alcanzado && enemiesc[i].getHealth() == 0) {//como la vida del Capitan Galaga es el doble que la  del resto de enemigos, los aciertos se suman cuando ha sido eliminado por completo (2 vidas)
									enemiesc[i].gui.gb_setSpriteVisible(enemiesc[i].getId(), false);
									jugador.setNaciertos(jugador.getNaciertos()+1);
									jugador.gui.gb_setValueAbility2(jugador.getNaciertos());
									jugador.gui.gb_println("Has alcanzado un Capitán Galaga. ¡¡¡Enhorabuena!!!");
								}
								i++;
							}
							
							
							Thread.sleep(1000/30);
						}
						torpedo.gui.gb_setSpriteVisible(torpedo.getId(),false);
						if (!alcanzado)//aviso en la consola cuando el jugador no ha alcanzado a ningun enemigo al disparar
							jugador.gui.gb_println("Mala puntería, no has alcanzado a ningún enemigo. ¡¡¡Sigue intentándolo!!!");
						
						//controlamos el avance de nivel cuando el numero de enemigos totales del nivel coincide con el de aciertos del jugador
						//para ello realizamos unos ajustes para que al numero de aciertos totales del jugador almacenados se le resten los de los anteriores niveles para que el programa pueda avanzar de nivel
						if (jugador.getNivel() == 1)
							num_alcanzados = jugador.getNaciertos();
						else 
							if (jugador.getNivel() == 2)
								num_alcanzados = jugador.getNaciertos() - Conf.NUMENEMIGOS[0];
							else 
								num_alcanzados = jugador.getNaciertos() - (Conf.NUMENEMIGOS[0] + Conf.NUMENEMIGOS[1]);
						if (num_alcanzados == Conf.NUMENEMIGOS[nivel-1]) {//controlamos el avance de nivel, se pasa si coincide el numero de enemigos alcanzados con el numero de enemigos de ese nivel
							jugador.setNivel(jugador.getNivel()+1);
							acabar = true;
						}
							
						break;
					}
					
				}
		}
}
	
}
