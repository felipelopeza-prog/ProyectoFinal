import java.util.List;

public class Cine {

    private String nombre;
    private String nit;

    private List<Pelicula> listaPeliculas;
    private List<Sala> listaSalas;
    private List<Funcion> listaFunciones;
    private List<Venta> listaVentas;
    private List<Cliente> listaClientes;
    private List<Empleado> listaEmpleados;

    public Cine(String nombre, String nit, List<Pelicula> listaPeliculas, List<Sala> listaSalas, List<Funcion> listaFunciones, List<Venta> listaVentas, List<Cliente> listaClientes, List<Empleado> listaEmpleados) {
        this.nombre = nombre;
        this.nit = nit;
        this.listaPeliculas = listaPeliculas;
        this.listaSalas = listaSalas;
        this.listaFunciones = listaFunciones;
        this.listaVentas = listaVentas;
        this.listaClientes = listaClientes;
        this.listaEmpleados = listaEmpleados;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }
    public void setListaPeliculas(List<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    public List<Sala> getListaSalas() {
        return listaSalas;
    }
    public void setListaSalas(List<Sala> listaSalas) {
        this.listaSalas = listaSalas;
    }

    public List<Funcion> getListaFunciones() {
        return listaFunciones;
    }
    public void setListaFunciones(List<Funcion> listaFunciones) {
        this.listaFunciones = listaFunciones;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }
    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }


}
