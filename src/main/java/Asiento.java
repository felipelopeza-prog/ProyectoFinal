import java.util.ArrayList;
import java.util.List;

public class Asiento {

    private Sala sala;
    private Funcion funcion;
    private String codigo;
    private int fila;
    private int numero;
    private EstadoAsiento estadoAsiento;

    private List<Venta> listaVentas;

    public Asiento(Sala sala, Funcion funcion, String codigo, int fila, int numero, EstadoAsiento estadoAsiento) {
        this.sala = sala;
        this.funcion = funcion;
        this.codigo = codigo;
        this.fila = fila;
        this.numero = numero;
        this.estadoAsiento = estadoAsiento;

        listaVentas = new ArrayList<>();
    }

    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Funcion getFuncion() {
        return funcion;
    }
    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getFila() {
        return fila;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public EstadoAsiento getEstadoAsiento() {
        return estadoAsiento;
    }
    public void setEstadoAsiento(EstadoAsiento estadoAsiento) {
        this.estadoAsiento = estadoAsiento;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }
    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
}
