public class Apartamento extends Financiamento {
    private int numVagas;
    private int numAndar;
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numAndar, int numVagas) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numAndar = numAndar;
        this.numVagas = numVagas;
    }



    @Override
    public double calcularPagamentoMensal() {
        // calcular pagamento mensal com a fórmula de amortização PRICE
        double taxaMensal = (getTaxaJurosAnual() / 12) / 100; // taxa mensal em decimal
        int totalParcelas = getPrazoFinanciamento() * 12; // total de parcelas

        double pagamentoMensal = (getValorImovel() * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -totalParcelas));

        return pagamentoMensal;
    }
}
