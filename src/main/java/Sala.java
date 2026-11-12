import java.util.ArrayList;
import java.util.List;

public class Sala {

    private Cine cine;

    private String codigo;
    private int numero;
    private int capacidad;
    private EstadoSala estadoSala;

    private List<Asiento> coleccionAsientos;
    private List<Funcion> listaFunciones;

    public Sala(Asiento asiento, Cine cine, String codigo, int numero, int capacidad, EstadoSala estadoSala) {
        this.codigo = codigo;
        this.numero = numero;
        this.capacidad = capacidad;
        this.estadoSala = estadoSala;

        coleccionAsientos = new ArrayList<>();
        coleccionAsientos.add(asiento);
        listaFunciones = new ArrayList<>();
    }

    public Cine getCine() {
        return cine;
    }
    public void setCine(Cine cine) {
        this.cine = cine;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public EstadoSala getEstadoSala() {
        return estadoSala;
    }
    public void setEstadoSala(EstadoSala estadoSala) {
        this.estadoSala = estadoSala;
    }

    public List<Asiento> getColeccionAsientos() {
        return coleccionAsientos;
    }
    public void setColeccionAsientos(List<Asiento> coleccionAsientos) {
        this.coleccionAsientos = coleccionAsientos;
    }

    public List<Funcion> getListaFunciones() {
        return listaFunciones;
    }
    public void setListaFunciones(List<Funcion> listaFunciones) {
        this.listaFunciones = listaFunciones;
    }

    //METODOS GENERALES DE SALA
    public void crearAsientos(int filas, int colummnas){

    }

    public boolean verificarDisponibilidad(){
        return true;
    }

    public List<Asiento> clonarAsientos(){
        return null;
    }
}
