import java.util.ArrayList;

public class Incidencias {
    public static ArrayList<Incidencias> listaIncidencias = new ArrayList<>();

    private int codigo;
    private String descripcion;
    private EstadoIncidencia estado;

    // Contador estático para el código de las incidencias
    private static int contadorCodigo = 1001;

    // Constructor
    public Incidencias(String descripcion, EstadoIncidencia estado) {
        this.codigo = contadorCodigo++;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    // Métodos getters y setters
    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoIncidencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoIncidencia estado) {
        this.estado = estado;
    }

    // Método para mostrar la información de la incidencia con colores
    public String info() {
        // Definimos los códigos de colores ANSI para verde y rojo
        String color = (estado == EstadoIncidencia.RESUELTA) ? "\033[32m" : "\033[31m";  // Verde para resuelta, Rojo para pendiente
        String reset = "\033[0m";  // Reset de color
        return color + "Código: " + codigo + ", Descripción: " + descripcion + ", Estado: " + estado + reset;
    }

    // Enum dentro de la clase Incidencias
    public enum EstadoIncidencia {
        PENDIENTE, 
        RESUELTA,
    }
}
