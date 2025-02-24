import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        inicializar();
    }

    public static void metodohora() {

        /*
         * Obtener la fecha y hora actual del sistema
         * 
         * LocalDateTime fechaHoraActual = LocalDateTime.now();
         */
        // Crear una fecha y hora específica
        LocalDateTime fechaHora = LocalDateTime.of(2022, 3, 15, 9, 0);

        // Definir el formato deseado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy - H:mm'h'");

        // Formatear la fecha y hora
        String hora = fechaHora.format(formato);

        // Imprimir la fecha y hora formateada
        System.out.println(hora);
    }
    
        public static void inicializar() {
            int opcion;
            do {
                System.out.println("\nGesTIC");
                System.out.println("===========================");
                System.out.println("1. Nueva incidencia");
                System.out.println("2. Resolver incidencia");
                System.out.println("3. Detalles de incidencias");
                System.out.println("4. Nuevo puesto");
                System.out.println("5. Salir");
                System.out.println("6. Salida de emergencia : ");
                System.out.println("Elige opción");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                switch (opcion) {
                    case 1:
                        nuevaIncidencia();
                        break;
                    case 2:
                        resolverIncidencia();
                        break;
                    case 3:
                        detallesIncidencias();
                        break;
                    case 4:
                        nuevopuesto();
                        listapuesto();
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                        break;
                }
            } while (opcion != 5);
        }
    
        public static void nuevaIncidencia() {
            System.out.println("Ingrese la descripción de la incidencia:");
            String descripcion = scanner.nextLine();
    
            System.out.println("¿La incidencia está resuelta? (sí/no):");
            String respuesta = scanner.nextLine();
            Incidencias.EstadoIncidencia estado = respuesta.equalsIgnoreCase("si") ? Incidencias.EstadoIncidencia.RESUELTA : Incidencias.EstadoIncidencia.PENDIENTE;
    
            // Crear una nueva incidencia
            Incidencias incidencia = new Incidencias(descripcion, estado);
            Incidencias.listaIncidencias.add(incidencia);
    
            System.out.println("Incidencia creada exitosamente.");
        }
    
        public static void resolverIncidencia() {
            System.out.println("Ingrese el código de la incidencia a resolver:");
            int codigo = scanner.nextInt();
    
            // Buscar la incidencia por código
            boolean encontrada = false;
            for (Incidencias incidencia : Incidencias.listaIncidencias) {
                if (incidencia.getCodigo() == codigo && incidencia.getEstado() == Incidencias.EstadoIncidencia.PENDIENTE) {
                    incidencia.setEstado(Incidencias.EstadoIncidencia.RESUELTA); // Cambiar el estado a resuelta
                    System.out.println("Incidencia " + codigo + " resuelta.");
                    encontrada = true;
                    break;
                }
            }
    
            if (!encontrada) {
                System.out.println("Incidencia no encontrada o ya resuelta.");
            }
        }
    
        public static void detallesIncidencias() {
            if (Incidencias.listaIncidencias.isEmpty()) {
                System.out.println("No hay incidencias registradas.");
            } else {
                System.out.println("Detalles de incidencias:");
                for (Incidencias incidencia : Incidencias.listaIncidencias) {
                    System.out.println(incidencia.info());  // Esto imprime en color verde o rojo
                }
            }
        }
    
    public static void nuevopuesto() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("Ingrese el código del puesto (o -1 para terminar):");
            int codigo = scanner.nextInt();
            if (codigo == -1) {
                break; // Salir del ciclo si el usuario ingresa -1
            }
            scanner.nextLine(); // Consumir el salto de línea pendiente
            System.out.println("Ingrese la descripción del puesto:");
            String descripcion = scanner.nextLine();

            // Crear un objeto Puesto y agregarlo a la lista
            Puesto puesto = new Puesto(codigo, descripcion);
            Puesto.listaPuestos.add(puesto); // Agregar el puesto a la lista

            // Preguntar al usuario si desea continuar
            System.out.println("¿Desea agregar otro puesto? (sí/no):");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("no")) {
                continuar = false; // Salir del ciclo si el usuario ingresa "no"
            }
        }
    }

    public static void listapuesto() {
        if (Puesto.listaPuestos.isEmpty()) {
            System.out.println("No hay puestos registrados.");
        } else {
            System.out.println("\nListado de puestos:");
            for (Puesto puesto : Puesto.listaPuestos) {
                System.out.println(puesto.info()); // Esto usa el método toString() de la clase Puesto
            }
        }
    }
}