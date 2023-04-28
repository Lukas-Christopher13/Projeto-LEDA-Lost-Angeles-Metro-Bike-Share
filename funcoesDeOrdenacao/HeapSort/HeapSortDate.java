package funcoesDeOrdenacao.HeapSort;

import java.time.LocalDateTime;

public class HeapSortDate {

    private String[] lines;

    public HeapSortDate(String[] csvLines){
        this.lines = csvLines;
    }

	public void sort(LocalDateTime array[])
	{
		int size = array.length;

		for (int i = size / 2 - 1; i >= 1; i--)
			heapify(array, size, i);

		for (int i = size - 1; i >= 0; i--) {
            swap(array, 0, i);
            swapCsvLine(0, i);
			
			heapify(array, i, 0);
		}
	}

	void heapify(LocalDateTime array[], int n, int i)
	{
		int largest = i; 
		int left = 2 * i + 1; 
		int right = 2 * i + 2; 

		if (left < n && array[left].compareTo(array[largest]) > -1) //array[l] > array[largest]
			largest = left;

		if (right < n && array[right].compareTo(array[largest]) > -1) //array[r] > array[largest]
			largest = right;

		if (largest != i) {
            swap(array, i, largest);
            swapCsvLine(i, largest);
			
			heapify(array, n, largest);
		}
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
