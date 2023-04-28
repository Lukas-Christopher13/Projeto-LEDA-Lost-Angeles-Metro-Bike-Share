
//Esse arquivo gera dois arquivos com o melhor, e pior
//caso para a ordenação.
import java.time.LocalDateTime;
import java.util.Scanner;

import csvUtil.AbrirArquivoCsv;
import csvUtil.Arquivo;
import csvUtil.CsvMetods;
import csvUtil.SortUtil;
import funcoesDeOrdenacao.HeapSort.HeapSortString;
import funcoesDeOrdenacao.InsertionSort.InsertionSortString;
import funcoesDeOrdenacao.MergeSort.*;
import funcoesDeOrdenacao.QuickSort.QuickSortString;

import javax.swing.*;
import funcoesDeOrdenacao.SelectionSort.*;
import funcoesDeOrdenacao.HeapSort.*;

public class GerarStationFiles {
    private final String caminhoIn = "/DadosCsvTratados/csvMelhorPiorEMedioCaso/";
    private final String caminhoOut = "/csvDadosOrdenados/StationFiles/";
    private final String name = "/LAMetroTrips_Station_";
    private final String[] LAMetroTrips = {
        caminhoIn+"LAMetroTrips_station_melhorCaso.csv",
        caminhoIn+"LAMetroTrips.csv",
        caminhoIn+"LAMetroTrips_station_piorCaso.csv",
    };

    private final String[] tiposCaminhos = {
        caminhoOut+"HeapSort"+name,
        caminhoOut+"MergeSort"+name,
        caminhoOut+"InsertionSort"+name,
        caminhoOut+"SelectionSort"+name,
        caminhoOut+"CountingSort"+name,
        caminhoOut+"QuickSort"+name,
        caminhoOut+"QuickSortM3"+name,
      };

  private final String[] tipoDecaso = {
    "MelhorCaso.csv","MedioCaso.csv","PiorCaso.csv"
  };

  private final int duration = 1;
  private final int start_station = 9;
  private final int start_time = 2;

  public String[] arquivoCsv;

  public String[] coluna;
  public int[] intColuna;
  public LocalDateTime[] dateColuna;

  public long tempoInicial, tempoFinal;

  public int lerTipo() {
    Scanner input = new Scanner(System.in);
    System.out.print("\033[H\033[2J");

    System.out.printf("Digite....\n\n");

    System.out.println("1-) Utilizar o arquivo de melhor caso (Já ordenado)");
    System.out.println("2-) Para utilizar o arquivo de medio caso (Não ordenado)");
    System.out.println("3-) Para utilizar o arquivo de pior caso (Ordenado em decrescente)");

    System.out.printf("\nDigite: ");
    int resposta = input.nextInt();
    return resposta;
  }

  public void gerarMergeSortStation() {
    int tipoArquivo = lerTipo();
    tempoInicial = System.currentTimeMillis();
    lerArquivoEColuna(start_station, tipoArquivo);
    MergeSortString.sort(coluna, arquivoCsv, 1, coluna.length - 1);
    tempoFinal = System.currentTimeMillis();
    Arquivo.criarArquivoCsv(arquivoCsv, tiposCaminhos[1]+ tipoDecaso[tipoArquivo-1]);
    mostrarTempo(tempoInicial, tempoFinal);
}

  public void gerarSelectionSortStation(){
    int tipoArquivo = lerTipo();
      tempoInicial = System.currentTimeMillis();
      lerArquivoEColuna(start_station, tipoArquivo);
      SelectionSortString selectionSortString = new SelectionSortString(arquivoCsv);
      selectionSortString.sort(coluna);
      tempoFinal = System.currentTimeMillis();
      Arquivo.criarArquivoCsv(arquivoCsv, tiposCaminhos[3]+ tipoDecaso[tipoArquivo-1]);
      mostrarTempo(tempoInicial, tempoFinal);
  }

  public void gerarInsertionSortStation(){
    int tipoArquivo = lerTipo();
    tempoInicial = System.currentTimeMillis();
    lerArquivoEColuna(start_station, tipoArquivo);
    InsertionSortString.sort(coluna, arquivoCsv);
    tempoFinal = System.currentTimeMillis();
    Arquivo.criarArquivoCsv(arquivoCsv, tiposCaminhos[2]+ tipoDecaso[tipoArquivo-1]);
    mostrarTempo(tempoInicial, tempoFinal);
  }

  public void gerarHeapSortStation(){
    int tipoArquivo = lerTipo();
    tempoInicial = System.currentTimeMillis();
    lerArquivoEColuna(start_station, tipoArquivo);
    HeapSortString heapSort = new HeapSortString(arquivoCsv);
    heapSort.sort(coluna);
    tempoFinal = System.currentTimeMillis();
    Arquivo.criarArquivoCsv(arquivoCsv, tiposCaminhos[0]+ tipoDecaso[tipoArquivo-1]);
    mostrarTempo(tempoInicial, tempoFinal);
  }


  public void gerarQuickSortStation(){
    int tipoArquivo = lerTipo();
    tempoInicial = System.currentTimeMillis();
    lerArquivoEColuna(start_station, tipoArquivo);
    QuickSortString.sort(coluna, arquivoCsv, 1, coluna.length - 1);
    tempoFinal = System.currentTimeMillis();
    Arquivo.criarArquivoCsv(arquivoCsv, tiposCaminhos[5]+ tipoDecaso[tipoArquivo-1]);
    mostrarTempo(tempoInicial, tempoFinal);
  }

  public void mostrarTempo(long tempoFinal, long tempoInicial) {
    JFrame frame = new JFrame();
    frame.setSize(400, 400);
    frame.setVisible(true);
    String tempo = String.format("%.3f ms%n", (tempoInicial - tempoFinal) / 1000d);
    System.out.printf(tempo);
    System.out.println();
    JOptionPane pane = new JOptionPane("O tempo de execução do programa foi: " + tempo);
    JDialog dialog = pane.createDialog("Alerta");
    dialog.setAlwaysOnTop(true);
    dialog.setVisible(true);
  }

  private void lerArquivoEColuna(int coluna, int tipo) {
    AbrirArquivoCsv aba = new AbrirArquivoCsv(LAMetroTrips[tipo-1]);
    this.arquivoCsv = aba.lerArquivo();

    CsvMetods csvM = new CsvMetods(arquivoCsv);
    this.coluna = csvM.getColuna(coluna);
  }
}
