package funcoesDeOrdenacao.MergeSort;

import java.time.LocalDateTime;

public class MergeSortData {

    //Para o compareTo do LocalDateTime: Esse metodo compara a si com outra data, e retorna um valor int
	//a depender do resultado da comparação, o valor pode ser 0, -1 ou 1.

    private String[] csvLines;

	public MergeSortData(String[] csvLines) {
		this.csvLines = csvLines;
	}

	public void sort(LocalDateTime[] array) {
		sort(array, 1, array.length-1);
	}

    public void merge(LocalDateTime array[], int left, int meio, int rigth)
	{
		int size1 = meio - left + 1;
		int size2 = rigth - meio;
 
		//O mesmo que eu fiz no MergeSort normal so que com LocaleDateTime
		LocalDateTime leftList[] = new LocalDateTime[size1];
		LocalDateTime rigthList[] = new LocalDateTime[size2];

        String[] leftListCsv = new String[size1];
        String[] rigthListCsv = new String[size2]; 

		for (int i = 0; i < size1; ++i)
			leftList[i] = array[left + i];
		for (int j = 0; j < size2; ++j)
			rigthList[j] = array[meio + 1 + j];

        //*Copiar data das strings 
		//temos que fazer o meso para as linhas dos arquivos se quisermos ordenar
        for (int i = 0; i < size1; ++i)
			leftListCsv[i] = csvLines[left + i];
		for (int j = 0; j < size2; ++j)
			rigthListCsv[j] = csvLines[meio + 1 + j];

		int i = 0, j = 0;

		int k = left;
		while (i < size1 && j < size2) {
			if (leftList[i].compareTo(rigthList[j]) <= 0) { // L[i] <= R[j] **bastou modificar essa linha
				array[k] = leftList[i];
                csvLines[k] = leftListCsv[i];
				i++;
			}
			else {
				array[k] = rigthList[j];
                csvLines[k] = rigthListCsv[j];
				j++;
			}
			k++;
		}

		while (i < size1) {
			array[k] = leftList[i];
            csvLines[k] = leftListCsv[i];
			i++;
			k++;
		}

		while (j < size2) {
			array[k] = rigthList[j];
            csvLines[k] = rigthListCsv[j];
			j++;
			k++;
		}
	}

	private void sort(LocalDateTime array[] ,int left, int rigth)
	{
		if (left < rigth) {
			int m = left + (rigth - left) / 2;

			sort(array, left, m);
			sort(array,  m + 1, rigth);

			merge(array, left, m, rigth);
		}
	}
}
    
