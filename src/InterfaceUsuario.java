import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner = new Scanner(System.in);

    public double pedirValorImovel() {  //também verifica o valor
        double valor;
        do {
            System.out.print("Digite o valor do imóvel: ");
            valor = scanner.nextDouble();
            if (valor <= 0) {
                System.out.println("O valor do imóvel deve ser positivo.");
            }
        } while (valor <= 0);
        return valor;
    }

    public double pedirTamanhoAreaConstruida() {
        System.out.print("Digite o tamanho da área construída: ");
        return scanner.nextDouble();
    }

    public double pedirTamanhoTerreno(){

        System.out.print("Digite o tamanho do terreno: ");
        return scanner.nextDouble();
    }

    public int pedirNumVagas(){

        System.out.print("Digite o número de vagas de garagem: ");
        return scanner.nextInt();
    }

    public int pedirNumAndar(){
        System.out.print("Digite o número do andar do apartamento: ");
        return scanner.nextInt();
    }

    public String pedirZonaTerreno(){

        System.out.print("Digite a zona do seu terreno, se ela é comercial ou residencial: ");
        return scanner.next();
    }


    public int pedirPrazoFinanciamento() { //verifica o valor do prazo
        int prazo;
        do {
            System.out.print("Digite o prazo do financiamento em anos: ");
            prazo = scanner.nextInt();
            if (prazo <= 0) {
                System.out.println("O prazo do financiamento deve ser positivo.");
            }
        } while (prazo <= 0);
        return prazo;
    }
    public double pedirTaxaJurosAnual() { //verifica a taxa
        double taxa;
        do {
            System.out.print("Digite a taxa de juros anual (%): ");
            taxa = scanner.nextDouble();
            if (taxa <= 0) {
                System.out.println("A taxa de juros anual deve ser positiva.");
            }
        } while (taxa <= 0);
        return taxa;
    }
}
