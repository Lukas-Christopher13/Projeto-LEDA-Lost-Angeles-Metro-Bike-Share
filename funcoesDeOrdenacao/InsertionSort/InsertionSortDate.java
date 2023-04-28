package funcoesDeOrdenacao.InsertionSort;

import java.time.LocalDateTime;

public class InsertionSortDate {

    private String[] csvLines;

    public InsertionSortDate(String[] csvLines) {
        this.csvLines = csvLines;
    }

    public void sort(LocalDateTime[] list){
        LocalDateTime aux;
        String auxString;
        int i,j;

        //O dois no 'i' é porque todo lista de datas tem o primeiro elemento null
        for(i = 2; i < list.length; i++){
            j = i -1;
            aux = list[i];
            auxString = csvLines[i]; 
            while(j >= 1 && aux.compareTo(list[j]) < 0){ // aux < list[j]
                list[j+1] = list[j];
                //para o csv
                csvLines[j+1] = csvLines[j];
                j--;
            }
            list[j+1] = aux;
            //para o csv
            csvLines[j+1] = auxString;
        }
    }
}