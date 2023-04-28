package funcoesDeOrdenacao.QuickSort;

public class QuickSortDuration {

    private String[] lines;

    public QuickSortDuration(String[] csvLines) {
        this.lines = csvLines;
    }

    public void sort(int[] array) {
        quicksortIterative(array);
    }

    private void quicksortIterative(int[] array) {
        int inicio = 0;
        int fim = array.length - 1;
        int[] pilha = new int[fim - inicio + 1];
        int topo = -1;

        // empilha os limites da primeira partição
        pilha[++topo] = inicio;
        pilha[++topo] = fim;

        // loop principal
        while (topo >= 0) {
            // desempilha os limites da partição atual
            fim = pilha[topo--];
            inicio = pilha[topo--];

            // escolhe o pivô
            int pivo = array[(inicio + fim) / 2];

            // divide o array em duas partições
            int i = inicio, j = fim;
            while (i <= j) {
                while (array[i] < pivo) {
                    i++;
                }
                while (array[j] > pivo) {
                    j--;
                }
                if (i <= j) {
                    swap(array, i, j);
                    swapCsvLine(i, j);
                    i++;
                    j--;
                }
            }

            // empilha as partições que ainda precisam ser ordenadas
            if (inicio < j) {
                pilha[++topo] = inicio;
                pilha[++topo] = j;
            }
            if (i < fim) {
                pilha[++topo] = i;
                pilha[++topo] = fim;
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void swapCsvLine(int i, int j) {
        String temp = lines[i];
        lines[i] = lines[j];
        lines[j] = temp;
    }
}
