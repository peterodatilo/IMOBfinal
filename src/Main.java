import java.text.DecimalFormat;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;


public class Main {
    private static final String NOME_ARQUIVO = "dados_financiamentos.txt";
    private static final DecimalFormat df = new DecimalFormat("#,###,##0.00");
    private static final InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

    public static void main(String[] args) {
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        // slicitar informações para duas casas
        for (int i = 1; i <= 2; i++) {
            Casa casa = criarCasa();
            financiamentos.add(casa);
        }

        // solicitar informações para o apartamento
        Apartamento apartamento = criarApartamento();
        financiamentos.add(apartamento);

        // solicitar informações para o terreno
        Terreno terreno = criarTerreno();
        financiamentos.add(terreno);

        // calcular totais e exibir resultados
        calcularEExibirTotais(financiamentos);

        // salvar dados em arquivo
        salvarDadosEmArquivo(financiamentos, NOME_ARQUIVO);

        // ler dados do arquivo e exibir novamente
        ArrayList<Financiamento> financiamentosLidos = lerDadosDeArquivo(NOME_ARQUIVO);
        calcularEExibirTotais(financiamentosLidos);
    }

    private static Casa criarCasa() {
        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();
        double tamanhoAreaConstruida = interfaceUsuario.pedirTamanhoAreaConstruida();
        double tamanhoTerreno = interfaceUsuario.pedirTamanhoTerreno();
        return new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, tamanhoAreaConstruida, tamanhoTerreno);
    }

    private static Apartamento criarApartamento() {
        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();
        int numAndar = interfaceUsuario.pedirNumAndar();
        int numVagas = interfaceUsuario.pedirNumVagas();
        return new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, numAndar, numVagas);
    }

    private static Terreno criarTerreno() {
        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();
        String zonaTerreno = interfaceUsuario.pedirZonaTerreno();
        return new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, zonaTerreno);
    }

    private static void calcularEExibirTotais(ArrayList<Financiamento> financiamentos) {
        double totalImoveis = 0.0;
        double totalFinanciamentos = 0.0;

        for (Financiamento financiamento : financiamentos) {
            totalImoveis += financiamento.getValorImovel();
            totalFinanciamentos += financiamento.calcularTotalDoPagamento();
        }

        System.out.println("Total de todos os imóveis: R$" + df.format(totalImoveis));
        System.out.println("Total de todos os financiamentos: R$" + df.format(totalFinanciamentos));
    }

    private static void salvarDadosEmArquivo(ArrayList<Financiamento> financiamentos, String nomeArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(financiamentos);
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private static ArrayList<Financiamento> lerDadosDeArquivo(String nomeArquivo) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            Object obj = inputStream.readObject();
            if (obj instanceof ArrayList) {
                System.out.println("Dados lidos com sucesso.");
                return (ArrayList<Financiamento>) obj;
            } else {
                System.out.println("Erro ao ler dados: formato inválido.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler dados: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}