import java.time.LocalDateTime;
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
    public void registrarPelicula(Pelicula nuevaPelicula){

    }

    public boolean verificarPelicula(String codigo){
        return true;
    }

    public Pelicula buscarPelicula(String codigo){
        return null;
    }

    public void modificarPelicula(String codigo, String nuevoNombre, Genero nuevoGenero, int nuevaDuracion,
                                  Clasificacion nuevaClasificacion){

    }

    public void deshabilitarPelicula(String codigo){

    }

    public void consultarPeliculasDisponibles(){

    }

    //SALAS
    public void registrarSala(Sala sala){

    }

    public boolean verificarSala(String codigo){
        return true;
    }

    public Sala buscarSala(String codigo){
        return null;
    }

    public void modificarSala(String codigo, int nuevoNumero, int nuevaCapacidad){

    }

    public void deshabilitarSala(String codigo){

    }

    public void consultarSalas(){

    }

    //FUNCIONES
    public void registrarFuncion(Funcion funcion){

    }

    public boolean verificarFuncion(String codigo){
        return true;
    }

    public Funcion buscarFuncion(String codigo){
        return null;
    }

    public void modificarFuncion(String codigo, Pelicula nuevaPelicula, Sala nuevaSala, LocalDateTime nuevaFechaHora, double valorBase){

    }

    public void consultarFunciones(){

    }

    public void consultarFuncionesPorFecha(){

    }

    public void cancelarFuncion(String codigo){

    }

    //CLIENTES
    public void registrarCliente(Cliente cliente){

    }

    public boolean verificarCliente(String documento){
        return true;
    }

    public Cliente buscarCliente(String documento){
        return null;
    }

    //EMPLEADO
    public void registrarEmpleado(Empleado empleado){

    }

    public boolean verificarEmpleado(String documento){
        return true;
    }

    public Empleado buscarEmpleado(String documento){
        return null;
    }

    //VENTAS
    public void registrarVenta(Venta venta){

    }

    public boolean verificarVenta(String codigo){
        return true;
    }

    public Venta buscarVenta(String codigo){
        return null;
    }

    public void cancelarVenta(String codigo){

    }

    //METODOS GENERALES DE CINE
    public int obtenerTotalEntradasVendidas(){
        return 0;
    }

    public double obtenerTotalIngresos(){
        return 0;
    }

    public Pelicula obtenerPeliculaMasVendida(){
        return null;
    }

    public void mostrarReporteOcupacionFuncion(String codigo){

    }
}
