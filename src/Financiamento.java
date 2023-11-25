import java.io.Serializable;

public class Financiamento implements Serializable {

    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    //inicializa a classe e os métodos
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }


     //calcula os pagamentos com os parametros establecidos
    public double calcularPagamentoMensal() {
        double taxaMensal = (taxaJurosAnual / 12) / 100; // taxa mensal em decimal
        int totalParcelas = prazoFinanciamento * 12; // total de parcelas

        double pagamentoMensal = (valorImovel * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -totalParcelas));
        return pagamentoMensal;
    }

    public double calcularTotalDoPagamento() {
        return calcularPagamentoMensal() * (prazoFinanciamento * 12);
    }
}
