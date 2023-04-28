package funcoesDeOrdenacao.SelectionSort;

public class SelectionSortDuration {

    public static void sort(int list[], String csvLines[]){
        int min;
        int i,j;

        for(i = 1; i < list.length; i++){
            min = i;
            for(j = i+1; j < list.length; j++){
                if(list[j] < list[min]){  
                    min = j;
                }
            }
            int temp = list[min];
            list[min] = list[i];
            list[i] = temp;

            //swap arquivo csv
            String Stemp = csvLines[min];
            csvLines[min] = csvLines[i];
            csvLines[i] = Stemp;
        }
    }
}
