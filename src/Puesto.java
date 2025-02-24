import java.util.ArrayList;
public class Puesto {
    static ArrayList<Puesto> listaPuestos = new ArrayList<>();
    private String descripcion;
    private int codigo;
    


    public Puesto(int codigo, String descripcion) {
        this.descripcion = descripcion;
        this.codigo = codigo;
    }


    // Getters
    public String getDescripcion() {
        return descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    // Setters
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    // Método estático para agregar un Puesto a la lista 
    public static void agregarPuesto(Puesto puesto) { 
        listaPuestos.add(puesto); } 
    // Método estático para obtener la lista de Puestos 
    public static ArrayList<Puesto> getListaPuestos() { 
        return listaPuestos;    
    }

    public String info(){
        return codigo + " - " + descripcion;
    } 

}


/*
Listado de puestos:
10-PC sobremesa 10
11-PC sobremesa 11
12-PC portátil 12
40- Pizarra digital Sala reuniones
41PC sala de reuniones
 */