package cl.acarrillanca.utility;

import java.util.Scanner;

public class Utilidad {
	
	public static void tiempoEspera() {
		
	}
	
	public static void limpiarPantalla() {
		try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
 
            if(operatingSystem.contains("Windows")){   
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();               		
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
	}
	
	public static void mostrarMensajes(String mensaje) {
		System.out.println(mensaje);
	}
	
	public static String validar (Scanner sc) {
		String dato = "";
		do {
			dato = sc.nextLine();
			if (dato.isEmpty()) {
				Utilidad.mostrarMensajes("Campo no puede estar vacio, ingrese el dato");
			}
		} while (dato.isEmpty());
		return dato;
	}
}
