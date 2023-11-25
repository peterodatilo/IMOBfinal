public class Casa extends Financiamento {

    private double tamanhoAreaConstruida;
    private double tamanhoTerreno;

    //inicia os métodos
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double tamanhoAreaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tamanhoAreaConstruida = tamanhoAreaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public double calcularPagamentoMensal(double desconto) throws DescontoMaiorDoQueJurosException {
        double pagamentoMensal = super.calcularPagamentoMensal();
        pagamentoMensal += 80.0;

        double jurosMensais = super.calcularPagamentoMensal() - super.getValorImovel();

        if (desconto > jurosMensais) {
            throw new DescontoMaiorDoQueJurosException("O desconto não pode ser maior do que o valor dos juros.");
        }

        pagamentoMensal -= desconto;

        return pagamentoMensal;
    }
}
