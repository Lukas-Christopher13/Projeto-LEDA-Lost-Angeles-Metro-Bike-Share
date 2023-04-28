package funcoesDeOrdenacao.BucketSortParaOQuickSort;

import java.time.LocalDateTime;


public class BucketSort {
	private LocalDateTime[] bucket16;
	private String[]csv16;
	private	LocalDateTime[] bucket17;
	private String[]csv17;
	private	LocalDateTime[] bucket18;
	private String[]csv18;
	private	LocalDateTime[] bucket19;
	private String[]csv19;
	private	LocalDateTime[] bucket20;
	private String[]csv20;
	private	LocalDateTime[] bucket21;
	private String[]csv21;

	public void sort(IQuickSortDate quickSortDate, LocalDateTime[] datas, String csvLines[]) {
		loadBucktes(datas, csvLines);

		quickSortDate.sort(bucket16, csv16);
		quickSortDate.sort(bucket17, csv17);
		quickSortDate.sort(bucket18, csv18);
		quickSortDate.sort(bucket19, csv19);
		quickSortDate.sort(bucket20, csv20);
		quickSortDate.sort(bucket21, csv21);

		merge(datas.length);
	}

	public void loadBucktes(LocalDateTime[] datas, String[] csvLines) {
		int[] size = countIntens(datas);
        //arrays 
		bucket16 = new LocalDateTime[size[0]];
		csv16 = new String[size[0]];
		bucket17 = new LocalDateTime[size[1]];
		csv17 = new String[size[1]];
		bucket18 = new LocalDateTime[size[2]];
		csv18 = new String[size[2]];
		bucket19 = new LocalDateTime[size[3]];
		csv19 = new String[size[3]];
	    bucket20 = new LocalDateTime[size[4]];
		csv20 = new String[size[4]];
		bucket21 = new LocalDateTime[size[5]];
		csv21 = new String[size[5]];

		int count16 = 0;
		int count17 = 0;
		int count18 = 0;
		int count19 = 0;
		int count20 = 0;
		int count21 = 0;

		for(int i = 1; i < datas.length; i++) {
            switch (datas[i].getYear()) {
                case 2016:
				    bucket16[count16] = datas[i];
					csv16[count16] = csvLines[i];
                    count16++;
                    break;
                case 2017:
				    bucket17[count17] = datas[i];
					csv17[count17] = csvLines[i];
				    count17++;
                    break;
                case 2018:
				    bucket18[count18] = datas[i];
					csv18[count18] = csvLines[i];
				    count18++;
                    break;
                case 2019:
				    bucket19[count19] = datas[i];
					csv19[count19] = csvLines[i];
				    count19++;
                    break;
                case 2020:
				    bucket20[count20] = datas[i];
					csv20[count20] = csvLines[i];
				    count20++;
                    break;
                case 2021:
				    bucket21[count21] = datas[i];
					csv21[count21] = csvLines[i];
				    count21++;
                    break;
            }
        }
	}
   
    public static int[] countIntens(LocalDateTime[] datas) {
        int[] conuntArray = new int[6];

        for(int i = 1; i < datas.length; i++) {
            switch (datas[i].getYear()) {
                case 2016:
                    conuntArray[0]++;
                    break;
                case 2017:
                    conuntArray[1]++;
                    break;
                case 2018:
                    conuntArray[2]++;
                    break;
                case 2019:
                    conuntArray[3]++;
                    break;
                case 2020:
                    conuntArray[4]++;
                    break;
                case 2021:
                    conuntArray[5]++;
                    break;
            }
        }
        return conuntArray;
    }

	public String[] merge(int arraySize) {
		String[] sortedCsv = new String[arraySize];

	    int i = 1;
        //16
		for(int j = 0;i < csv16.length; i++) {
			sortedCsv[i] = csv16[j];
			j++;
		}
        //17
		for(int j = 0;i < csv17.length; i++) {
			sortedCsv[i] = csv17[j];
			j++;
		}
        //18
		for(int j = 0;i < csv18.length; i++) {
			sortedCsv[i] = csv18[j];
			j++;
		}
        //19
		for(int j = 0;i < csv19.length; i++) {
			sortedCsv[i] = csv19[j];
			j++;
		}
        //20
		for(int j = 0;i < csv20.length; i++) {
			sortedCsv[i] = csv20[j];
			j++;
		}
        //21
		for(int j = 0;i < csv21.length; i++) {
			sortedCsv[i] = csv21[j];
			j++;
		}

		return sortedCsv;
	}
	
}
