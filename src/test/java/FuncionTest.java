import exceptions.AsientoOcupadoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class FuncionTest {

    private Cine cine;
    private Pelicula pelicula;
    private Sala sala;
    private Asiento asientoA1;
    private Asiento asientoA2;
    private Funcion funcion;

    @BeforeEach
    void preparar() {
        cine = new Cine("CINEMAUQ", "900123456");

        pelicula = new Pelicula(cine, "P1", "Interestelar", GeneroPelicula.CIENCIA_FICCION,
                169, Clasificacion.ADOLESCENTES, EstadoPelicula.DISPONIBLE);

        sala = new Sala(cine, "S1", 1, 4, 5);

        asientoA1 = new Asiento("A1", 1, 1, EstadoAsiento.DISPONIBLE);
        asientoA2 = new Asiento("A2", 1, 2, EstadoAsiento.DISPONIBLE);

        funcion = new Funcion(asientoA1, cine, pelicula, sala, "F1",
                LocalDate.now().plusDays(1), LocalTime.of(18, 0), 15000, EstadoFuncion.PROGRAMADA);
        funcion.getListaAsientos().add(asientoA2);
    }


    @Test
    void verificaEstadoInicialYDisponibilidad() {
        assertTrue(funcion.estaProgramada());
        assertTrue(funcion.verificarDisponibilidadAsientos());
    }


    @Test
    void verificaSinDisponibilidadCuandoTodosEstanOcupados() throws AsientoOcupadoException {
        funcion.ocuparAsiento("A1");
        funcion.ocuparAsiento("A2");

        assertFalse(funcion.verificarDisponibilidadAsientos());
        assertFalse(asientoA1.verificarDisponibilidad());
    }


    @Test
    void cuentaCorrectamenteAsientosDisponiblesYOcupados() throws AsientoOcupadoException {
        funcion.ocuparAsiento("A1");

        assertEquals(1, funcion.contarAsientosDisponibles());
        assertEquals(1, funcion.contarAsientosOcupados());
        assertEquals(EstadoAsiento.OCUPADO, asientoA1.getEstadoAsiento());
    }


    @Test
    void noOcupaAsientoInexistente() {
        assertThrows(IllegalArgumentException.class, () -> funcion.ocuparAsiento("Z99"));
    }


    @Test
    void noOcupaAsientoYaOcupado() throws AsientoOcupadoException {
        funcion.ocuparAsiento("A1");

        assertThrows(AsientoOcupadoException.class, () -> funcion.ocuparAsiento("A1"));
    }
}