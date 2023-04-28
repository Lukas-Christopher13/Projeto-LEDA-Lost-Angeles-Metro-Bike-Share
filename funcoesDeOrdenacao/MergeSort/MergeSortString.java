package funcoesDeOrdenacao.MergeSort;

import java.util.Arrays;

public class MergeSortString {

	// Para o Arrays.compare: Se o primeiro argumento for menor que o segundo ele
	// retornar > 0

	public static void merge(String array[], String csvLines[], int left, int meio, int rigth) {
		int size1 = meio - left + 1;
		int size2 = rigth - meio;

		// O mesmo que eu fiz nos demais Merge sort
		String leftList[] = new String[size1];
		String rigthList[] = new String[size2];

		String[] leftListCsv = new String[size1];
		String[] rigthListCsv = new String[size2];

		for (int i = 0; i < size1; ++i)
			leftList[i] = array[left + i];
		for (int j = 0; j < size2; ++j)
			rigthList[j] = array[meio + 1 + j];

		// *Copia data das strings
		// temos que fazer o meso para as linhas dos arquivos se quisermos ordenar
		for (int i = 0; i < size1; ++i)
			leftListCsv[i] = csvLines[left + i];
		for (int j = 0; j < size2; ++j)
			rigthListCsv[j] = csvLines[meio + 1 + j];

		int i = 0, j = 0;

		int k = left;
		while (i < size1 && j < size2) {
			// compara os dois array de char e retorna um int a depender do resultado da
			// comparação
			// esse int pode ser 0, 1 ou -1
			if (Arrays.compare(leftList[i].toCharArray(), rigthList[j].toCharArray()) <= 0) { // L[i] <= R[j]
				array[k] = leftList[i];
				csvLines[k] = leftListCsv[i];
				i++;
			} else {
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

	public static void sort(String array[], String csvLines[], int left, int rigth) {
		if (left < rigth) {
			int meio = left + (rigth - left) / 2;

			sort(array, csvLines, left, meio);
			sort(array, csvLines, meio + 1, rigth);

			merge(array, csvLines, left, meio, rigth);
		}
	}
}
