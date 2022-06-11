package cl.acarrillanca.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import cl.acarrillanca.model.CategoriaEnum;
import cl.acarrillanca.model.Cliente;
import cl.acarrillanca.service.ClienteServicio;


public class ClienteServicioTest {
	
	private ClienteServicio clienteServicio = new ClienteServicio();
	
	@Test
	@DisplayName ("Test funcion agregarCliente comprobacion Lista creada")
	public void creacionListaTest (){
		Cliente cliente = new Cliente ("1-9","Alvaro","Alvarez","5",CategoriaEnum.ACTIVO);
		clienteServicio.agregarCliente(cliente);
		assertEquals(1, clienteServicio.getListaClientes().size());
	}
	
	@Test
	@DisplayName ("Test agregado correcto de ENUM ")
	public void probarEnumTest0 (){
		Cliente cliente = new Cliente ("1-9","Alvaro","Alvarez","5",CategoriaEnum.ACTIVO);
		clienteServicio.agregarCliente(cliente);
		assertEquals(CategoriaEnum.ACTIVO, clienteServicio.getListaClientes().get(0).getNombreCategoria());		
	}

	@Test
	@DisplayName ("verificar el funcionamiento de agregarCliente en caso que vengan casos nulos")
	public void agregarClienteNullTest() {
		Cliente cliente = null;
		clienteServicio.agregarCliente(cliente);
		assertNull(cliente);	
	}
	
}
