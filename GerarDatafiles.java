import java.time.LocalDateTime;

import csvUtil.AbrirArquivoCsv;
import csvUtil.Arquivo;
import csvUtil.CsvMetods;
import csvUtil.SortUtil;
import funcoesDeOrdenacao.BucketSortParaOQuickSort.BucketSort;
import funcoesDeOrdenacao.HeapSort.HeapSortDate;
import funcoesDeOrdenacao.MergeSort.MergeSortData;
import funcoesDeOrdenacao.QuickSort.QuickSortDate;
import funcoesDeOrdenacao.SelectionSort.SelectionSortDate;
import funcoesDeOrdenacao.InsertionSort.InsertionSortDate;
import funcoesDeOrdenacao.QuickSortM3.QuickSortM3Date;



public class GerarDatafiles {
    
    private final String melhorCaso = "/DadosCsvTratados/csvMelhorPiorEMedioCaso/LAMetroTrips_start_time_melhorCaso.csv";
    private final String medioCaso = "/DadosCsvTratados/LAMetroTrips.csv";
    private final String piorCaos = "/DadosCsvTratados/csvMelhorPiorEMedioCaso/LAMetroTrips_start_time_piorCaso.csv";

    private final String caminho = "/csvDadosOrdenados";

    private String[] csv;
    private String[] coluna;
    private LocalDateTime[] datas;

    public void abrirArquivoData(String caso) {
        final int start_time = 2;

        AbrirArquivoCsv testeSelectionSort = new AbrirArquivoCsv(caso);
        csv = testeSelectionSort.lerArquivo();

        CsvMetods csvMetods = new CsvMetods(csv);
        coluna = csvMetods.getColuna(start_time);

        datas = SortUtil.toDateTime(coluna);
    }

    public void gerarDataHeap() {
        //Data
        //*** Heap
        //Melhor caso Heap 
        abrirArquivoData(melhorCaso);
        HeapSortDate heapDM = new HeapSortDate(csv);
        heapDM.sort(datas);
        Arquivo.criarArquivoCsvRevesed(csv, 
        caminho + "/LAMetroTrips_start_time_HeapSort_melhorCaso.csv");
        //medio caso heap
        abrirArquivoData(medioCaso);
        HeapSortDate heapDMed = new HeapSortDate(csv);
        heapDMed.sort(datas);
        Arquivo.criarArquivoCsvRevesed(csv, 
        caminho + "/LAMetroTrips_start_time_HeapSort_medioCaso.csv");
        //pior caso heap
        abrirArquivoData(piorCaos);
        HeapSortDate heapDP = new HeapSortDate(csv);
        heapDP.sort(datas);
        Arquivo.criarArquivoCsvRevesed(csv, 
        caminho + "/LAMetroTrips_start_time_HeapSort_piorCaso.csv");
    }

    public void gerarDataMerge() {
        //***Merge 
        //Melhor caso Merge
        abrirArquivoData(melhorCaso);
        MergeSortData mergDM = new MergeSortData(csv);
        mergDM.sort(datas);
        Arquivo.criarArquivoCsvRevesed(csv, 
        caminho + "/LAMetroTrips_start_time_MergeSort_melhorCaso.csv");
        
        //Medio caso Merge
        abrirArquivoData(medioCaso);
        MergeSortData mergDMed = new MergeSortData(csv);
        mergDMed.sort(datas);
        Arquivo.criarArquivoCsvRevesed(csv, 
        caminho + "/LAMetroTrips_start_time_MergeSort_medioCaso.csv");
        
        //Pior caso Merge
        abrirArquivoData(piorCaos);
        MergeSortData mergDp = new MergeSortData(csv);
        mergDp.sort(datas);
        Arquivo.criarArquivoCsvRevesed(csv, 
        caminho + "/LAMetroTrips_start_time_MergeSort_piorCaso.csv");
    }

    public void gerarDataSelection() {
        //***Merge 
        //Melhor caso selection 
        abrirArquivoData(melhorCaso);
        SelectionSortDate selectDM = new SelectionSortDate(csv);
        selectDM.sort(datas);
        Arquivo.criarArquivoCsvRevesed(csv, 
        caminho + "/LAMetroTrips_start_time_SelectionSort_melhorCaso.csv");
        
        //Medio caso selection
        abrirArquivoData(medioCaso);
        SelectionSortDate selectDMed = new SelectionSortDate(csv);
        selectDMed.sort(datas);
        Arquivo.criarArquivoCsvRevesed(csv, 
        caminho + "/LAMetroTrips_start_time_SelectionSort_medioCaso.csv");
        
        //Pior caso selection
        abrirArquivoData(piorCaos);
        SelectionSortDate selectDp = new SelectionSortDate(csv);
        selectDp.sort(datas);
        Arquivo.criarArquivoCsvRevesed(csv, 
        caminho + "/LAMetroTrips_start_time_SelectionSort_piorCaso.csv");
    }

    public void gerarDataInsertion() {
        //***Merge 
        //Melhor caso selection 
        abrirArquivoData(melhorCaso);
        InsertionSortDate insertionDM = new InsertionSortDate(csv);
        insertionDM.sort(datas);
        Arquivo.criarArquivoCsvRevesed(csv, 
        caminho + "/LAMetroTrips_start_time_Insertion_melhorCaso.csv");
        
        //Medio caso selection
        abrirArquivoData(medioCaso);
        InsertionSortDate insertionDMed = new InsertionSortDate(csv);
        insertionDMed.sort(datas);
        Arquivo.criarArquivoCsvRevesed(csv, 
        caminho + "/LAMetroTrips_start_time_InsertionSort_medioCaso.csv");
        
        //Pior caso selection
        abrirArquivoData(piorCaos);
        InsertionSortDate insertionDp = new InsertionSortDate(csv);
        insertionDp.sort(datas);
        Arquivo.criarArquivoCsvRevesed(csv, 
        caminho + "/LAMetroTrips_start_time_InsertionSort_piorCaso.csv");
    }

    //Infelismente por conta da pouca memoria so conseguimos fazer com que o Quick
    //sort funcionase no medioc caso
    public void gerarDataQuickM3() {
        abrirArquivoData(medioCaso);

        QuickSortM3Date quickM3M = new QuickSortM3Date();
        quickM3M.sort(datas, csv);

        Arquivo.criarArquivoCsvRevesed(csv, 
        caminho + "/LAMetroTrips_start_time_QuickM3Sort_MedioCaso.csv");
    }

    //Infelismente consegui apenas gera o medio caso por conta da pouca memoria
    //consegui ainda cira um "bucket sort" bem precário para fazer com que o 
    //algoritimo de sem media funcionase.
    public void gerarDataQuick() {
        abrirArquivoData(medioCaso);

        QuickSortDate quickSortDate = new QuickSortDate();
        BucketSort bucketSort = new BucketSort();

        bucketSort.sort(quickSortDate, datas, csv);

        Arquivo.criarArquivoCsvRevesed(csv, 
        caminho + "/LAMetroTrips_start_time_QuickSort_MedioCaso.csv");
    }
}
