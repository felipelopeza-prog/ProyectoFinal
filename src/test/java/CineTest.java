import exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class CineTest {

    private Cine cine;
    private Pelicula pelicula;
    private Sala sala;
    private Empleado empleado;

    @BeforeEach
    void preparar() throws Exception {
        cine = new Cine("CINEMAUQ", "900123456");

        pelicula = new Pelicula(cine, "P1", "Interestelar", GeneroPelicula.CIENCIA_FICCION,
                169, Clasificacion.ADOLESCENTES, EstadoPelicula.DISPONIBLE);
        cine.registrarPelicula(pelicula);

        sala = new Sala(cine, "S1", 1, 4, 5);
        cine.registrarSala(sala);

        Asiento a1 = new Asiento("A1", 1, 1, EstadoAsiento.DISPONIBLE);
        Asiento a2 = new Asiento("A2", 1, 2, EstadoAsiento.DISPONIBLE);
        Funcion funcion = new Funcion(a1, cine, pelicula, sala, "F1",
                LocalDate.now().plusDays(1), LocalTime.of(18, 0), 15000, EstadoFuncion.PROGRAMADA);
        funcion.getListaAsientos().add(a2);
        cine.registrarFuncion(funcion);

        empleado = new Empleado(cine, "2001", "Carlos Admin", "admin", "1234", RolEmpleado.ADMINISTRADOR);
        cine.registrarEmpleado(empleado);
    }

    @Test
    void noRegistraPeliculaConCodigoRepetido() {
        Pelicula repetida = new Pelicula(cine, "P1", "Metrópolis", GeneroPelicula.CIENCIA_FICCION,
                100, Clasificacion.ADOLESCENTES, EstadoPelicula.DISPONIBLE);
        assertThrows(CodigoDuplicadoException.class, () -> cine.registrarPelicula(repetida));
    }

    @Test
    void noRegistraFuncionEnSalaFueraDeServicio() {
        cine.deshabilitarSala("S1");
        Funcion nueva = new Funcion(new Asiento("A1", 1, 1, EstadoAsiento.DISPONIBLE), cine, pelicula,
                sala, "F2", LocalDate.now().plusDays(2), LocalTime.of(20, 0), 15000,
                EstadoFuncion.PROGRAMADA);
        assertThrows(SalaNoDisponibleException.class, () -> cine.registrarFuncion(nueva));
    }

    @Test
    void vendeEntradaCorrectamente() throws Exception {
        Venta venta = cine.venderEntrada("V1", "1001", "Ana Gómez", TipoCliente.GENERAL,
                "F1", "A1", empleado);

        assertEquals(EstadoVenta.ACTIVA, venta.getEstadoVenta());
        assertEquals(15000, venta.getValorPagado(), 0.01);
        assertEquals(EstadoAsiento.OCUPADO, venta.getAsiento().getEstadoAsiento());
    }

    @Test
    void noVendeAsientoOcupado() throws Exception {
        cine.venderEntrada("V1", "1001", "Ana Gómez", TipoCliente.GENERAL, "F1", "A1", empleado);
        assertThrows(AsientoOcupadoException.class, () ->
                cine.venderEntrada("V2", "1001", "Ana Gómez", TipoCliente.GENERAL, "F1", "A1", empleado));
    }

    @Test
    void cancelarVentaLiberaElAsiento() throws Exception {
        Venta venta = cine.venderEntrada("V1", "1001", "Ana Gómez", TipoCliente.GENERAL,
                "F1", "A1", empleado);

        cine.cancelarVenta("V1");

        assertEquals(EstadoVenta.CANCELADA, venta.getEstadoVenta());
        assertEquals(EstadoAsiento.DISPONIBLE, venta.getAsiento().getEstadoAsiento());
    }
}