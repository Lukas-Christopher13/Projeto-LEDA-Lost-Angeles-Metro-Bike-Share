import java.util.Scanner;

public class InterfaceStation {

    private static Scanner input = new Scanner(System.in);

    public static void tratarArquivoInterface() {
        System.out.print("\033[H\033[2J");

        System.out.println("Digite...");

        System.out.println("1-) Para Tratar o arquivo com HeapSort");
        System.out.println("2-) Para Tratar o arquivo com MergeSort");
        System.out.println("3-) Para Tratar o arquivo com InsertionSort");
        System.out.println("4-) Para Tratar o arquivo com SelectionSort");
        System.out.println("5-) Para Tratar o arquivo com QuickSort");
         
        System.out.printf("\nDigite: ");
        int resposta = input.nextInt();
        GerarStationFiles station = new GerarStationFiles();

        switch (resposta) {
            case 1:
                station.gerarHeapSortStation();
                pausa(5000);
                break;

            case 2:
                station.gerarMergeSortStation();
                break;

            case 3:
                station.gerarInsertionSortStation();
                break;
            case 4:
                station.gerarSelectionSortStation();
                break;
            
            case 5:
                station.gerarQuickSortStation();
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
