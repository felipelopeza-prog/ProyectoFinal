public enum TipoCliente implements Tarifa{
    GENERAL{
        @Override
        public double calcularValorEntrada(double valorBase) {
            return valorBase;
        }
    },
    ESTUDIANTE{
        @Override
        public double calcularValorEntrada(double valorBase) {
            return valorBase * 0.80;
        }
    },
    NINO{
        @Override
        public double calcularValorEntrada(double valorBase) {
            return valorBase * 0.65;
        }
    },
    ADULTO_MAYOR{
        @Override
        public double calcularValorEntrada(double valorBase) {
            return valorBase * 0.70;
        }
    }
}
