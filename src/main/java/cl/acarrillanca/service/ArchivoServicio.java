package cl.acarrillanca.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import cl.acarrillanca.model.CategoriaEnum;
import cl.acarrillanca.model.Cliente;

public class ArchivoServicio {

	public ArrayList<Cliente> cargarDatos(String fileName) {
		
		File archivo = new File("src/" + fileName);

		ArrayList<Cliente> listaClientes = new ArrayList <Cliente>();
		
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			
			String linea = br.readLine();
			
			while (linea != null) {
				ArrayList<String> camposCliente = new ArrayList<String>(Arrays.asList(linea.split(",")));
				Cliente cliente = new Cliente ();
				
				cliente.setRutCliente(camposCliente.get(0));
				cliente.setNombreCliente(camposCliente.get(1));
				cliente.setApellidoCliente(camposCliente.get(2));
				cliente.setAniosCliente(camposCliente.get(3));
				if (camposCliente.get(4).equals("ACTIVO")) {
					cliente.setNombreCategoria(CategoriaEnum.ACTIVO);    
				} else {
					cliente.setNombreCategoria(CategoriaEnum.INACTIVO); 
				}
				
				listaClientes.add(cliente);
				
				linea = br.readLine();
				
			}
			br.close();
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Archivo importado correctamente");
		return listaClientes;	
	
		
	}
	
	
	
	
	
	
}
