package trabajofinal;

import edu.uc3m.game.GameBoardGUI;

public class MiniGalagav2 {

	public static void main(String[] args) throws InterruptedException {
		int y;
		int nivel = 1;
		int velocidad = 1;
		boolean jug_vivo = true;
		int i=0, j =0, k= 0, l= 0, m = 0, fila=0, vuelta=0, crear = 0, aciertos = 0;
	
		
		GameBoardGUI gui = new GameBoardGUI(17, 22);
		//color y creación del área de juego
		gui.gb_repaintBoard();
		gui.setVisible(true);
		for (i = 0; i < Conf.WIDTH; i++) {
			for (j = 0; j < Conf.HEIGHT; j++) 
				gui.gb_setSquareColor(i, j, 0, 0, 0);
			gui.gb_setGridColor(0, 0, 0);
		}

		Jugador jugador = new Jugador(3, 3, 0, nivel, velocidad, 0, 0, 777, 85, 210, gui); //creamos jugador
		jugador.setGui(gui);
		jugador.getGui();

		Torpedo torpedo = new Torpedo(500, 11, 210, gui);//creamos torpedo
		torpedo.setGui(gui);
		torpedo.getGui();
		
		while (nivel <= 3 && jug_vivo) {//controla el numero de nivel (hasta 3) y si el estatus del jugador es "vivo"
			
			jugador.gui.gb_setValueLevel(jugador.getNivel());
			EnemyCGalaga enemiesc[] = new EnemyCGalaga[nivel * 2]; //definición dimensión Capitan Galaga en función del nivel
			EnemyGoei enemiesg[] = new EnemyGoei[5 * (nivel + 1)]; //definición dimensión Goei en función del nivel
			EnemyZako enemiesz[] = new EnemyZako[8 * (nivel + 1)]; //definición dimensión Zako en función del nivel
	
			//Entrada Capitanes Galaga
			
			vuelta = 0; //variable para las vueltas de presentación  
			y = 30; //coordenada inicial y para los Capitanes Galaga
			l = 0;
			while (vuelta < 3) { //entrada Capitan Galaga
				
				if (vuelta == 0) {
					k = 1;
					for (l = 0; l < enemiesc.length; l++) {//creación y primera posición de los Capitanes Galaga
						enemiesc[l] = new EnemyCGalaga(); 
						enemiesc[l].entradacgalaga(enemiesc[l], Conf.MOVECGALAGA[0][0]+Conf.POSICIONNCGALAGA[nivel-1][k-1], Conf.MOVECGALAGA[0][1]+y,Conf.IMGCGALAGA[0], l);
						enemiesc[l].setGui(gui);
						enemiesc[l].getGui();
						k++;
					}
				}
				
				for (i = 0; i < 16; i++) {//movimiento en circulo con cambio de imagen de los Capitanes Galaga
					k = 1;
					l = 0;
					while (k <= nivel*2) {
			
						enemiesc[l].gui.gb_setSpriteVisible(enemiesc[l].getId(), false);
						enemiesc[l].mover(enemiesc[l], Conf.MOVECGALAGA[i][0]+Conf.POSICIONNCGALAGA[nivel-1][k-1], Conf.MOVECGALAGA[i][1]+y,Conf.IMGCGALAGA[i]);//Conf.POSICIONNCGALAGA = “x” de los Capitanes Galaga por nivel, Conf.MOVECGALAGA = posición en el círculo en todos los movimientos
					    if (nivel == 3)
					    	Thread.sleep(5);
					    else
					    	Thread.sleep(10);
						k++;
						l++;
				        }
				}
				vuelta = vuelta+1;
				if (vuelta == 3) //hacemos invisibles a los Capitanes Galaga cuando han dado las 3 vueltas de presentacion
					for (i = 0; i < enemiesc.length; i++) {
						enemiesc[i].gui.gb_setSpriteVisible(enemiesc[i].getId(), false);
					}
			}
			
			//Entrada enemigos Goei		
			
			l = 0;
			vuelta = 0; //vueltas de presentación 
			i = 0;
			crear = 0;
			int [][] fila_cfg = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
			
			while (vuelta < 8) {
					while (i < 5) {
						y = 160; //coordenada inicial y para los enemigos Goei
						if (crear == 5) //control de la agrupación de enemigos Goei (filas de 5 Goei)
							m=5;
						else
							m=i;
						j = 0;
						l = j;
						
						while (j < m) {
							k = 1;
							l = j;
							
							while (k <= nivel+1) {//movimiento en circulo con cambio de imagen de los enemigos Goei
								if (fila_cfg[k-1][j] == 15) { //fila_cfg = matriz irregular para control de la posición en la que está el enemigo en una vuelta (filas = niveles y columnas = número de última posición del Goei)
									fila_cfg[k-1][j] = 0;
									fila = fila_cfg[k-1][j];
									
								}
								else {
								    fila_cfg[k-1][j] = fila_cfg[k-1][j] + 1;
								    fila = fila_cfg[k-1][j];
								}
								enemiesg[l].gui.gb_setSpriteVisible(enemiesg[l].getId(), false);
								enemiesg[l].mover(enemiesg[l], Conf.MOVECIRCULO[fila][0]+Conf.POSICIONN[nivel-1][k-1], Conf.MOVECIRCULO[fila][1]+y,Conf.IMGGOEI[fila]);//Conf.POSICIONN= “x” de los enemigos Goei por nivel, Conf.MOVECIRCULO = posición en el círculo de los Goei
							    Thread.sleep(5);
								k++;
								l = l+5;
						        }
						j++;	
						}
						
						k = 1;
						l = i;
						while (k <= nivel+1 && crear <5) {//creación y primera posición de los enemigos Goei
		 				    enemiesg[l] = new EnemyGoei();
							enemiesg[l].entradagoei(enemiesg[l], Conf.MOVECIRCULO[0][0]+Conf.POSICIONN[nivel-1][k-1], Conf.MOVECIRCULO[0][1]+y,Conf.IMGGOEI[0], l);//Conf.POSICIONN= “x” de los enemigos Goei por nivel, Conf.MOVECIRCULO = = posición inicial en el círculo
							enemiesg[l].setGui(gui);
							enemiesg[l].getGui();
							k++;
							l = l+5;
						}
						if (crear < 5)
		 				  	crear++;  
		 				   i++;
					}
					
					i=0;
					vuelta = vuelta+1;
					if (vuelta == 8) {//hacemos invisibles a los enemigos Goei cuando han dado las 8 vueltas de presentacion
						for (i = 0; i < enemiesg.length; i++) {
							enemiesg[i].gui.gb_setSpriteVisible(enemiesg[i].getId(), false);
						}
					}
				}
			
			// Entrada enemigos Zako
			
			vuelta = 0; //variable vueltas de presentación 
			i = 0;
			y = 220; //coordenada inicial y para los enemigos Zako
			crear = 0;
			while (vuelta < 8) {
					while (i < 8) {
						if (crear == 8) //control de la agrupación de enemigos Zako filas de 8 Zako
							m=8;
						else
							m=i;
						j = 0;
						l = j;
						
						while (j< m) {
							k = 1;
							l = j;
							while (k <= nivel+1) {
								
								enemiesz[l].gui.gb_setSpriteVisible(enemiesz[l].getId(), false);
								if (enemiesz[l].getY() == 80 && (k == 1 || k == nivel+1)) {//movimiento vertical y en angulo recto con cambio de imagen de los enemigos Zako
										if (k == 1)
											enemiesz[l].mover(enemiesz[l], enemiesz[l].getX()-10, enemiesz[l].getY(),Conf.IMGZAKO[12]);//movimiento en ángulo recto hacia la izquierda
										else 
											enemiesz[l].mover(enemiesz[l], enemiesz[l].getX()+10, enemiesz[l].getY(),Conf.IMGZAKO[4]);//movimiento en ángulo recto hacia la derecha
									}
									else {
										enemiesz[l].mover(enemiesz[l], Conf.POSICIONN[nivel-1][k-1], enemiesz[l].getY()-10,enemiesz[l].getImage());//movimiento vertical
									}
							    Thread.sleep(1);
								k++;
								l = l+8;
						        }
						j++;	
						}
						k = 1;
						l = i;
						while (k <= nivel+1 && crear < 8) {//creación y primera posición de los enemigos Zako
		 				    enemiesz[l] = new EnemyZako();
							enemiesz[l].entradazako(enemiesz[l],Conf.POSICIONN[nivel-1][k-1], 200,Conf.IMGZAKO[0], l);
							enemiesz[l].setGui(gui);
							enemiesz[l].getGui();
							k++;
							l = l+8;
						}
						if (crear < 8)
		 				  	crear++;  
		 				   i++;
					}
					
					i=0;
					vuelta = vuelta+1;
				}
	
	
			Enjambre enjambrej = new Enjambre(enemiesz, enemiesg, enemiesc, nivel, gui); //creación del emjambre de enemigos una vez presentados 
	
			for (i = 0; i < enemiesc.length; i++) {//visibilidad de los Capitanes Galaga en el nivel
				enemiesc[i].setGui(gui);
				enemiesc[i].getGui();
	
			}
			
			for (i = 0; i < enemiesg.length; i++) {//visibilidad de los enemigos Goei en el nivel
				enemiesg[i].setGui(gui);
				enemiesg[i].getGui();
	
			}
	
			for (i = 0; i < enemiesz.length; i++) {//visibilidad de los enemigos Zako en el nivel
				enemiesz[i].setGui(gui);
				enemiesz[i].getGui();
			}
					
			while (jugador.getNaciertos()-aciertos < Conf.NUMENEMIGOS[nivel-1]) {//el juego acaba cuando se han alcanzado los enemigos de los 3 niveles
				enjambrej.moverenjambre(enemiesz, enemiesg, enemiesc, velocidad, jugador, torpedo); //movimiento lateral del enjambre hacia la derecha
				enjambrej.moverenjambre(enemiesz, enemiesg, enemiesc, (-velocidad), jugador, torpedo); //movimiento lateral del enjambre hacia la izquierda
			}
			jugador.gui.gb_println("¡¡¡ENHORABUENA, HAS PASADO DE NIVEL!!!");
			nivel++;
			aciertos = jugador.getNaciertos();
		}
		
		if (nivel == 4 && jug_vivo)//mensaje en pantalla indiando que el jugador ha ganado la partida si ha pasado los 3 niveles y sigue vivo
			jugador.gui.gb_showMessageDialog("¡¡¡ENHORABUENA, HAS GANADO LA PARTIDA!!!");
	}
}
