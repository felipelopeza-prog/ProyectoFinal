import java.util.ArrayList;
import java.util.List;

public abstract class Persona {

    private Cine cine;
    private String identificacion;
    private String nombre;

    private List<Venta> listaVentas;

    public Persona(Cine cine,String identificacion, String nombre) {
        this.cine = cine;
        this.identificacion = identificacion;
        this.nombre = nombre;

        listaVentas = new ArrayList<>();
    }

    public Cine getCine() {
        return cine;
    }
    public void setCine(Cine cine) {
        this.cine = cine;
    }

    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }
    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
}
