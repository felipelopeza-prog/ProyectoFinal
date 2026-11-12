public class Cliente extends Persona{

    private TipoCliente tipoCliente;

    public Cliente(Cine cine, String identificacion, String nombre, TipoCliente tipoCliente) {
        super(cine, identificacion, nombre);
        this.tipoCliente = tipoCliente;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }
    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
