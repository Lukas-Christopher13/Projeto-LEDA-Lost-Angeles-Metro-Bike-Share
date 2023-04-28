import java.util.Scanner;

public class InterfaceDuration {

    private static Scanner input = new Scanner(System.in);

    public static void tratarArquivoInterface() {
        System.out.print("\033[H\033[2J");

        System.out.println("Digite...");

        System.out.println("1-) Para Tratar o arquivo com HeapSort");
        System.out.println("2-) Para Tratar o arquivo com MergeSort");
        System.out.println("3-) Para Tratar o arquivo com InsertSort");
        System.out.println("4-) Para Tratar o arquivo com SelectionSort");
        System.out.println("5-) Para Tratar o arquivo com CountingSort");
        System.out.println("6-) Para Tratar o arquivo com QuickSort");
        System.out.println("7-) Para Tratar o arquivo com QuickSortM3");

        System.out.printf("\nDigite: ");
        int resposta = input.nextInt();
        GerarDurationFiles duration = new GerarDurationFiles();

        switch (resposta) {
            case 1:
                duration.gerarDurationHeap();
                pausa(5000);
                break;

            case 2:
                duration.gerarDurationMerge();
                break;

            case 3:
                duration.gerarInsertionSortDuration();
                break;
            case 4:
                duration.gerarSelectionSortDuration();
                break;
            case 5:
                duration.gerarCountingSortDuration();
                break;
            case 6:
                duration.gerarQuickSortDuration();
                break;
            case 7:
                duration.gerarQuickSortDurationM3();
                break;
            default:
                System.out.println("Valor invalido! Digite novamente!");
                pausa(5000);
                break;
        }
    }

    public static void pausa(long tempo) {
        try {
            Thread.sleep(tempo);
        } catch (Exception e) {
            System.err.println("Erro ao pausar a Thread");
        }
    }
}
