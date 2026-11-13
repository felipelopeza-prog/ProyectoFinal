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

    public boolean verificarRolAdministrador(){
        return rolEmpleado == RolEmpleado.ADMINISTRADOR;
    }

    public boolean validarUsuarioContrasenia(String usuario, String contrasenia){
        if(getUsuario().equals(usuario)){
            if(getContrasenia().equals(contrasenia)){
                System.out.println("Usuario y contraseña verificados: Bienvenido " + usuario);
                return true;
            } else {
                System.out.println("contraseña incorrecta, intentelo denuevo");
                return false;
            }
        } else {
            System.out.println("Este usuario no existe en la base de datos de la empresa");
            return false;
        }
    }

}
