package funcoesDeOrdenacao.QuickSort;

import java.time.LocalDateTime;

import funcoesDeOrdenacao.BucketSortParaOQuickSort.IQuickSortDate;

public class QuickSortDate implements IQuickSortDate{

    private String[] lines;

    public void sort(LocalDateTime[] array, String[] csvLines ){   
        this.lines = csvLines;     
        quicksortMedianaDeTres(array, 0, array.length - 1);
    }

    private void quicksortMedianaDeTres(LocalDateTime[] array, int inicio, int fim){        
        if(inicio < fim){
            int q = partition(array, inicio, fim);
            quicksortMedianaDeTres(array, inicio, q - 1);
            quicksortMedianaDeTres(array, q + 1, fim);            
        }
    }
    
    private int partition(LocalDateTime[] array, int inicio, int fim){
        LocalDateTime pivo = array[fim];
        int i = inicio - 1;
        
        for(int j = inicio; j <= fim - 1; j++){
            if(array[j].compareTo(pivo) <= 0){
                i = i + 1;
                swap(array, i, j);
                swapCsvLine(i, j);
            }
        }
        swap(array, i + 1, fim);
        swapCsvLine(i + 1, fim);
        return i + 1; 
    }
    
    private void swap(LocalDateTime[] array, int i, int j){
        LocalDateTime temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private void swapCsvLine (int i, int j) {
        String temp = lines[i];
        lines[i] = lines[j];
        lines[j] = temp;
    }
}

    
