public class Terreno extends Financiamento {

    private String zonaTerreno;

    //inicia os métodos
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String zonaTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.zonaTerreno = zonaTerreno;
    }
    public double calcularPagamentoMensal() { //calcula o pagamento
        double pagamentoMensal = super.calcularPagamentoMensal();
        pagamentoMensal *= 1.02;
        return pagamentoMensal;
    }
}