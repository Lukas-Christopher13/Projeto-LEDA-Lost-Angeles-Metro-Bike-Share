package funcoesDeOrdenacao.QuickSort;

import java.util.Stack;

public class QuickSortString {
    
    //tive que usar a Stack porque não cosegui outra forma de fazer o algoritimo funcionar
    //já que há um estouro na memoria recurciva decorrente das chamada recurciva da função 
    public static void sort(String[] array, String[] csvLines, int low, int high) {
        Stack<Integer> stack = new Stack<>();

        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            if (low < high) {
                int pi = partition(array, csvLines, low, high);

                stack.push(low);
                stack.push(pi - 1);

                stack.push(pi + 1);
                stack.push(high);
            }
        }
    }

    public static int partition(String[] array, String[] csvLines, int low, int high) {
        String pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
                swap(csvLines, i, j);
            }
        }
        swap(array, i + 1, high);
        swap(csvLines, i + 1, high);
        return i + 1;
    }

    public static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}