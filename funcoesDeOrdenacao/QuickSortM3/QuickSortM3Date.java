package funcoesDeOrdenacao.QuickSortM3;

import java.time.LocalDateTime;

import funcoesDeOrdenacao.BucketSortParaOQuickSort.IQuickSortDate;

public class QuickSortM3Date implements IQuickSortDate{

    private String[] lines;

    public void sort(LocalDateTime[] array, String[] csvLines){
        this.lines = csvLines;        
        quicksortMedianaDeTres(array, 1, array.length - 1);
    }

    private void quicksortMedianaDeTres(LocalDateTime[] array, int inicio, int fim){        
        if(inicio < fim){
            int q = partition(array, inicio, fim);
            quicksortMedianaDeTres(array, inicio, q - 1);
            quicksortMedianaDeTres(array, q + 1, fim);            
        }
    }
    
    private int partition(LocalDateTime[] array, int inicio, int fim){
        //Mediana de 3
        int meio = (inicio + fim)/2;
        LocalDateTime valorDoInicio = array[inicio];
        LocalDateTime valorDoMeio = array[meio];
        LocalDateTime valorFinal = array[fim];
        int medianaIndice;

        if(valorDoInicio.compareTo(valorDoMeio) < -1){ //a < b
            if(valorDoMeio.compareTo(valorFinal) < -1){
                medianaIndice = meio;
            }else{                
                if(valorDoInicio.compareTo(valorFinal) < -1){
                    medianaIndice = fim;
                }else{
                    medianaIndice = inicio;
                }
            }
        }else{
            if(valorFinal.compareTo(valorDoMeio) < -1){
                medianaIndice = meio;
            }else{
                if(valorFinal.compareTo(valorDoInicio) < -1){
                    medianaIndice = fim;
                }else{
                    medianaIndice = inicio;
                }
            }
        }
        
        swap(array, medianaIndice, fim);
        swapCsvLine(medianaIndice, fim);
        
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

    
