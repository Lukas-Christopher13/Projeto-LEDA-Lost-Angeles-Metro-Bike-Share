package funcoesDeOrdenacao.InsertionSort;

public class InsertionSortString {

    public static void sort(String[] list, String[] csvLines) {
        String aux;
        String auxString;
        int i, j;

        for (i = 2; i < list.length; i++) {
            j = i - 1;
            aux = list[i];
            auxString = csvLines[i];
            while (j >= 1 && aux.compareTo(list[j]) <= -1) { // aux < list[j]
                list[j+1] = list[j];
                csvLines[j+1] = csvLines[j];
                j--;
            }
            list[j+1] = aux;
            csvLines[j+1] = auxString;
        }
    }
}