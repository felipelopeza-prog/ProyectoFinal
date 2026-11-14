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

    public Sala(Cine cine, String codigo, int numero, int filas, int columnas) {
        this.codigo = codigo;
        this.numero = numero;
        this.capacidad = filas*columnas;
        this.estadoSala = EstadoSala.DISPONIBLE;

        coleccionAsientos = new ArrayList<>();
        crearAsientos(filas,columnas);
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
    public void crearAsientos(int filas, int columnas){

        for(int i = 0; i < filas; i++){
            char letraFila = (char)('A'+i);
            for (int j = 1; j <= columnas; j++){
                String codigoAsiento = letraFila + "" + j;
                coleccionAsientos.add(new Asiento(codigoAsiento, i, j, EstadoAsiento.DISPONIBLE));
            }
        }
    }

    public boolean verificarDisponibilidad(){
        return getEstadoSala() == EstadoSala.DISPONIBLE;
    }

    public List<Asiento> clonarAsientos(){
        List<Asiento> copia = new ArrayList<>();
        for(Asiento asiento : coleccionAsientos){
            copia.add(new Asiento(asiento.getCodigo(), asiento.getFila(), asiento.getNumero(), asiento.getEstadoAsiento()));
        }
        return copia;
    }

    public void habilitarSala(){
        setEstadoSala(EstadoSala.DISPONIBLE);
    }

    public void deshabilitarSala(){
        setEstadoSala(EstadoSala.FUERA_SERVICIO);
    }
}
