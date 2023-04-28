//Esse arquivo gera dois arquivos com o melhor, e pior
//caso para a ordenação.
import java.time.LocalDateTime;
import csvUtil.AbrirArquivoCsv;
import csvUtil.Arquivo;
import csvUtil.CsvMetods;
import csvUtil.SortUtil;
import funcoesDeOrdenacao.MergeSort.MergeSortInt;
import funcoesDeOrdenacao.MergeSort.MergeSortData;
import funcoesDeOrdenacao.MergeSort.MergeSortString;

//*Caso tenho problemas em gerar os arquivos de pior e melhor caso altere...
//private final String LAMetroTrips = "/DadosCsvTratados/LAMetroTrips.csv";
//para
//private final String LAMetroTrips = "/DadosCsvTratados/csvMelhorPiorEMedioCaso/LAMetroTrips.csv";

public class GerarCasos {
    private final String LAMetroTrips = "/DadosCsvTratados/csvMelhorPiorEMedioCaso/LAMetroTrips.csv";

    private final int duration = 1;
    private final int start_station = 9;
    private final int start_time = 2;

    public String[] arquivoCsv;

    public String[] coluna;
    public int[] intColuna;
    public LocalDateTime[] dateColuna;


    public void gerarTabelComTodosOsCasosPorEstacao() {
        lerArquivoEColuna(start_station);

        MergeSortString.sort(coluna, arquivoCsv, 1, coluna.length-1);

        //Melhor Caso
        Arquivo.criarArquivoCsv(arquivoCsv, "/csvMelhorPiorEMedioCaso/LAMetroTrips_station_melhorCaso.csv");
        //Pior Caso
        Arquivo.criarArquivoCsvRevesed(arquivoCsv, "/csvMelhorPiorEMedioCaso/LAMetroTrips_station_piorCaso.csv");

        System.out.println("Pior e Melhor casos por Estção foram gerados!");
    }

    public void gerarTabelComTodosOsCasosPorDuracaoDeViagem() {
        lerArquivoEColuna(duration);

        intColuna = SortUtil.toIntArray(coluna);
        MergeSortInt.sort(intColuna, arquivoCsv, 0, intColuna.length-1);

        //Melhor Caso
        Arquivo.criarArquivoCsv(arquivoCsv, "/csvMelhorPiorEMedioCaso/LAMetroTrips_duration_melhorCaso.csv");
        //Pior Caso
        Arquivo.criarArquivoCsvRevesed(arquivoCsv, "/csvMelhorPiorEMedioCaso/LAMetroTrips_duration_piorCaso.csv");

        System.out.println("Pior e Melhor casos por Duração de viagem foram gerados!");
    }

    public void gerarTabelComTodosOsCasosPorData() {
        lerArquivoEColuna(start_time);

        this.dateColuna = SortUtil.toDateTime(coluna);

        MergeSortData merge = new MergeSortData(arquivoCsv);
        merge.sort(dateColuna);

        //Melhor caso
        Arquivo.criarArquivoCsvRevesed(arquivoCsv, "/csvMelhorPiorEMedioCaso/LAMetroTrips_start_time_melhorCaso.csv");
        //Pior caso
        Arquivo.criarArquivoCsv(arquivoCsv, "/csvMelhorPiorEMedioCaso/LAMetroTrips_start_time_piorCaso.csv");

        System.out.println("Pior e Melhor casos por Data inicial de viagem foram gerados!");
    }

    private void lerArquivoEColuna (int coluna){
        AbrirArquivoCsv aba = new AbrirArquivoCsv(LAMetroTrips);
        this.arquivoCsv = aba.lerArquivo();

        CsvMetods csvM = new CsvMetods(arquivoCsv);
        this.coluna = csvM.getColuna(coluna);
    } 
}
