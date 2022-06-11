package cl.acarrillanca.view;

import java.util.Scanner;

import cl.acarrillanca.model.CategoriaEnum;
import cl.acarrillanca.model.Cliente;
import cl.acarrillanca.service.ArchivoServicio;
import cl.acarrillanca.service.ClienteServicio;
import cl.acarrillanca.service.ExportadorCsv;
import cl.acarrillanca.service.ExportadorTxt;
import cl.acarrillanca.utility.Utilidad;

public class Menu {

	private static final Menu menu = new Menu();
	private Scanner sc = new Scanner(System.in);
	private String opcion = "";
	private ClienteServicio clienteServicio = new ClienteServicio();
	private ArchivoServicio archivoServicio = new ArchivoServicio();
	private ExportadorCsv exportadorCsv = new ExportadorCsv();
	private ExportadorTxt exportadorTxt = new ExportadorTxt();

	private Menu() {
	}

	public static Menu getInstance() {
		return menu;
	}

	public void iniciarMenu() {
		
		do {
//			1. Listar Clientes
//			2. Agregar Cliente
//			3. Editar Cliente
//			4. Cargar Datos
//			5. Exportar Datos
//			6. Salir
//			Ingrese una opción:
			Utilidad.limpiarPantalla();

			Utilidad.mostrarMensajes("-----------------------");
			Utilidad.mostrarMensajes("-       M E N U       -");
			Utilidad.mostrarMensajes("-----------------------");
			Utilidad.mostrarMensajes("- 1. Listar Clientes  -");
			Utilidad.mostrarMensajes("- 2. Agregar Cliente  -");
			Utilidad.mostrarMensajes("- 3. Editar Cliente   -");
			Utilidad.mostrarMensajes("- 4. Importar Datos   -");
			Utilidad.mostrarMensajes("- 5. Exportar Datos   -");
			Utilidad.mostrarMensajes("- 6. Salir            -");
			Utilidad.mostrarMensajes("-----------------------");
			Utilidad.mostrarMensajes("- Ingrese Opción:     -");
			Utilidad.mostrarMensajes("-----------------------");

			opcion = sc.nextLine();

			switch (opcion) {
			case "1":
				listarClientes();
				break;
			case "2":
				agregarCliente();
				break;
			case "3":
				editarCliente();
				break;
			case "4":
				cargarDatos();
				break;
			case "5":
				exportarDatos();
				break;
			case "6":
				terminarPrograma();
				break;
			default:
				Utilidad.mostrarMensajes("-------------------------");
				Utilidad.mostrarMensajes("- INGRESE OPCION VALIDA -");
				Utilidad.mostrarMensajes("-------------------------");
				break;
			}

		} while (!opcion.equals("6"));
	}

	public void listarClientes() {
		Utilidad.mostrarMensajes("------------------------");
		Utilidad.mostrarMensajes("-    LISTA CLIENTES    -");
		Utilidad.mostrarMensajes("------------------------");

		clienteServicio.listarClientes();

	};

	public void agregarCliente() {

		Cliente cliente = new Cliente();

		Utilidad.mostrarMensajes("-----------------------");
		Utilidad.mostrarMensajes("-   AGREGAR CLIENTE   -");
		Utilidad.mostrarMensajes("-----------------------");

		Utilidad.mostrarMensajes("Ingresa RUT del Cliente : ");
		cliente.setRutCliente(Utilidad.validar(sc));
		Utilidad.mostrarMensajes("Ingresa Nombre del Cliente : ");
		cliente.setNombreCliente(Utilidad.validar(sc));
		Utilidad.mostrarMensajes("Ingresa Apellido del Cliente : ");
		cliente.setApellidoCliente(Utilidad.validar(sc));
		Utilidad.mostrarMensajes("Ingresa años como Cliente : ");
		cliente.setAniosCliente(Utilidad.validar(sc));
		cliente.setNombreCategoria(CategoriaEnum.ACTIVO);

		Utilidad.mostrarMensajes("--------------------------------");

		clienteServicio.agregarCliente(cliente);

	};

	public void editarCliente() {
		Utilidad.mostrarMensajes("-----------------------");
		Utilidad.mostrarMensajes("-    EDITAR CLIENTE   -");
		Utilidad.mostrarMensajes("-----------------------");

		Utilidad.mostrarMensajes("Ingresa RUT del Cliente : ");
		clienteServicio.buscarCliente(Utilidad.validar(sc));

	};

	public void cargarDatos() {
		Utilidad.mostrarMensajes("-----------------------");
		Utilidad.mostrarMensajes("-    CARGAR DATOS     -");
		// Utilidad.mostrarMensajes("- EN LINUX O MAC -");
		Utilidad.mostrarMensajes("-----------------------");
		Utilidad.mostrarMensajes("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
		Utilidad.mostrarMensajes("Ejemplo: carpeta/DBClientes.csv");

		String ruta = Utilidad.validar(sc);
		clienteServicio.getListaClientes().addAll(archivoServicio.cargarDatos(ruta));
	};

	public void exportarDatos() {
		
		Utilidad.mostrarMensajes("-----------------------");
		Utilidad.mostrarMensajes("-   EXPORTAR DATOS    -");
		Utilidad.mostrarMensajes("-----------------------");
		System.out.println("# Ingrese el nombre de la carpeta para exportar el archivo # ");
		String ruta = Utilidad.validar(sc);
		
		while (!opcion.equals("1") || opcion.equals("2")) {
			Utilidad.mostrarMensajes("-----------------------");
			Utilidad.mostrarMensajes("-   EXPORTAR DATOS     -");
			// Utilidad.mostrarMensajes("- EN LINUX O MAC -");
			Utilidad.mostrarMensajes("-----------------------");
			Utilidad.mostrarMensajes(" Seleccione formato a exportar:");
			Utilidad.mostrarMensajes("- 1. TXT              -");
			Utilidad.mostrarMensajes("- 2. CSV              -");
			Utilidad.mostrarMensajes("- 3. Volver al Menu   -");
			Utilidad.mostrarMensajes("-----------------------");

			opcion = sc.nextLine();
			
			switch (opcion) {
			case "1":
				exportadorTxt.exportar(ruta, clienteServicio.getListaClientes());
				break;
			case "2":
				exportadorCsv.exportar(ruta, clienteServicio.getListaClientes());
				break;
			case "3":
				editarCliente();
				break;
			default:
				Utilidad.mostrarMensajes("-------------------------");
				Utilidad.mostrarMensajes("- INGRESE OPCION VALIDA -");
				Utilidad.mostrarMensajes("-------------------------");
				break;
			}
					
		} while (!opcion.equals("3"));

	};

	public void terminarPrograma() {
		Utilidad.mostrarMensajes("Saliendo del Programa ....");
		System.exit(0);
	};

}
