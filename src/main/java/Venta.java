import java.time.LocalDateTime;

public class Venta {

//-código
//-cliente
//-función
//-asiento
//-fecha
//-hora de venta
//-valor pagado
    private Cine cine;
    private Cliente cliente;
    private Empleado empleado;
    private Funcion funcion;
    private Asiento asiento;

    private String codigo;
    private LocalDateTime fechaHoraVenta;
    private double valorPagado;
    private EstadoVenta estadoVenta;

    public Venta(Cine cine, Cliente cliente, Empleado empleado, Funcion funcion, Asiento asiento, String codigo, LocalDateTime fechaHoraVenta, double valorPagado, EstadoVenta estadoVenta) {
        this.cine = cine;
        this.cliente = cliente;
        this.empleado = empleado;
        this.funcion = funcion;
        this.asiento = asiento;
        this.codigo = codigo;
        this.fechaHoraVenta = fechaHoraVenta;
        this.valorPagado = valorPagado;
        this.estadoVenta = estadoVenta;
    }

    public Cine getCine() {
        return cine;
    }
    public void setCine(Cine cine) {
        this.cine = cine;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Funcion getFuncion() {
        return funcion;
    }
    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public Asiento getAsiento() {
        return asiento;
    }
    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getFechaHoraVenta() {
        return fechaHoraVenta;
    }
    public void setFechaHoraVenta(LocalDateTime fechaHoraVenta) {
        this.fechaHoraVenta = fechaHoraVenta;
    }

    public double getValorPagado() {
        return valorPagado;
    }
    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }

    public EstadoVenta getEstadoVenta() {
        return estadoVenta;
    }
    public void setEstadoVenta(EstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    //METODOS GENERALES DE VENTA
    public double calcularValorFinal(){
        return 0;
    }

    public void cancelarVenta(){
        setEstadoVenta(EstadoVenta.CANCELADA);
        asiento.marcarAsientoDisponible();
    }

    public boolean verificarEstadoVenta(){
        return estadoVenta == EstadoVenta.ACTIVA;
    }
}
