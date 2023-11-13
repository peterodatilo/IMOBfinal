public class Casa extends Financiamento {
    private double tamanhoAreaConstruida;
    private double tamanhoTerreno;
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double tamanhoAreaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tamanhoAreaConstruida = tamanhoAreaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;



}

    @Override
    public double calcularPagamentoMensal() {
        // Calcular pagamento mensal com a fórmula padrão de Financiamento
        double pagamentoMensal = super.calcularPagamentoMensal();

        // Adicionar taxa adicional de R$ 80
        pagamentoMensal += 80.0;

        return pagamentoMensal;
    }
}
