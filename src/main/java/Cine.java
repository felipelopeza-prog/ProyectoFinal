import exceptions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public boolean registrarPelicula(Pelicula nuevaPelicula) throws CodigoDuplicadoException {
        if (verificarPelicula(nuevaPelicula.getCodigo())) {
            throw new CodigoDuplicadoException("Ya existe una película registrada con el código " + nuevaPelicula.getCodigo());
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

    public void modificarPelicula(String codigo, String nuevoNombre, GeneroPelicula nuevoGenero, int nuevaDuracion,
                                  Clasificacion nuevaClasificacion){
        Pelicula pelicula = buscarPelicula(codigo);
        if(pelicula != null){
            pelicula.setNombre(nuevoNombre);
            pelicula.setGeneroPelicula(nuevoGenero);
            pelicula.setDuracionMinutos(nuevaDuracion);
            pelicula.setClasificacion(nuevaClasificacion);
        } else {
            System.out.println("No se puede modificar. Película no encontrada.");
        }
    }

    public void deshabilitarPelicula(String codigo){
        Pelicula pelicula = buscarPelicula(codigo);
        if(pelicula != null){
            pelicula.setEstadoPelicula(EstadoPelicula.NO_DISPONIBLE);
        }
    }

    public void consultarPeliculasDisponibles(){
        for(Pelicula pelicula : listaPeliculas){
            if(pelicula.getEstadoPelicula() == EstadoPelicula.DISPONIBLE) {
                System.out.println(pelicula.toString());
                System.out.println("-----------------------------");
            }
        }
    }

    //SALAS
    public boolean registrarSala(Sala nuevaSala) throws CodigoDuplicadoException{
        if (verificarSala(nuevaSala.getCodigo())) {
            throw new CodigoDuplicadoException("Ya existe una sala registrada con el código " + nuevaSala.getCodigo());
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

    public void modificarSala(String codigo, int nuevoNumero){
        Sala sala = buscarSala(codigo);
        if(sala != null){
            sala.setNumero(nuevoNumero);
        } else {
            System.out.println("Sala no encontrada para modificar.");
        }
    }

    public void deshabilitarSala(String codigo){

        Sala sala = buscarSala(codigo);
        if(sala != null){
            sala.deshabilitarSala();
        }
    }
    public void habilitarSala(String codigo){

        Sala sala = buscarSala(codigo);
        if(sala != null){
            sala.habilitarSala();
        }
    }

    public boolean verificarNumeroSala(int numeroSala){
        for(Sala sala : listaSalas){
            if(sala.getNumero() == numeroSala){
                return true;
            }
        }
        return false;
    }

    public void consultarSalas(){
        for(Sala sala : listaSalas){
            System.out.println(sala.toString());
            System.out.println("------------------------");
        }
    }

    //FUNCIONES
    public boolean registrarFuncion(Funcion nuevaFuncion) throws CodigoDuplicadoException, SalaNoDisponibleException {
        if (verificarFuncion(nuevaFuncion.getCodigo())) {
            throw new CodigoDuplicadoException("Ya existe una funcion registrada con el código " + nuevaFuncion.getCodigo());
        }
        // Validar que la sala esté disponible
        if (nuevaFuncion.getSala().getEstadoSala() == EstadoSala.FUERA_SERVICIO) {
            throw new SalaNoDisponibleException("La sala " + nuevaFuncion.getSala() + " Esta Fuera de Servicio");
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
        boolean hayFunciones = false;
        for(Funcion funcion : listaFunciones){
            if(funcion.getFecha() == fecha){
                System.out.println(funcion.toString());
                System.out.println("------------------------");
                hayFunciones = true;
            }
        }
        if (!hayFunciones){
            System.out.println("No hay funciones en esa fecha");
        }
    }

    public void cancelarFuncion(String codigo){
        Funcion funcion = buscarFuncion(codigo);
        if(funcion != null){
            funcion.setEstadoFuncion(EstadoFuncion.CANCELADA);
            System.out.println("Función cancelada exitosamente.");
        }
    }

    //CLIENTES
    public boolean registrarCliente(Cliente nuevoCliente) throws CodigoDuplicadoException{
        if (verificarCliente(nuevoCliente.getIdentificacion())) {
            throw new CodigoDuplicadoException("Ya existe un cliente registrado con el numero de identidad " + nuevoCliente.getIdentificacion());
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
    public boolean registrarVenta(Venta nuevaVenta) throws CodigoDuplicadoException{
        if (verificarVenta(nuevaVenta.getCodigo())) {
            throw new CodigoDuplicadoException("Ya existe una venta registrada con el código " + nuevaVenta.getCodigo());        }
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


    public Venta venderEntrada(String codigoVenta, String idCliente, String nombreCliente,
                               TipoCliente tipoCliente, String codigoFuncion,
                               String codigoAsiento, Empleado empleado) throws CodigoDuplicadoException, FuncionNoEncontradaException, SinAsientosDisponiblesException, AsientoNoEncontradoException, AsientoOcupadoException{

        if(verificarVenta(codigoVenta)){
            throw new CodigoDuplicadoException("Ya existe una venta registrada con el código " + codigoVenta);
        }

        Funcion funcion = buscarFuncion(codigoFuncion);
        if (funcion == null || funcion.getEstadoFuncion() != EstadoFuncion.PROGRAMADA) {
            throw new FuncionNoEncontradaException("La función no existe o no está programada.");
        }

        if (!funcion.verificarDisponibilidadAsientos()){
            throw new SinAsientosDisponiblesException("No hay asientos disponibles de esta funcion");
        }


        Cliente cliente = buscarCliente(idCliente);
        if (cliente == null) {
            cliente = new Cliente(this, idCliente, nombreCliente, tipoCliente);
            registrarCliente(cliente);
        }

        Asiento asientoEncontrado = funcion.buscarAsiento(codigoAsiento);

        if (asientoEncontrado == null) {
            throw new AsientoNoEncontradoException("El asiento especificado no existe en esta función.");
        }

        if (asientoEncontrado.getEstadoAsiento() == EstadoAsiento.OCUPADO) {
            throw new AsientoOcupadoException("El asiento ya se encuentra ocupado.");
        }


        double valorPagado = funcion.getValorBase();


        if (tipoCliente != null) {

            switch (tipoCliente) {
                case ESTUDIANTE -> valorPagado *= 0.80; // 20% descuento
                case NINO -> valorPagado *= 0.65;        // 35% descuento
                case ADULTO_MAYOR -> valorPagado *= 0.75; // 25% descuento
                default -> {} // GENERAL
            }
        }


        asientoEncontrado.marcarAsientoOcupado();

         Venta nuevaVenta = new Venta(
                this,
                cliente,
                empleado,
                funcion,
                asientoEncontrado,
                codigoVenta,
                LocalDateTime.now(),
                valorPagado,
                EstadoVenta.ACTIVA
        );

        listaVentas.add(nuevaVenta);

        cliente.getListaVentas().add(nuevaVenta);
        if(empleado != null) {
            empleado.getListaVentas().add(nuevaVenta);
        }

        return nuevaVenta;
    }

    public void cancelarVenta(String codigo) throws VentaNoEncontradaException{
        Venta venta = buscarVenta(codigo);
        if(venta != null && venta.getEstadoVenta() == EstadoVenta.ACTIVA){
            venta.setEstadoVenta(EstadoVenta.CANCELADA);
            if(venta.getAsiento() != null){
                venta.getAsiento().setEstadoAsiento(EstadoAsiento.DISPONIBLE);
            }
            System.out.println("Venta cancelada exitosamente y asiento liberado.");
        } else {
            throw new VentaNoEncontradaException("Venta no encontrada o ya estaba cancelada.");
        }
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
        if (listaPeliculas.isEmpty()) return null;

        Map<Pelicula, Integer> conteoPeliculas = new HashMap<>();
        for (Venta venta : listaVentas) {
            if (venta.getEstadoVenta() == EstadoVenta.ACTIVA && venta.getFuncion() != null) {
                Pelicula p = venta.getFuncion().getPelicula();
                conteoPeliculas.put(p, conteoPeliculas.getOrDefault(p, 0) + 1);
            }
        }

        Pelicula masVendida = null;
        int maxVentas = -1;
        for (Map.Entry<Pelicula, Integer> entry : conteoPeliculas.entrySet()) {
            if (entry.getValue() > maxVentas) {
                maxVentas = entry.getValue();
                masVendida = entry.getKey();
            }
        }
        return masVendida;
    }
    public void mostrarReporteOcupacionFuncion(String codigo) throws FuncionNoEncontradaException{
        Funcion funcion = buscarFuncion(codigo);
        if(funcion == null){
            throw new FuncionNoEncontradaException("No existe la funcion con el código " + codigo);
        }
        System.out.println("--- REPORTE DE OCUPACIÓN: Función " + codigo + " ---");
        System.out.println("Película: " + funcion.getPelicula().getNombre());
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
