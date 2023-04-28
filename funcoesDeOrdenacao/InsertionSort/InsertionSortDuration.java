package funcoesDeOrdenacao.InsertionSort;

public class InsertionSortDuration {
    
    public static void sort(int[] list, String[] csvLines) {
        int aux;
        String auxString;
        int i, j;

        for (i = 1; i < list.length; i++) {
            j = i - 1;
            aux = list[i];
            auxString = csvLines[i];
            while (j >= 0 && aux < list[j]) {
                list[j + 1] = list[j];
                csvLines[j + 1] = csvLines[j];
                j--;
            }
            list[j + 1] = aux;
            csvLines[j + 1] = auxString;
        }
    }
}
