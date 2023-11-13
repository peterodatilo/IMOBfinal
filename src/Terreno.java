public class Terreno extends Financiamento {
    private String zonaTerreno;
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String zonaTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.zonaTerreno = zonaTerreno;
    }


    @Override
    public double calcularPagamentoMensal() {
        // Calcular pagamento mensal com a fórmula padrão de Financiamento
        double pagamentoMensal = super.calcularPagamentoMensal();

        // Adicionar taxa adicional de 2%
        pagamentoMensal *= 1.02;

        return pagamentoMensal;
    }
}
