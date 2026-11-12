public class Empleado extends Persona {

    private String usuario;
    private String contrasenia;
    private RolEmpleado rolEmpleado;

    public Empleado(Cine cine, String identificacion, String nombre, String usuario, String contrasenia, RolEmpleado rolEmpleado) {
        super(cine, identificacion, nombre);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.rolEmpleado = rolEmpleado;
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public RolEmpleado getRolEmpleado() {
        return rolEmpleado;
    }
    public void setRolEmpleado(RolEmpleado rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }
}
