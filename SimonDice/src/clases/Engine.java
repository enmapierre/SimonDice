package clases;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Engine {
	
	/**
	 * enum de tipo tColores
	 */
    public enum tColores {
        ROJO,
        VERDE,
        AZUL,
        DORADO
    }

    
    /**
     * variable constante.
     * private: la variable solo se puede acceder dentro de la clase en la que se define.
     * final:la variable no se puede cambiar una vez que se inicializa.
     * entero constante con valor de 12. 
     */
    private static final int MAX_COLORES_SEQ = 12;
    
    
    /**
     *una matriz de tipo tColores con una longitud de MAX_COLORES_SEQ (12).
     */
    private tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];
    
    
	/**
	 * metodo que recive un char y retorna un enum (color) de tipo tColores.
	 * @param _color
	 * @return
	 */
    public tColores charToColor(char _color) {

        char letraColor = Character.toLowerCase(_color); //mayusculas y minusculas

        switch (letraColor) {
            case 'r':
                 return tColores.ROJO;
            case 'v':
                return tColores.VERDE;
            case 'a':
                return tColores.AZUL;
            case 'd':
                return tColores.DORADO;
            default:
            	System.out.println("Color no encontrado.");
            	return null;
                
        }
        
    }
    
    
    /**
     * metodo que recive un numero y retorna un color (enum) de tipo tColores.
     * @param _numero
     * @return
     */
    public tColores intToColor(int _numero) {
        switch (_numero) {
            case 1:
                return tColores.ROJO;
            case 2:
                return tColores.VERDE;
            case 3:
                return tColores.AZUL;
            case 4:
                return tColores.DORADO;
            default:
            	System.out.println("Numero no encontrado.");
            	return null;
                
        }
       
    }
    
    
    /**
     * este metodo genera una secuencia de colores aleatoriamente y se guarda en el array secuenciaColores .
     * @param _numColores
     */
    public void generarSecuencia(int _numColores) {
        for (int i = 0; i < secuenciaColores.length; i++) {
            secuenciaColores[i] = intToColor((int) (Math.random() *_numColores +1));
        }
    }
    
    
    /**
     * metodo que comprueba el color introducido por el usuario, retorna un true o false.
     * @param _index
     * @param _color
     * @return
     */
    public boolean comprobarColor(int _index, tColores _color) {
    	if (secuenciaColores[_index]==_color) {
    		System.out.println("¡Buen trabajo! sigue asi.");
    		return true;
    		
    	}else {
    		System.out.println("¡Oh no! has perdido.");
    		return false;
    	}
    }
    
    
    /**
     * método que muestrar la secuencia actual por pantalla para que el usuario la pueda memorizar.
     * @param _numero
     */
    public void mostrarSecuencia (int _numero) {
    	Scanner sc = new Scanner(System.in);
    	
    	for (int i=0; i<_numero;i++) {
    		System.out.print(secuenciaColores[i]+ " ");
    	}
    	sc.nextLine();
    }
    
    
    /**
     * metodo menu, para guiar al jugador durante el juego, empezar juego o salir.
     * realmente la ejecucuion del menu se hace en el metodo play
     */
    public void menu() {
    	System.out.println("1......Jugar.");
    	System.out.println("2......Salir.");
            
    }

    
    /**
     *metodo mas importate, es el que ejecutara el juego, emepezamos imprimiendo por pantalla la bienvenida al jugador, registrando su nombre y mostrando el menu.
     *utilizamos un switch para dirigir el juego y al usuario, es el meu del juego, si pulsa 1 comienza a ejecutarse el juego y si pulsa 2 sale.
     *dentro del do ponemos lo que queremos que se reproduzca, se genera la secuencia de colores, con los 4 colores, muestra solo los 3 primeros numeros y "borra " la pantalla.
     *pedimos al usuario que ingrese la primera secuencia, y mientras el numero de secuencia no sea 10, el jugador seguiá jugando hasta ganar (problema de esta condicion es que si falla no se saldra del bucle).
     */
    public void play () {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Bienvenido a Simon Dice.");
    	System.out.println("Introduce tu nombre de usuario.");
    	String nombre= sc.nextLine();
    	System.out.println("Hola " + nombre + " pulsa enter para mostrar menu.");
    	sc.nextLine();
    	
    	int seleccion;
    	menu();
    	seleccion= sc.nextInt();
    	switch (seleccion) {
        case 1:
            
        	do {
        		generarSecuencia(4); 
        		int numeroSecuencia = 1;
        		System.out.println("Preparado " + nombre + "? " + "Memoriza la secuencia " + numeroSecuencia + " y pulsa enter para empezar.");
    	    	mostrarSecuencia(3);
    	    	for (int a = 0; a < 50; ++a) {
        	        System.out.println();
        	    }
    	    	
    			System.out.println("Ingresa la secuencia " +  numeroSecuencia);
    			
    			while(numeroSecuencia != 10) {
    				//sumatorio para las vueltas que da el bucle y asi saber en que ronda esta 
    				numeroSecuencia ++; 
    				//bucle for que utiliza el metodo comprobarColor, para ello necesita recoger el tipo chad introducido por el usuario y convertirlo en un tipo (objeto) tcolores ya que este metodo recive por parametro un tipo int y tipo tColores. 
	    			for (int j = 0; j <3 + numeroSecuencia -2 ; j++) {
		    	    	char secuenciaChar = new Scanner(System.in).next().charAt(0);
		    	    	tColores secuenciaUsuario = charToColor (secuenciaChar);
		    	    	comprobarColor(j, secuenciaUsuario);
		        	}
	    			//una vez comprobado el color y que este bien se muestra el siguiente color en el array, se "borra" pantalla, ingresas la secuencia nueva y asi sucesivamente hasta ganar.
	    			mostrarSecuencia(3 + numeroSecuencia -1);
	    			System.out.println();
	    			
	    			for (int a = 0; a < 50; ++a) {
	        	        System.out.println();
	        	     }
	    			System.out.println("Ingresa la secuencia "+ numeroSecuencia);
				}     
    	    	} while(seleccion != 2) ;
            
        case 2:
        	System.out.println("Adios! vuelve pronto:)");
             
    }
    	}
    
    
    /**
     * metodo que estara en la clase main metodo, que llama al metodo anterior play.
     */
    public void start() {
        Scanner sc = new Scanner(System.in);
        play();
    }
}




