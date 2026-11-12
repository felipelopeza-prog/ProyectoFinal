import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Funcion {

    private Cine cine;
    private Pelicula pelicula;
    private Sala sala;
    private String codigo;
    private LocalDateTime fechaHora;
    private double valorBase;
    private EstadoFuncion estadoFuncion;

    private List<Asiento> listaAsientos;
    private List<Venta> listaVentas;

    public Funcion(Asiento asiento, Cine cine, Pelicula pelicula, Sala sala, String codigo, LocalDateTime fechaHora, double valorBase, EstadoFuncion estadoFuncion) {
        this.cine = cine;
        this.pelicula = pelicula;
        this.sala = sala;
        this.codigo = codigo;
        this.fechaHora = fechaHora;
        this.valorBase = valorBase;
        this.estadoFuncion = estadoFuncion;

        listaAsientos = new ArrayList<>();
        listaAsientos.add(asiento);
        listaVentas = new ArrayList<>();
    }

    public Cine getCine() {
        return cine;
    }
    public void setCine(Cine cine) {
        this.cine = cine;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getValorBase() {
        return valorBase;
    }
    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public EstadoFuncion getEstadoFuncion() {
        return estadoFuncion;
    }
    public void setEstadoFuncion(EstadoFuncion estadoFuncion) {
        this.estadoFuncion = estadoFuncion;
    }

    public List<Asiento> getListaAsientos() {
        return listaAsientos;
    }
    public void setListaAsientos(List<Asiento> listaAsientos) {
        this.listaAsientos = listaAsientos;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }
    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
}
