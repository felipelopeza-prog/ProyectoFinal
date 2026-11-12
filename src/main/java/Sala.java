import java.util.List;

public class Sala {

//-código
//-número
//-capacidad
//-estado
//-colección de asientos

    private String codigo;
    private int numero;
    private int capacidad;
    private EstadoSala estadoSala;
    private List<Asiento> coleccionAsientos;

    public Sala(String codigo, int numero, int capacidad, EstadoSala estadoSala, List<Asiento> coleccionAsientos) {
        this.codigo = codigo;
        this.numero = numero;
        this.capacidad = capacidad;
        this.estadoSala = estadoSala;
        this.coleccionAsientos = coleccionAsientos;
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
}
