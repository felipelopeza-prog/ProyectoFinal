import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AsientoTest {

    private Asiento asiento;

    @BeforeEach
    void preparar() {
        asiento = new Asiento("B4", 2, 4, EstadoAsiento.DISPONIBLE);
    }


    @Test
    void inicializaAtributosCorrectamente() {
        assertEquals("B4", asiento.getCodigo());
        assertEquals(2, asiento.getFila());
        assertEquals(4, asiento.getNumero());
        assertEquals(EstadoAsiento.DISPONIBLE, asiento.getEstadoAsiento());
        assertTrue(asiento.getListaVentas().isEmpty());
    }


    @Test
    void asientoIniciaDisponible() {
        assertTrue(asiento.verificarDisponibilidad());
    }


    @Test
    void marcaAsientoComoOcupado() {
        asiento.marcarAsientoOcupado();

        assertFalse(asiento.verificarDisponibilidad());
        assertEquals(EstadoAsiento.OCUPADO, asiento.getEstadoAsiento());
    }


    @Test
    void marcaAsientoComoDisponibleNuevamente() {
        asiento.marcarAsientoOcupado();
        assertFalse(asiento.verificarDisponibilidad());

        asiento.marcarAsientoDisponible();
        assertTrue(asiento.verificarDisponibilidad());
        assertEquals(EstadoAsiento.DISPONIBLE, asiento.getEstadoAsiento());
    }


    @Test
    void asociaSalaYFuncionCorrectamente() {
        Cine cine = new Cine("CINEMAUQ", "900123456");
        Sala sala = new Sala(cine, "S1", 1, 4, 5);

        asiento.setSala(sala);

        assertEquals(sala, asiento.getSala());
        assertEquals("S1", asiento.getSala().getCodigo());
    }
}