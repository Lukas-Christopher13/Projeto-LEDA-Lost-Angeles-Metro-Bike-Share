package funcoesDeOrdenacao.QuickSortM3;

public class QuickSortM3Duration {

    private String[] lines;

    public QuickSortM3Duration(String[] csvLines) {
        this.lines = csvLines;
    }

    public void sort(int[] array) {
        quicksortBudge(array, 0, array.length - 1);
    }

    private void quicksortBudge(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            final int THRESHOLD = 10;
            if (fim - inicio + 1 <= THRESHOLD) {
                insertionSort(array, inicio, fim);
            } else {

                int pivo = medianaDeTres(array, inicio, fim);
                int i = inicio - 1, j = fim + 1;
                while (true) {
                    
                    do {
                        i++;
                    } while (array[i] < pivo);
                   
                    do {
                        j--;
                    } while (array[j] > pivo);
                    
                    if (i >= j) {
                        break;
                    }
                   
                    swap(array, i, j);
                    swapCsvLine(i, j);
                }
               
                quicksortBudge(array, inicio, i);
                quicksortBudge(array, i + 1, fim);
            }
        }
    }
    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private void swapCsvLine (int i, int j) {
        String temp = lines[i];
        lines[i] = lines[j];
        lines[j] = temp;
    }
    
    private int medianaDeTres(int[] array, int inicio, int fim) {
        int meio = (inicio + fim) / 2;
        if (array[inicio] > array[meio]) {
            swap(array, inicio, meio);
            swapCsvLine(inicio, meio);
        }
        if (array[inicio] > array[fim]) {
            swap(array, inicio, fim);
            swapCsvLine(inicio, fim);
        }
        if (array[meio] > array[fim]) {
            swap(array, meio, fim);
            swapCsvLine(meio, fim);
        }
       
        swap(array, meio, fim - 1);
        swapCsvLine(meio, fim - 1);
        return array[fim - 1];
    }

    private void insertionSort(int[] A, int inicio, int fim) {
        for (int i = inicio + 1; i <= fim; i++) {
            int chave = A[i];
            int j = i - 1;
            while (j >= inicio && A[j] > chave) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = chave;
        }
    }
}