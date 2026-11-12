public class Pelicula {
    private String codigo;
    private String nombre;
    private Genero genero;
    private int duracionMinutos;
    private Clasificacion clasificacion;
    private EstadoPelicula estadoPelicula;

    public Pelicula(String codigo, String nombre, Genero genero,
                    int duracionMinutos, Clasificacion clasificacion, EstadoPelicula estadoPelicula) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.duracionMinutos = duracionMinutos;
        this.clasificacion = clasificacion;
        this.estadoPelicula = estadoPelicula;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }
    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public EstadoPelicula getEstadoPelicula() {
        return estadoPelicula;
    }
    public void setEstadoPelicula(EstadoPelicula estadoPelicula) {
        this.estadoPelicula = estadoPelicula;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", duracionMinutos=" + duracionMinutos +
                ", clasificacion=" + clasificacion +
                ", estadoPelicula=" + estadoPelicula +
                '}';
    }
}
