import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SalaTest {

    private Cine cine;
    private Sala sala;

    @BeforeEach
    void preparar() {
        cine = new Cine("CINEMAUQ", "900123456");

        sala = new Sala(cine, "S1", 1, 4, 5);
    }


    @Test
    void creaAsientosYCalculaCapacidadCorrectamente() {
        assertEquals(20, sala.getCapacidad());
        assertEquals(20, sala.getColeccionAsientos().size());
        assertEquals("A1", sala.getColeccionAsientos().get(0).getCodigo());
        assertEquals("D5", sala.getColeccionAsientos().get(19).getCodigo());
    }


    @Test
    void salaIniciaDisponible() {
        assertTrue(sala.verificarDisponibilidad());
        assertEquals(EstadoSala.DISPONIBLE, sala.getEstadoSala());
    }


    @Test
    void deshabilitaYHabilitaSalaCorrectamente() {
        sala.deshabilitarSala();
        assertFalse(sala.verificarDisponibilidad());
        assertEquals(EstadoSala.FUERA_SERVICIO, sala.getEstadoSala());

        sala.habilitarSala();
        assertTrue(sala.verificarDisponibilidad());
    }


    @Test
    void clonaAsientosDeFormaIndependiente() {
        List<Asiento> copia = sala.clonarAsientos();

        assertEquals(sala.getColeccionAsientos().size(), copia.size());


        copia.get(0).marcarAsientoOcupado();

        assertEquals(EstadoAsiento.OCUPADO, copia.get(0).getEstadoAsiento());
        assertEquals(EstadoAsiento.DISPONIBLE, sala.getColeccionAsientos().get(0).getEstadoAsiento());
    }


    @Test
    void agregaNuevosAsientosAlLlamarCrearAsientos() {
        sala.crearAsientos(1, 2); // Agrega 2 asientos adicionales (A1 y A2)

        assertEquals(22, sala.getColeccionAsientos().size());
    }
}