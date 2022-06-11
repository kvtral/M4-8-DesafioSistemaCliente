package cl.acarrillanca.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

import cl.acarrillanca.model.Cliente;
import cl.acarrillanca.view.Menu;


public class ExportadorTxt extends Exportador {

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		Scanner sc = new Scanner(System.in);
		
		crearDirectorio(fileName);
				
		fileName = "src/" + fileName + "/clientes.txt";

		crearArchivoYEscribir(fileName, listaClientes);
	}

	private static void crearDirectorio (String nombreDirectorio) {
		File directorio = new File ("src/" + nombreDirectorio);
		if (directorio.exists()) {
			System.out.println("Carpeta existe");
		} else {
			directorio.mkdir();
			System.out.println("Carpeta no existe, se creará");
		}
	}
	
	private static void crearArchivoYEscribir(String fileName, List<Cliente> listaClientes) {
		
		try {
    		Scanner sc = new Scanner(System.in);
        	File archivo = new File(fileName);
        	boolean sobrescribir = false;
        	FileWriter fw;
        	
			if (archivo.exists()) {
        		System.out.println ("Archivo " + fileName + " ya existe");
        		System.out.println ("**********************************************");
        		System.out.println ("* Puede sobrescribir archivo o agregar texto *");
        		System.out.println ("**********************************************");
        		System.out.println ("¿Desea sobrescribir archivo? (S/N)");
				char respuesta = sc.next().charAt(0);
        		sobrescribir = (respuesta != 'S') ? false : true ;
        	}
        	
        	if (sobrescribir) {
        		fw = new FileWriter(archivo);
        	} else {
        		fw = new FileWriter(archivo, true);
        	}
        	
        	BufferedWriter bw = new BufferedWriter(fw);
        	
        	for (Cliente clienteTemp: listaClientes) {
        		bw.write(clienteTemp.formateo());
        		bw.newLine();
        	}
            
			System.out.println("#################################");
			System.out.println("#       ARCHIVO EXPORTADO       #");
			System.out.println("#################################");
    		System.out.println ("Archivo : " + fileName);
    		
			bw.close();
			fw.close();
			
			Menu.getInstance().iniciarMenu();
		
		}catch (Exception e){
			System.out.println("Excepcion escibiendo fichero : " + e);
		}
	}
	
}
