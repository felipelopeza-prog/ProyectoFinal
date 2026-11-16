import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class VentaTest {

    private Cine cine;
    private Cliente cliente;
    private Empleado empleado;
    private Pelicula pelicula;
    private Sala sala;
    private Asiento asiento;
    private Funcion funcion;
    private Venta venta;
    private LocalDateTime fechaVenta;

    @BeforeEach
    void preparar() {
        cine = new Cine("CINEMAUQ", "900123456");

        cliente = new Cliente(cine, "1001", "Ana Gómez", TipoCliente.GENERAL);

        empleado = new Empleado(cine, "2001", "Carlos Admin", "admin", "1234", RolEmpleado.ADMINISTRADOR);

        pelicula = new Pelicula(cine, "P1", "Interestelar", GeneroPelicula.CIENCIA_FICCION,
                169, Clasificacion.ADOLESCENTES, EstadoPelicula.DISPONIBLE);

        sala = new Sala(cine, "S1", 1, 4, 5);

        asiento = new Asiento("A1", 1, 1, EstadoAsiento.OCUPADO);

        funcion = new Funcion(asiento, cine, pelicula, sala, "F1",
                LocalDate.now().plusDays(1), LocalTime.of(18, 0), 15000, EstadoFuncion.PROGRAMADA);

        fechaVenta = LocalDateTime.of(2026, 11, 16, 17, 30);

        venta = new Venta(cine, cliente, empleado, funcion, asiento,
                "V1", fechaVenta, 15000.0, EstadoVenta.ACTIVA);
    }


    @Test
    void inicializaAtributosDeVentaCorrectamente() {
        assertEquals("V1", venta.getCodigo());
        assertEquals(cine, venta.getCine());
        assertEquals(cliente, venta.getCliente());
        assertEquals(empleado, venta.getEmpleado());
        assertEquals(funcion, venta.getFuncion());
        assertEquals(asiento, venta.getAsiento());
        assertEquals(fechaVenta, venta.getFechaHoraVenta());
        assertEquals(15000.0, venta.getValorPagado(), 0.01);
        assertEquals(EstadoVenta.ACTIVA, venta.getEstadoVenta());
    }


    @Test
    void ventaIniciaActiva() {
        assertTrue(venta.verificarEstadoVenta());
    }


    @Test
    void cancelarVentaCambiaEstadoYLiberaAsiento() {
        venta.cancelarVenta();

        assertFalse(venta.verificarEstadoVenta());
        assertEquals(EstadoVenta.CANCELADA, venta.getEstadoVenta());
        assertEquals(EstadoAsiento.DISPONIBLE, asiento.getEstadoAsiento());
        assertTrue(asiento.verificarDisponibilidad());
    }


    @Test
    void actualizaValorPagadoCorrectamente() {
        venta.setValorPagado(12000.0);

        assertEquals(12000.0, venta.getValorPagado(), 0.01);
    }


    @Test
    void verificarEstadoVentaRetornaFalseSiNoEstaActiva() {
        venta.setEstadoVenta(EstadoVenta.CANCELADA);

        assertFalse(venta.verificarEstadoVenta());
    }
}