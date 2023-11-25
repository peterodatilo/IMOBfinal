public class Apartamento extends Financiamento {
    private int numVagas;
    private int numAndar;

    //tabém incia os métodos
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numAndar, int numVagas) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numAndar = numAndar;
        this.numVagas = numVagas;
    }

    @Override // calcula os valores com os parametros
    public double calcularPagamentoMensal()  {
        double taxaMensal = (getTaxaJurosAnual() / 12) / 100;
        int totalParcelas = getPrazoFinanciamento() * 12;

        double pagamentoMensal = (getValorImovel() * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -totalParcelas));

        return pagamentoMensal;
    }
}
