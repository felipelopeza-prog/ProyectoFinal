import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {

    private Cine cine;
    private Empleado empleado;

    @BeforeEach
    void preparar() {
        cine = new Cine("CINEMAUQ", "900123456");
        empleado = new Empleado(cine, "2001", "Carlos Admin", "admin", "1234", RolEmpleado.ADMINISTRADOR);
    }


    @Test
    void inicializaAtributosDeEmpleadoCorrectamente() {
        assertEquals(cine, empleado.getCine());
        assertEquals("2001", empleado.getIdentificacion());
        assertEquals("Carlos Admin", empleado.getNombre());
        assertEquals("admin", empleado.getUsuario());
        assertEquals("1234", empleado.getContrasenia());
        assertEquals(RolEmpleado.ADMINISTRADOR, empleado.getRolEmpleado());
    }


    @Test
    void verificaRolAdministradorTrue() {
        assertTrue(empleado.verificarRolAdministrador());
    }


    @Test
    void verificaRolAdministradorFalseCuandoTieneOtroRol() {

        empleado.setRolEmpleado(RolEmpleado.OPERADOR);

        assertFalse(empleado.verificarRolAdministrador());
    }


    @Test
    void validaCredencialesCorrectas() {
        assertTrue(empleado.validarUsuarioContrasenia("admin", "1234"));
    }


    @Test
    void rechazaCredencialesIncorrectas() {
        assertFalse(empleado.validarUsuarioContrasenia("admin", "9999"));
        assertFalse(empleado.validarUsuarioContrasenia("operador", "1234"));
    }
}