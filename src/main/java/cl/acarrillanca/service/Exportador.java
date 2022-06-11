package cl.acarrillanca.service;

import java.util.List;

import cl.acarrillanca.model.Cliente;

public abstract class Exportador {

/*	public Exportador() {

	}*/

	public abstract void exportar(String fileName, List<Cliente> listaClientes);
	
	
	
}
