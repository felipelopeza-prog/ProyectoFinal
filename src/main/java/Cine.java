import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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

    public Cine(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;

        listaPeliculas = new ArrayList<>();
        listaSalas = new ArrayList<>();
        listaFunciones = new ArrayList<>();
        listaVentas = new ArrayList<>();
        listaClientes = new ArrayList<>();
        listaEmpleados = new ArrayList<>();
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

    //PELICULAS
    public boolean registrarPelicula(Pelicula nuevaPelicula){
        if (verificarPelicula(nuevaPelicula.getCodigo())) {
            return false;
        }
        listaPeliculas.add(nuevaPelicula);
        return true;
    }

    public boolean verificarPelicula(String codigo){
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public Pelicula buscarPelicula(String codigo){
        for(Pelicula pelicula : listaPeliculas){
            if(pelicula.getCodigo().equals(codigo)){
                return pelicula;
            }
        }
        System.out.println("Pelicula no encontrada");
        return null;
    }

    public void modificarPelicula(String codigo, String nuevoNombre, Genero nuevoGenero, int nuevaDuracion,
                                  Clasificacion nuevaClasificacion){

        if(!verificarPelicula(codigo)){
            System.out.println("No puedes modificar una pelicula que no existe");
            return;
        }
        for(Pelicula pelicula : listaPeliculas){
            if(pelicula.getCodigo().equals(codigo)){
                pelicula.setNombre(nuevoNombre);
                pelicula.setGenero(nuevoGenero);
                pelicula.setDuracionMinutos(nuevaDuracion);
                pelicula.setClasificacion(nuevaClasificacion);
                return;
            }
        }

    }

    public void deshabilitarPelicula(String codigo){
        Pelicula pelicula = buscarPelicula(codigo);
        if (pelicula == null){
            return;
        }
        pelicula.setEstadoPelicula(EstadoPelicula.NO_DISPONIBLE);
    }

    public void consultarPeliculasDisponibles(){
        for(Pelicula pelicula : listaPeliculas){
            System.out.println(pelicula.toString());
            System.out.println("-----------------------------");
        }
    }

    //SALAS
    public boolean registrarSala(Sala nuevaSala){
        if (verificarSala(nuevaSala.getCodigo())) {
            return false;
        }
        listaSalas.add(nuevaSala);
        return true;
    }

    public boolean verificarSala(String codigo){
        for (Sala sala : listaSalas) {
            if (sala.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public Sala buscarSala(String codigo){
        for(Sala sala : listaSalas){
            if(sala.getCodigo().equals(codigo)){
                return sala;
            }
        }
        System.out.println("Sala no encontrada");
        return null;
    }

    public void modificarSala(String codigo, int nuevoNumero, int nuevaCapacidad){
        if(!verificarSala(codigo)){
            System.out.println("No puedes modificar una pelicula que no existe");
            return;
        }
        for(Sala sala : listaSalas){
            if(sala.getCodigo().equals(codigo)){
                sala.setNumero(nuevoNumero);
                sala.setCapacidad(nuevaCapacidad);
                return;
            }
        }
    }

    public void deshabilitarSala(String codigo){
        Sala sala = buscarSala(codigo);
        if (sala == null){
            return;
        }
        sala.setEstadoSala(EstadoSala.FUERA_SERVICIO);
    }

    public void consultarSalas(){
        for(Sala sala : listaSalas){
            System.out.println(sala.toString());
            System.out.println("------------------------");
        }
    }

    //FUNCIONES
    public boolean registrarFuncion(Funcion nuevaFuncion){
        if (verificarFuncion(nuevaFuncion.getCodigo())) {
            return false;
        }
        listaFunciones.add(nuevaFuncion);
        return true;
    }

    public boolean verificarFuncion(String codigo){
        for (Funcion funcion : listaFunciones) {
            if (funcion.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public Funcion buscarFuncion(String codigo){
        for(Funcion funcion : listaFunciones){
            if(funcion.getCodigo().equals(codigo)){
                return funcion;
            }
        }
        System.out.println("Funcion no encontrada");
        return null;
    }

    public void modificarFuncion(String codigo, Pelicula nuevaPelicula, LocalDate nuevaFecha, LocalTime nuevaHora, double nuevoValorBase){
        if(!verificarFuncion(codigo)){
            System.out.println("No puedes modificar una pelicula que no existe");
            return;
        }
        for(Funcion funcion : listaFunciones){
            if(funcion.getCodigo().equals(codigo)){
                funcion.setPelicula(nuevaPelicula);
                funcion.setFecha(nuevaFecha);
                funcion.setHora(nuevaHora);
                funcion.setValorBase(nuevoValorBase);
                return;
            }
        }
    }

    public void consultarFuncionesProgramadas(){
        for(Funcion funcion : listaFunciones){
            if(funcion.getEstadoFuncion() == EstadoFuncion.PROGRAMADA){
                System.out.println(funcion.toString());
                System.out.println("----------------------");
            }
        }
    }

    public void consultarFuncionesPorFecha(LocalDate fecha){
        for(Funcion funcion : listaFunciones){
            if(funcion.getFecha() == fecha){
                System.out.println(funcion.toString());
                System.out.println("------------------------");
            }
        }
    }

    public void cancelarFuncion(String codigo){
        Funcion funcion = buscarFuncion(codigo);
        if(funcion == null){
            return;
        }
        funcion.setEstadoFuncion(EstadoFuncion.CANCELADA);

    }

    //CLIENTES
    public boolean registrarCliente(Cliente nuevoCliente){
        if (verificarCliente(nuevoCliente.getIdentificacion())) {
            return false;
        }
        listaClientes.add(nuevoCliente);
        return true;
    }

    public boolean verificarCliente(String identificacion){
        for (Cliente cliente : listaClientes) {
            if (cliente.getIdentificacion().equals(identificacion)) {
                return true;
            }
        }
        return false;
    }

    public Cliente buscarCliente(String identificacion){
        for(Cliente cliente : listaClientes){
            if(cliente.getIdentificacion().equals(identificacion)){
                return cliente;
            }
        }
        System.out.println("Cliente no encontrado (se recomienda registrar el cliente)");
        return null;
    }

    //EMPLEADO
    public boolean registrarEmpleado(Empleado nuevoEmpleado){
        if (verificarEmpleado(nuevoEmpleado.getIdentificacion())) {
            return false;
        }
        listaEmpleados.add(nuevoEmpleado);
        return true;
    }

    public boolean verificarEmpleado(String identificacion){
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getIdentificacion().equals(identificacion)) {
                return true;
            }
        }
        return false;
    }

    public Empleado buscarEmpleado(String identificacion){
        for(Empleado empleado : listaEmpleados){
            if(empleado.getIdentificacion().equals(identificacion)){
                return empleado;
            }
        }
        System.out.println("Empleado no encontrada");
        return null;
    }

    //VENTAS
    public boolean registrarVenta(Venta nuevaVenta){
        if (verificarVenta(nuevaVenta.getCodigo())) {
            return false;
        }
        listaVentas.add(nuevaVenta);
        return true;
    }

    public boolean verificarVenta(String codigo){
        for (Venta venta : listaVentas) {
            if (venta.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public Venta buscarVenta(String codigo){
        for(Venta venta : listaVentas){
            if(venta.getCodigo().equals(codigo)){
                return venta;
            }
        }
        System.out.println("Venta no encontrada");
        return null;
    }

    public void cancelarVenta(String codigo){
        Venta venta = buscarVenta(codigo);
        if(venta == null){
            return;
        }
        venta.setEstadoVenta(EstadoVenta.CANCELADA);
    }

    //METODOS GENERALES DE CINE
    public int obtenerTotalEntradasVendidas(){
        int ventasActivas = 0;
        for(Venta venta : listaVentas){
            if(venta.getEstadoVenta() == EstadoVenta.ACTIVA){
                ventasActivas++;
            }
        }
        return ventasActivas;
    }

    public double obtenerTotalIngresos(){
        double sumaVentas = 0;
        for(Venta venta : listaVentas){
            if(venta.getEstadoVenta() == EstadoVenta.ACTIVA){
                sumaVentas += venta.getValorPagado();
            }
        }
        return sumaVentas;
    }

    public Pelicula obtenerPeliculaMasVendida(){
        //IMPORTANTE: este metodo queda pendiente, hacerlo despues
        return null;
    }

    public void mostrarReporteOcupacionFuncion(String codigo){
        Funcion funcion = buscarFuncion(codigo);
        if(funcion == null){
            return;
        }
        System.out.println("Total asientos: " + funcion.getListaAsientos().size());
        int asientosDisponibles = 0;
        int asientosOcupados = 0;
        for(Asiento asiento : funcion.getListaAsientos()){
            if(asiento.verificarDisponibilidad()){
                asientosDisponibles++;
            } else {
                asientosOcupados++;
            }
        }
        System.out.println("Asientos disponibles: " + asientosDisponibles);
        System.out.println("Asientos ocupados: " + asientosOcupados);
    }
}
