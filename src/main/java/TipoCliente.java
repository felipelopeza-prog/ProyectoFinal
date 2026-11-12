public enum TipoCliente {
    GENERAL(15000),
    ESTUDIANTE(12000),
    NINO(10000),
    ADULTO_MAYOR(11000);

    private double valorTipo;

    TipoCliente(double valorTipo) {
        this.valorTipo = valorTipo;
    }

    public double getValorTipo() {
        return valorTipo;
    }
}
