import java.util.Scanner;

import java.io.File;
import PassosParaTratarOArquivo.P2FiltrarStationName;
import PassosParaTratarOArquivo.P3FiltrarMedia;

public class Interface {

    private static Scanner input = new Scanner(System.in);

    public static void tratarArquivoInterface() {
        System.out.print("\033[H\033[2J");

        System.out.println("Digite...");

        System.out.println("1-) Para subistituir os ids pelo nome das estações ");
        System.out.println("2-) Para filtrar por Pasadena");
        System.out.println("3-) Para filtrar por viagens maior que a media");

        System.out.printf("\nDigite: ");
        int resposta = input.nextInt();

        switch (resposta) {
            case 1:
                PrepararODateSet prepararOdateSet = new PrepararODateSet();
                prepararOdateSet.subistituirIdPelasEstacoes();
                pausa(5000);
                break;

            case 2:
               try {
                File file = new File("");
                P2FiltrarStationName.rodar(
                file.getAbsolutePath() + "/DadosCsvTratados/LAMetroTrips.csv",
                file.getAbsolutePath() + "/DadosCsvTratados/LAMetroTrips_F1.csv");
               } catch (Exception e) {
                 System.err.println("Erro ao filtrar");
               }

                break;

            case 3:
                // Filtrar por media
                try {
                    P3FiltrarMedia.rodar();
                } catch (Exception e) {
                    System.err.println("deu ero");
                }
                break;

            default:
                System.out.println("Valor invalido! Digite novamente!");
                pausa(5000);
                break;
        }
    }

    public static void gerarMelhorEPiorCasoInterface() {
        System.out.print("\033[H\033[2J");

        System.out.println("Digite...");

        System.out.println("1-) Para gerar os casos por Estação");
        System.out.println("2-) Para gerar os casos por Duração");
        System.out.println("3-) Para gerar os casos por Data");

        System.out.printf("\nDigite: ");
        int resposta = input.nextInt();

        GerarCasos gerarCasos = new GerarCasos();

        switch (resposta) {
            case 1:
                gerarCasos.gerarTabelComTodosOsCasosPorEstacao();
                pausa(5000);
                break;

            case 2:
                gerarCasos.gerarTabelComTodosOsCasosPorDuracaoDeViagem();
                pausa(5000);
                break;

            case 3:
                gerarCasos.gerarTabelComTodosOsCasosPorData();
                pausa(5000);
                break;

            default:
                System.out.println("Valor invalido! Digite novamente!");
                pausa(5000);
                break;
        }
    }

    public static void selecionarItemASerOrdenado() {
        System.out.print("\033[H\033[2J");

        System.out.println("Digite...");

        System.out.println("1-) Para gerar todos os casos Por Duração de Viagem");
        System.out.println("2-) Para gerar todos os casos Por Nome da Estação");
        System.out.println("3-) Para gerar todos os casos Por Inicio da Viagem");

        System.out.printf("\nDigite: ");
        int resposta = input.nextInt();

        GerarCasos gerarCasos = new GerarCasos();

        switch (resposta) {

            case 1:
                InterfaceDuration.tratarArquivoInterface();
                pausa(5000);
                break;

            case 2:
                InterfaceStation.tratarArquivoInterface();
                break;

            case 3:
                //caso esteja demorando demais pra gerar os arquivos comente
                //um dos metodos abaixaso para gerar um por um
                GerarDatafiles data = new GerarDatafiles();
                data.gerarDataHeap();
                data.gerarDataMerge();
                data.gerarDataQuickM3();
                data.gerarDataQuick();
                data.gerarDataInsertion();
                data.gerarDataSelection();
                System.out.println("Arquivos gerados!");
                pausa(5000);
                break;

            default:
                System.out.println("Valor invalido! Digite novamente!");
                pausa(5000);
                break;
        }
    }

    public static void pausa(long tempo) {
        try {
            Thread.sleep(tempo);
        } catch (Exception e) {
            System.err.println("Erro ao pausar a Thread");
        }
    }
}
