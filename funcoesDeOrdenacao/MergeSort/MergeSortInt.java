package funcoesDeOrdenacao.MergeSort;


public class MergeSortInt {
	
    
	public static void merge(int array[], String csvLines[], int left, int meio, int rigth)
	{
		int size1 = meio - left + 1;
		int size2 = rigth - meio;

		int leftList[] = new int[size1];
		int rigthList[] = new int[size2];

		//criei esse trexo para que ele ordena-se as linhas do arquivo
        String[] leftListCsv = new String[size1];
        String[] rigthListCsv = new String[size2]; 

		for (int i = 0; i < size1; ++i)
			leftList[i] = array[left + i];
		for (int j = 0; j < size2; ++j)
			rigthList[j] = array[meio + 1 + j];

	    //Tivi que duplicar esse trecho do arquivo para que enquanto ele ordena-se a
		//coluna de elementos ele tambem ordena-se a linhas do arquvio que estão em formato de array
        for (int i = 0; i < size1; ++i)
			leftListCsv[i] = csvLines[left + i];
		for (int j = 0; j < size2; ++j)
			rigthListCsv[j] = csvLines[meio + 1 + j];

		
		int i = 0, j = 0;

		int k = left;
		while (i < size1 && j < size2) {
			if (leftList[i] <= rigthList[j]) {
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

	//Função que inicia o sort!
	public static void sort(int array[], String csvLines[] ,int left, int rigth)
	{
		if (left < rigth) {
			int meio = left + (rigth - left) / 2;

			sort(array, csvLines, left, meio);
			sort(array, csvLines, meio + 1, rigth);

			merge(array, csvLines, left, meio, rigth);
		}
	}
}

