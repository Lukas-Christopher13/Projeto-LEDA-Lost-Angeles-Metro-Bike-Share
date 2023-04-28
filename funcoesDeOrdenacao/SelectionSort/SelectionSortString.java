package funcoesDeOrdenacao.SelectionSort;

public class SelectionSortString {

    public String[] csvLines;

    public SelectionSortString(String[] csvLines) {
        this.csvLines = csvLines;
    }

    public void sort(String[] list) {
        int min;
        int i,j;

        for(i = 1; i < list.length; i++){
            min = i;
            for(j = i+1; j < list.length; j++){
                if(list[j].compareTo(list[min]) < 0 ){  //list[j] < list[min]
                    min = j;
                }
            }
            String temp = list[min];
            list[min] = list[i];
            list[i] = temp;

            //swap arquivo csv
            String Stemp = csvLines[min];
            csvLines[min] = csvLines[i];
            csvLines[i] = Stemp;
        }
    }
}
