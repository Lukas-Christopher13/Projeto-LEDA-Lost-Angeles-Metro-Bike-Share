package funcoesDeOrdenacao.HeapSort;

public class HeapSortInt {

    private String[] lines;

    public HeapSortInt(String[] csvLines){
        this.lines = csvLines;
    }

	public void sort(int array[])
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

	void heapify(int array[], int n, int i)
	{
		int largest = i; 
		int left = 2 * i + 1; 
		int right = 2 * i + 2; 

		if (left < n && array[left] > array[largest])
			largest = left;

		if (right < n && array[right] > array[largest])
			largest = right;

		if (largest != i) {
            swap(array, i, largest);
            swapCsvLine(i, largest);
			
			heapify(array, n, largest);
		}
	}
	
    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void swapCsvLine (int i, int j) {
        String temp = lines[i];
        lines[i] = lines[j];
        lines[j] = temp;
    }
}
