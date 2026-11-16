import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class PeliculaTest {

    private Cine cine;
    private Pelicula pelicula;

    @BeforeEach
    void preparar() {
        cine = new Cine("CINEMAUQ", "900123456");
        pelicula = new Pelicula(cine, "P1", "Interestelar", GeneroPelicula.CIENCIA_FICCION,
                169, Clasificacion.ADOLESCENTES, EstadoPelicula.DISPONIBLE);
    }

    @Test
    void inicializaAtributosDePeliculaCorrectamente() {
        assertEquals(cine, pelicula.getCine());
        assertEquals("P1", pelicula.getCodigo());
        assertEquals("Interestelar", pelicula.getNombre());
        assertEquals(GeneroPelicula.CIENCIA_FICCION, pelicula.getGeneroPelicula());
        assertEquals(169, pelicula.getDuracionMinutos());
        assertEquals(Clasificacion.ADOLESCENTES, pelicula.getClasificacion());
        assertEquals(EstadoPelicula.DISPONIBLE, pelicula.getEstadoPelicula());
        assertTrue(pelicula.getListaFunciones().isEmpty());
    }

    @Test
    void peliculaIniciaDisponible() {
        assertTrue(pelicula.verificarDisponibilidad());
    }

    @Test
    void marcaPeliculaComoNoDisponible() {
        pelicula.marcarPeliculaNoDisponible();

        assertFalse(pelicula.verificarDisponibilidad());
        assertEquals(EstadoPelicula.NO_DISPONIBLE, pelicula.getEstadoPelicula());
    }

    @Test
    void marcaPeliculaComoDisponibleNuevamente() {
        pelicula.marcarPeliculaNoDisponible();
        assertFalse(pelicula.verificarDisponibilidad());

        pelicula.marcarPeliculaDisponible();
        assertTrue(pelicula.verificarDisponibilidad());
        assertEquals(EstadoPelicula.DISPONIBLE, pelicula.getEstadoPelicula());
    }

    @Test
    void asociaFuncionesALaPeliculaCorrectamente() {
        Sala sala = new Sala(cine, "S1", 1, 4, 5);
        Asiento asiento = new Asiento("A1", 1, 1, EstadoAsiento.DISPONIBLE);
        Funcion funcion = new Funcion(asiento, cine, pelicula, sala, "F1",
                LocalDate.now().plusDays(1), LocalTime.of(18, 0), 15000, EstadoFuncion.PROGRAMADA);

        pelicula.getListaFunciones().add(funcion);

        assertEquals(1, pelicula.getListaFunciones().size());
        assertEquals(funcion, pelicula.getListaFunciones().get(0));
    }
}