package trabajofinal;

public class Conf {
	public static final int WIDTH = 17;
	public static final int HEIGHT = 22;

	public final int DIR_N = 0;
	public final int DIR_NNE = 1;
	public final int DIR_NE = 2;
	public final int DIR_ENE = 3;
	public final int DIR_E = 4;
	public final int DIR_ESE = 5;
	public final int DIR_SE = 6;
	public final int DIR_SSE = 7;
	public final int DIR_S = 8;
	public final int DIR_SSW = 9;
	public final int DIR_SW = 10;
	public final int DIR_WSW = 11;
	public final int DIR_W = 12;
	public final int DIR_WNW = 13;
	public final int DIR_NW = 14;
	public final int DIR_NNW = 15;
	
	public static final int[][] MOVECGALAGA = {//"x" e "y" movimiento en circulo Capitan Galaga (16 posiciones – una por imagen)
		     		{0,-10}, 
					{4,-10},
					{8,-7},
					{10,-4},
					{10, 0},
					{10,4},
					{8,7},
					{4,10},
					{0, 10},
					{-4,10},
					{-8,7},
					{-10,4},
					{-10, 0},
					{-10,-4},
					{-8,-7},
					{-4,-10},
	};
	
	public static final int[][] MOVECIRCULO = {//"x" e "y" movimiento en circulo Goei (16 posiciones – una por imagen), circulo mas grande porque hay mas enemigos de este tipo
			{0,-18}, 
			{8,-17},
			{13,-12},
			{17,-6},
			{18, 0},
			{17,6},
			{13,12},
			{8,17},
			{0, 18},
			{-8,17},
			{-13,12},
			{-17,6},
			{-18, 0},
			{-17,-6},
			{-13,-12},
			{-8,-17},
	};
	
	// posicion para entrada Capitan Galaga
	public static final int[][] POSICIONNCGALAGA = { 
			{42,128}, {34,68,102,136}, {24,48,72,96,120,144}
	};
	
	public static final int[] NUMENEMIGOS = {28,43,58};//numero de enemigos por nivel (vamos a tener hasta 3 niveles)
	
	// matriz irregular par la posicion x para la entrada de los enemigos GOEI y ZAKO segun el NIVEL (2 grupos en N1, 3 en N2 y 4 en N3)
	public static final int[][] POSICIONN = { 
			{42,128}, {42,85,128}, {34,68,102,136}
	};
	
	
	public static final String[] IMGCGALAGA = {//imagenes Capitan Galaga
			"enemy100.png", "enemy101.png", "enemy102.png", "enemy103.png", "enemy104.png", 
			"enemy105.png", "enemy106.png", "enemy107.png", "enemy108.png", "enemy109.png",
			"enemy110.png", "enemy111.png", "enemy112.png","enemy113.png", "enemy114.png", "enemy115.png"
	};
	
	public static final String[] IMGGOEI = {//imagenes enemigos Goei
			"enemy200.png", "enemy201.png", "enemy202.png", "enemy203.png", "enemy204.png", 
			"enemy205.png", "enemy206.png", "enemy207.png", "enemy208.png", "enemy209.png",
			"enemy210.png", "enemy211.png", "enemy212.png","enemy213.png", "enemy214.png", "enemy215.png"
	};
	public static final String[] IMGZAKO = {//imagenes enemigos Zako
			"enemy300.png", "enemy301.png", "enemy302.png", "enemy303.png", "enemy304.png", 
			"enemy305.png", "enemy306.png", "enemy307.png", "enemy308.png", "enemy309.png",
			"enemy310.png", "enemy311.png", "enemy312.png","enemy313.png", "enemy314.png", "enemy315.png"
	};
	
}

