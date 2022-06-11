package cl.acarrillanca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cl.acarrillanca.model.CategoriaEnum;
import cl.acarrillanca.model.Cliente;
import cl.acarrillanca.utility.Utilidad;
import cl.acarrillanca.view.Menu;

public class ClienteServicio {
	private Scanner sc = new Scanner(System.in);
	private String opcion = "";

	private List<Cliente> listaClientes;

	public ClienteServicio() {
		listaClientes = new ArrayList<Cliente>();
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListarClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void listarClientes() {

		if (!listaClientes.isEmpty() && listaClientes != null) {
			int i = 1;
			for (Cliente clienteTemp : listaClientes) {
				Utilidad.mostrarMensajes("------------------------");
				Utilidad.mostrarMensajes("-   DETALLE CLIENTE " + i +"  -");
				Utilidad.mostrarMensajes("------------------------");
					
				Utilidad.mostrarMensajes("RUT del Cliente " + clienteTemp.getRutCliente());
				Utilidad.mostrarMensajes("Nombre del Cliente " + clienteTemp.getNombreCliente());
				Utilidad.mostrarMensajes("Apellido del Cliente " + clienteTemp.getApellidoCliente());
				Utilidad.mostrarMensajes("Años como Cliente " + clienteTemp.getAniosCliente());
				Utilidad.mostrarMensajes("Categoria del Cliente " + clienteTemp.getNombreCategoria());
				i += 1;
			}
		} else {
			Utilidad.mostrarMensajes("---------------------------");
			Utilidad.mostrarMensajes("- Lista de Clientes Vacia -");
			Utilidad.mostrarMensajes("---------------------------");
		}

	}

	public void agregarCliente(Cliente cliente) {
		listaClientes.add(cliente);
		Utilidad.mostrarMensajes("-----------------------");
		Utilidad.mostrarMensajes("-  CLIENTE AGREGADO   -");
		Utilidad.mostrarMensajes("-----------------------");
	}

	public void buscarCliente(String rut) {

		boolean encontrado = false;

		if (!listaClientes.isEmpty() && listaClientes != null) {
			for (Cliente clienteTemp : listaClientes) {
				if (clienteTemp.getRutCliente().equals(rut)) {

					encontrado = true;

					Utilidad.mostrarMensajes("--------------------------------------------------");
					Utilidad.mostrarMensajes("- USUARIO RUT: " + clienteTemp.getRutCliente() + " ENCONTRADO");
					Utilidad.mostrarMensajes(
							"- " + clienteTemp.getNombreCliente() + " " + clienteTemp.getApellidoCliente() + " -");
					Utilidad.mostrarMensajes("--------------------------------------------------");
					Utilidad.mostrarMensajes("---------------------------------");
					Utilidad.mostrarMensajes("- Seleccione lo que desea hacer -");
					Utilidad.mostrarMensajes("---------------------------------");
					Utilidad.mostrarMensajes("- 1. Cambiar Estado de Cliente  -");
					Utilidad.mostrarMensajes("- 2. Editar Datos de Cliente    -");
					Utilidad.mostrarMensajes("- 3. Salir a Menu anterior      -");
					Utilidad.mostrarMensajes("-                               -");
					Utilidad.mostrarMensajes("- Ingrese Opción :              -");
					Utilidad.mostrarMensajes("---------------------------------");

					do {
						opcion = sc.nextLine();

						switch (opcion) {
						case "1":
							editarEstado(clienteTemp);
							break;
						case "2":
							editarDatos(clienteTemp);
							break;
						case "3":
							Menu.getInstance().iniciarMenu();
							break;
						default:
							Utilidad.mostrarMensajes("-------------------------");
							Utilidad.mostrarMensajes("- INGRESE OPCION VALIDA -");
							Utilidad.mostrarMensajes("-------------------------");
							break;
						}

					} while (!opcion.equals("3"));

				}

			}

			if (!encontrado) {
				Utilidad.mostrarMensajes("---------------------------");
				Utilidad.mostrarMensajes("-    USUARIO NO EXISTE    -");
				Utilidad.mostrarMensajes("---------------------------");
			}

		} else {
			Utilidad.mostrarMensajes("---------------------------");
			Utilidad.mostrarMensajes("- Lista de Clientes Vacia -");
			Utilidad.mostrarMensajes("---------------------------");
		}

	}

	public void editarEstado(Cliente clienteTemp) {

		do {

			Utilidad.mostrarMensajes("---------------------------------");
			Utilidad.mostrarMensajes("-   Modificar Estado Cliente RUT : " + clienteTemp.getRutCliente());
			Utilidad.mostrarMensajes("---------------------------------");
			Utilidad.mostrarMensajes("- El estado del cliente es : " + clienteTemp.getNombreCategoria());
			Utilidad.mostrarMensajes("---------------------------------");
			Utilidad.mostrarMensajes("- 1. Setear a Estado ACTIVO     -");
			Utilidad.mostrarMensajes("- 2. Setear a Estado INACTIVO   -");
			Utilidad.mostrarMensajes("- 3. Salir a Menu anterior      -");
			Utilidad.mostrarMensajes("- 4. Salir a Menu inicial       -");
			Utilidad.mostrarMensajes("-                               -");
			Utilidad.mostrarMensajes("- Ingrese Opción :              -");
			Utilidad.mostrarMensajes("---------------------------------");

			opcion = sc.nextLine();

			switch (opcion) {
			case "1":
				clienteTemp.setNombreCategoria(CategoriaEnum.ACTIVO);
				break;
			case "2":
				clienteTemp.setNombreCategoria(CategoriaEnum.INACTIVO);
				break;
			case "3":
				buscarCliente(clienteTemp.getRutCliente());
				break;
			case "4":
				Menu.getInstance().iniciarMenu();
				break;
			default:
				Utilidad.mostrarMensajes("-------------------------");
				Utilidad.mostrarMensajes("- INGRESE OPCION VALIDA -");
				Utilidad.mostrarMensajes("-------------------------");
				break;
			}

		} while (!opcion.equals("4"));

	}
	
	public void editarDatos(Cliente clienteTemp) {

		do {

			Utilidad.mostrarMensajes("---------------------------------");
			Utilidad.mostrarMensajes("-   Modificar Datos Cliente     -");
			Utilidad.mostrarMensajes("---------------------------------");
			Utilidad.mostrarMensajes("- 1. Modificar RUT: " + clienteTemp.getRutCliente());
			Utilidad.mostrarMensajes("- 2. Modificar Nombre: " + clienteTemp.getNombreCliente());
			Utilidad.mostrarMensajes("- 3. Modificar Apellido: " + clienteTemp.getApellidoCliente());
			Utilidad.mostrarMensajes("- 4. Modificar Años como Cliente: " + clienteTemp.getAniosCliente());
			Utilidad.mostrarMensajes("- 5. Salir a Menu anterior      -");
			Utilidad.mostrarMensajes("- 6. Salir a Menu inicial       -");
			Utilidad.mostrarMensajes("-                               -");
			Utilidad.mostrarMensajes("- Ingrese Opción :              -");
			Utilidad.mostrarMensajes("---------------------------------");

			opcion = sc.nextLine();

			switch (opcion) {
			case "1":
				Utilidad.mostrarMensajes("Ingrese Nuevo RUT");
				clienteTemp.setRutCliente(Utilidad.validar(sc));
				break;
			case "2":
				Utilidad.mostrarMensajes("Ingrese Nuevo Nombre");
				clienteTemp.setNombreCliente(Utilidad.validar(sc));
				break;
			case "3":
				Utilidad.mostrarMensajes("Ingrese Nuevo Apellido");
				clienteTemp.setApellidoCliente(Utilidad.validar(sc));
				break;
			case "4":
				Utilidad.mostrarMensajes("Ingrese Cantidad de años como cliente");
				clienteTemp.setAniosCliente(Utilidad.validar(sc));
				break;
			case "5":
				buscarCliente(clienteTemp.getRutCliente());
				break;
			case "6":
				Menu.getInstance().iniciarMenu();
				break;
			default:
				Utilidad.mostrarMensajes("-------------------------");
				Utilidad.mostrarMensajes("- INGRESE OPCION VALIDA -");
				Utilidad.mostrarMensajes("-------------------------");
				break;
			}

		} while (!opcion.equals("6"));

	}

}
