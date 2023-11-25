import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

//na interfaceUsuario o programa vai socilitar informações do valor do imovel, taxa de juros, aréa construida...
public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public double pedirValorImovel() {
        double valor = 0;
        boolean entradaValida = false;

        do {
            try {
                System.out.print("Digite o valor do imóvel: ");
                valor = scanner.nextDouble();

                if (valor <= 0) {
                    throw new IllegalArgumentException("O valor do imóvel deve ser positivo.");
                }

                entradaValida = true;

            } catch (InputMismatchException e) {
                System.out.println("Formato inválido. Digite um valor numérico válido.");
                scanner.nextLine(); // Limpar o buffer do scanner
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!entradaValida);

        return valor;
    }

    public int pedirPrazoFinanciamento() {
        int prazo = 0;
        boolean entradaValida = false;

        do {
            try {
                System.out.print("Digite o prazo de financiamento (em anos): ");
                prazo = scanner.nextInt();

                if (prazo <= 0) {
                    throw new IllegalArgumentException("O prazo de financiamento deve ser maior que zero.");
                }

                entradaValida = true;

            } catch (InputMismatchException e) {
                System.out.println("Formato inválido. Digite um valor numérico válido.");
                scanner.nextLine(); // Limpar o buffer do scanner
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!entradaValida);

        return prazo;
    }

    public double pedirTaxaJurosAnual() {
            double taxa = 0;
            boolean entradaValida = false;

            do {
                try {
                    System.out.print("Digite a taxa de juros anual (em porcentagem): ");
                    String taxaStr = scanner.next(); // Obtemos uma string
                    taxa = Double.parseDouble(taxaStr.replace(',', '.')); // Substituímos vírgula por ponto e convertemos para double

                    if (taxa <= 0) {
                        throw new IllegalArgumentException("A taxa de juros anual deve ser maior que zero.");
                    }

                    entradaValida = true;

                } catch (NumberFormatException e) {
                    System.out.println("Formato inválido. Digite um valor numérico válido.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!entradaValida);

            return taxa;
        }

    public double pedirTamanhoAreaConstruida() {
        double tamanho = 0;
        boolean entradaValida = false;

        do {
            try {
                System.out.print("Digite o tamanho da área construída: ");
                tamanho = scanner.nextDouble();

                if (tamanho <= 0) {
                    throw new IllegalArgumentException("O tamanho da área construída deve ser maior que zero.");
                }

                entradaValida = true;

            } catch (InputMismatchException e) {
                System.out.println("Formato inválido. Digite um valor numérico válido.");
                scanner.nextLine(); // Limpar o buffer do scanner
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!entradaValida);

        return tamanho;
    }

    public double pedirTamanhoTerreno() {
        double tamanho = 0;
        boolean entradaValida = false;

        do {
            try {
                System.out.print("Digite o tamanho do terreno: ");
                tamanho = scanner.nextDouble();

                if (tamanho <= 0) {
                    throw new IllegalArgumentException("O tamanho do terreno deve ser maior que zero.");
                }

                entradaValida = true;

            } catch (InputMismatchException e) {
                System.out.println("Formato inválido. Digite um valor numérico válido.");
                scanner.nextLine(); // Limpar o buffer do scanner
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!entradaValida);

        return tamanho;
    }

    public int pedirNumAndar() {
        int numAndar = 0;
        boolean entradaValida = false;

        do {
            try {
                System.out.print("Digite o número do andar: ");
                numAndar = scanner.nextInt();

                if (numAndar <= 0) {
                    throw new IllegalArgumentException("O número do andar deve ser maior que zero.");
                }

                entradaValida = true;

            } catch (InputMismatchException e) {
                System.out.println("Formato inválido. Digite um valor numérico válido.");
                scanner.nextLine(); // Limpar o buffer do scanner
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!entradaValida);

        return numAndar;
    }

    public int pedirNumVagas() {
        int numVagas = 0;
        boolean entradaValida = false;

        do {
            try {
                System.out.print("Digite o número de vagas de estacionamento: ");
                numVagas = scanner.nextInt();

                if (numVagas < 0) {
                    throw new IllegalArgumentException("O número de vagas de estacionamento não pode ser negativo.");
                }

                entradaValida = true;

            } catch (InputMismatchException e) {
                System.out.println("Formato inválido. Digite um valor numérico válido.");
                scanner.nextLine(); // Limpar o buffer do scanner
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!entradaValida);

        return numVagas;
    }

    public String pedirZonaTerreno() {
        String zona = "";
        boolean entradaValida = false;

        do {
            try {
                System.out.print("Digite a zona do terreno, se é comercial ou residencial: ");
                zona = scanner.next();

                if (zona.trim().isEmpty()) {
                    throw new IllegalArgumentException("A zona do terreno não pode ser vazia.");
                }

                entradaValida = true;

            } catch (InputMismatchException e) {
                System.out.println("Formato inválido. Digite um valor válido.");
                scanner.nextLine(); // Limpar o buffer do scanner
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!entradaValida);

        return zona;
    }

    public void fecharScanner() {
        scanner.close();
    }
}
