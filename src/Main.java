import java.util.ArrayList;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("#,###,##0.00");

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // Solicitar dados do usuário para um financiamento genérico
        double valorImovel;
        int prazoFinanciamento;
        double taxaJurosAnual;

        valorImovel = interfaceUsuario.pedirValorImovel();
        prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
        taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();


        // Criar financiamentos específicos (Casa, Apartamento e Terreno) diretamente no código
        double tamanhoAreaConstruida = interfaceUsuario.pedirTamanhoAreaConstruida();
        double tamanhoTerreno = interfaceUsuario.pedirTamanhoTerreno();
        financiamentos.add(new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, tamanhoAreaConstruida, tamanhoTerreno));

        int numAndar = interfaceUsuario.pedirNumAndar();
        int numVagas = interfaceUsuario.pedirNumVagas();
        financiamentos.add(new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, numAndar, numVagas));

        String zonaTerreno = interfaceUsuario.pedirZonaTerreno();
        financiamentos.add(new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, zonaTerreno));


        // Cálculo dos valores totais
        double totalImóveis = 0;
        double totalFinanciamentos = 0;

        for (Financiamento financiamento : financiamentos) {
            totalImóveis += financiamento.getValorImovel();
            totalFinanciamentos += financiamento.calcularTotalDoPagamento();
        }

        System.out.println("Total de todos os imóveis: R$" + df.format(totalImóveis));
        System.out.println("Total de todos os financiamentos: R$" + df.format(totalFinanciamentos));
    }
}
