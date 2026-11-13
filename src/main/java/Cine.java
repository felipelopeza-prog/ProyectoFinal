import java.time.LocalDate;
import java.time.LocalDateTime;
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

    // ==========================================
    // PELICULAS
    // ==========================================
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
        return null;
    }

    public void modificarPelicula(String codigo, String nuevoNombre, Genero nuevoGenero, int nuevaDuracion,
                                  Clasificacion nuevaClasificacion){
        Pelicula pelicula = buscarPelicula(codigo);
        if(pelicula != null){
            pelicula.setNombre(nuevoNombre);
            pelicula.setGenero(nuevoGenero);
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

    // ==========================================
    // SALAS
    // ==========================================
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
        return null;
    }

    public void modificarSala(String codigo, int nuevoNumero, int nuevaCapacidad){
        Sala sala = buscarSala(codigo);
        if(sala != null){
            sala.setNumero(nuevoNumero);
            sala.setCapacidad(nuevaCapacidad);
        } else {
            System.out.println("Sala no encontrada para modificar.");
        }
    }

    public void deshabilitarSala(String codigo){
        Sala sala = buscarSala(codigo);
        if(sala != null){
            sala.setEstadoSala(EstadoSala.FUERA_SERVICIO);
        }
    }

    public void consultarSalas(){
        for(Sala sala : listaSalas){
            System.out.println(sala.toString());
            System.out.println("-----------------------------");
        }
    }

    // ==========================================
    // FUNCIONES
    // ==========================================
    public boolean registrarFuncion(Funcion nuevaFuncion){
        if (verificarFuncion(nuevaFuncion.getCodigo())) {
            return false;
        }
        // Validar que la sala esté disponible
        if (nuevaFuncion.getSala().getEstadoSala() == EstadoSala.FUERA_SERVICIO) {
            System.out.println("No se puede programar función en una sala fuera de servicio.");
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
        return null;
    }

    public void modificarFuncion(String codigo, Pelicula nuevaPelicula, Sala nuevaSala, LocalDateTime nuevaFechaHora, double valorBase){
        Funcion funcion = buscarFuncion(codigo);
        if(funcion != null){
            funcion.setPelicula(nuevaPelicula);
            funcion.setSala(nuevaSala);
            funcion.setFechaHora(nuevaFechaHora);
            funcion.setValorBase(valorBase);
        } else {
            System.out.println("Función no encontrada.");
        }
    }

    public void consultarFunciones(){
        for(Funcion funcion : listaFunciones){
            System.out.println(funcion.toString());
            System.out.println("-----------------------------");
        }
    }

    public void consultarFuncionesPorFecha(LocalDate fecha){
        for(Funcion funcion : listaFunciones){
            if(funcion.getFechaHora().toLocalDate().equals(fecha) && funcion.getEstadoFuncion() == EstadoFuncion.PROGRAMADA){
                System.out.println(funcion.toString());
                System.out.println("-----------------------------");
            }
        }
    }

    public void cancelarFuncion(String codigo){
        Funcion funcion = buscarFuncion(codigo);
        if(funcion != null){
            funcion.setEstadoFuncion(EstadoFuncion.CANCELADA);
            System.out.println("Función cancelada exitosamente.");
        }
    }

    // ==========================================
    // CLIENTES
    // ==========================================
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
        return null;
    }

    // ==========================================
    // EMPLEADOS
    // ==========================================
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
        return null;
    }

    // ==========================================
    // VENTAS Y GESTIÓN DE ENTRADAS
    // ==========================================
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
        return null;
    }


    public Venta venderEntrada(String codigoVenta, String idCliente, String nombreCliente,
                               TipoCliente tipoCliente, String codigoFuncion,
                               String codigoAsiento, Empleado empleado) {

        Funcion funcion = buscarFuncion(codigoFuncion);
        if (funcion == null || funcion.getEstadoFuncion() != EstadoFuncion.PROGRAMADA) {
            System.out.println("La función no existe o no está programada.");
        }


        Cliente cliente = buscarCliente(idCliente);
        if (cliente == null) {
            cliente = new Cliente(this, idCliente, nombreCliente, tipoCliente);
            registrarCliente(cliente);
        }


        Asiento asientoEncontrado = null;
        for (Asiento asiento : funcion.getListaAsientos()) {
            if (asiento.getCodigo().equalsIgnoreCase(codigoAsiento)) {
                asientoEncontrado = asiento;
                break;
            }
        }

        if (asientoEncontrado == null) {
            System.out.println("El asiento especificado no existe en esta función.");
        }

        if (asientoEncontrado.getEstadoAsiento() == EstadoAsiento.OCUPADO) {
            System.out.println("El asiento ya se encuentra ocupado.");
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

    public void cancelarVenta(String codigo){
        Venta venta = buscarVenta(codigo);
        if(venta != null && venta.getEstadoVenta() == EstadoVenta.ACTIVA){
            venta.setEstadoVenta(EstadoVenta.CANCELADA);
            if(venta.getAsiento() != null){
                venta.getAsiento().setEstadoAsiento(EstadoAsiento.DISPONIBLE);
            }
            System.out.println("Venta cancelada exitosamente y asiento liberado.");
        } else {
            System.out.println("Venta no encontrada o ya estaba cancelada.");
        }
    }

    // ==========================================
    // METODOS GENERALES Y REPORTES
    // ==========================================

    public int obtenerTotalEntradasVendidas(){
        int total = 0;
        for (Venta venta : listaVentas) {
            if (venta.getEstadoVenta() == EstadoVenta.ACTIVA) {
                total++;
            }
        }
        return total;
    }

    public double obtenerTotalIngresos(){
        double total = 0.0;
        for (Venta venta : listaVentas) {
            if (venta.getEstadoVenta() == EstadoVenta.ACTIVA) {
                total += venta.getValorPagado();
            }
        }
        return total;
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

    public void mostrarReporteOcupacionFuncion(String codigoFuncion){
        Funcion funcion = buscarFuncion(codigoFuncion);
        if(funcion != null){
            int disponibles = 0;
            int ocupados = 0;
            for(Asiento a : funcion.getListaAsientos()){
                if(a.getEstadoAsiento() == EstadoAsiento.DISPONIBLE) disponibles++;
                else ocupados++;
            }
            System.out.println("--- REPORTE DE OCUPACIÓN: Función " + codigoFuncion + " ---");
            System.out.println("Película: " + funcion.getPelicula().getNombre());
            System.out.println("Asientos Disponibles: " + disponibles);
            System.out.println("Asientos Ocupados: " + ocupados);
        } else {
            System.out.println("Función no encontrada.");
        }
    }
}