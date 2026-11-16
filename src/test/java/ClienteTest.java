import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    private Cine cine;
    private Cliente cliente;

    @BeforeEach
    void preparar() {
        cine = new Cine("CINEMAUQ", "900123456");
        cliente = new Cliente(cine, "1001", "Ana Gómez", TipoCliente.GENERAL);
    }

    @Test
    void inicializaAtributosDeClienteCorrectamente() {
        assertEquals(cine, cliente.getCine());
        assertEquals("1001", cliente.getIdentificacion());
        assertEquals("Ana Gómez", cliente.getNombre());
        assertEquals(TipoCliente.GENERAL, cliente.getTipoCliente());
    }

    @Test
    void calculaPrecioEntradaClienteGeneral() {
        double precio = cliente.calcularPrecioEntrada(15000.0);

        assertEquals(15000.0, precio, 0.01);
        assertTrue(precio > 0);
    }

    @Test
    void actualizaTipoClienteCorrectamente() {
        cliente.setTipoCliente(null);

        assertFalse(cliente.getTipoCliente() == TipoCliente.GENERAL);
        assertEquals(null, cliente.getTipoCliente());
    }

    @Test
    void calculaPrecioEntradaConValorBaseCero() {
        double precio = cliente.calcularPrecioEntrada(0.0);

        assertEquals(0.0, precio, 0.01);
        assertFalse(precio > 0);
    }

    @Test
    void lanzaExcepcionSiTipoClienteEsNuloAlCalcularPrecio() {
        cliente.setTipoCliente(null);

        assertThrows(NullPointerException.class, () -> cliente.calcularPrecioEntrada(15000.0));
    }
}