import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Venta {

//-código
//-cliente
//-función
//-asiento
//-fecha
//-hora de venta
//-valor pagado

    private String codigo;
    private Cliente cliente;
    private Empleado empleado;
    private Funcion funcion;
    private Asiento asiento;
    private LocalDateTime fechaHoraVenta;
    private double valorPagado;
    private EstadoVenta estadoVenta;

    public Venta(String codigo, Cliente cliente, Empleado empleado, Funcion funcion, Asiento asiento, LocalDateTime fechaHoraVenta, double valorPagado, EstadoVenta estadoVenta) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.empleado = empleado;
        this.funcion = funcion;
        this.asiento = asiento;
        this.fechaHoraVenta = fechaHoraVenta;
        this.valorPagado = valorPagado;
        this.estadoVenta = estadoVenta;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
}
