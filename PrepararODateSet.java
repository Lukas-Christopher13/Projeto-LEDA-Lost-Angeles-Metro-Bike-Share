//minhas classes
import PassosParaTratarOArquivo.P0ConcertarDatas;
import PassosParaTratarOArquivo.P1SubistituirId;
import csvUtil.AbrirArquivoCsv;
import csvUtil.Arquivo;
import csvUtil.CsvMetods;

public class PrepararODateSet {
    
    private final String registroDeLocacaoFile = "/DadosCsv/LA_Metro_BikeSharing_CLEANED_2016quater3-2021q3.csv";
    private final String estcoesPorIdFile = "/DadosCsv/stations.csv";

    private String[] registroDeLocacaoDeBicicletas;
    private String[] estacoesCsv;

    public PrepararODateSet(){
        AbrirArquivoCsv biciletas = new AbrirArquivoCsv(registroDeLocacaoFile);
        AbrirArquivoCsv estacoes = new AbrirArquivoCsv(estcoesPorIdFile);

        this.registroDeLocacaoDeBicicletas = biciletas.lerArquivo();
        this.estacoesCsv = estacoes.lerArquivo();
        concertarDatas();
    }
    
    //Esse trecho de coidigo "corrige" o problemas das datas, ou devia corrigir...
    private void concertarDatas(){
        CsvMetods conDat = new CsvMetods(registroDeLocacaoDeBicicletas);

        String[] startDate = conDat.getColuna(2); //criar uma constante dps
        String[] endDate = conDat.getColuna(3);

        P0ConcertarDatas corrigirStartDatas = new P0ConcertarDatas(startDate);
        String[] startDateCorrigido =  corrigirStartDatas.corrigirDatas();

        P0ConcertarDatas corrigeirEndDatas = new P0ConcertarDatas(endDate);
        String[] endDateCorrigido = corrigeirEndDatas.corrigirDatas();

        CsvMetods csvMetods = new CsvMetods(registroDeLocacaoDeBicicletas);
        csvMetods.setColuna(startDateCorrigido, 2);
        csvMetods.setColuna(endDateCorrigido, 3);
    }

    public void subistituirIdPelasEstacoes() {
        P1SubistituirId subId = new P1SubistituirId(registroDeLocacaoDeBicicletas, estacoesCsv);
        
        subId.subistituirIdPorEstcoes();
        Arquivo.criarArquivoCsv(registroDeLocacaoDeBicicletas, "/LAMetroTrips.csv");
        
        System.out.println("Arquivo gerado!");
    }    
}
