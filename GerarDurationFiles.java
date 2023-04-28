
//Esse arquivo gera dois arquivos com o melhor, e pior
//caso para a ordenação.
import java.time.LocalDateTime;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import csvUtil.AbrirArquivoCsv;
import csvUtil.Arquivo;
import csvUtil.CsvMetods;
import csvUtil.SortUtil;
import funcoesDeOrdenacao.MergeSort.MergeSortInt;
import funcoesDeOrdenacao.QuickSort.QuickSortDuration;
import funcoesDeOrdenacao.QuickSortM3.QuickSortM3Duration;
import funcoesDeOrdenacao.SelectionSort.SelectionSortDuration;
import funcoesDeOrdenacao.CountingSort.CountingSortDuration;
import funcoesDeOrdenacao.HeapSort.HeapSortInt;
import funcoesDeOrdenacao.InsertionSort.InsertionSortDuration;
import javax.swing.*;

public class GerarDurationFiles {

  //SESSÃO DE CAMINHOS
  private final String caminhoIn = "/DadosCsvTratados/csvMelhorPiorEMedioCaso/";
  private final String caminhoOut = "/csvDadosOrdenados/DurationFiles/";
  
  private final String name = "/LAMetroTrips_Duration_";
  private final String[] LAMetroTrips = {
      caminhoIn+"LAMetroTrips_duration_melhorCaso.csv",
      caminhoIn+"LAMetroTrips.csv",
      caminhoIn+"LAMetroTrips_duration_piorCaso.csv",
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

  public void gerarDurationHeap() {
    int tipoArquivo = lerTipo();
    tempoInicial = System.currentTimeMillis();
    lerArquivoEColuna(duration, tipoArquivo);
    intColuna = SortUtil.toIntArray(coluna);
    HeapSortInt heapSort = new HeapSortInt(arquivoCsv);
    heapSort.sort(intColuna);
    tempoFinal = System.currentTimeMillis();
    Arquivo.criarArquivoCsv(arquivoCsv, tiposCaminhos[0]+ tipoDecaso[tipoArquivo-1]);
    mostrarTempo(tempoInicial, tempoFinal);
    
  }

  public void gerarDurationMerge() {
    int tipoArquivo = lerTipo();
    tempoInicial = System.currentTimeMillis();
    lerArquivoEColuna(duration, tipoArquivo);
    intColuna = SortUtil.toIntArray(coluna);
    MergeSortInt.sort(intColuna, arquivoCsv, 0, intColuna.length - 1);
    tempoFinal = System.currentTimeMillis();
    Arquivo.criarArquivoCsv(arquivoCsv, tiposCaminhos[1]+ tipoDecaso[tipoArquivo-1]);
    mostrarTempo(tempoInicial, tempoFinal);
  }

  public void gerarInsertionSortDuration() {
    int tipoArquivo = lerTipo();
    tempoInicial = System.currentTimeMillis();
    lerArquivoEColuna(duration, tipoArquivo);
    intColuna = SortUtil.toIntArray(coluna);
    InsertionSortDuration.sort(intColuna, arquivoCsv);
    tempoFinal = System.currentTimeMillis();
    Arquivo.criarArquivoCsv(arquivoCsv, tiposCaminhos[2]+ tipoDecaso[tipoArquivo-1]);
    mostrarTempo(tempoInicial, tempoFinal);

  }

  public void gerarSelectionSortDuration() {
    int tipoArquivo = lerTipo();
    tempoInicial = System.currentTimeMillis();
    lerArquivoEColuna(duration, tipoArquivo);
    intColuna = SortUtil.toIntArray(coluna);
    SelectionSortDuration.sort(intColuna, arquivoCsv);
    tempoFinal = System.currentTimeMillis();
    Arquivo.criarArquivoCsv(arquivoCsv, tiposCaminhos[3]+ tipoDecaso[tipoArquivo-1]);
    mostrarTempo(tempoInicial, tempoFinal);
  }

  public void gerarCountingSortDuration() {
    int tipoArquivo = lerTipo();
    tempoInicial = System.currentTimeMillis();
    lerArquivoEColuna(duration, tipoArquivo);
    intColuna = SortUtil.toIntArray(coluna);
    CountingSortDuration.sort(intColuna, arquivoCsv);
    tempoFinal = System.currentTimeMillis();
    Arquivo.criarArquivoCsv(arquivoCsv, tiposCaminhos[4]+ tipoDecaso[tipoArquivo-1]);
    mostrarTempo(tempoInicial, tempoFinal);
  }

  public void gerarQuickSortDuration() {
    int tipoArquivo = lerTipo();
    tempoInicial = System.currentTimeMillis();
    lerArquivoEColuna(duration, tipoArquivo);
    intColuna = SortUtil.toIntArray(coluna);
    QuickSortDuration qs = new QuickSortDuration(arquivoCsv);
    qs.sort(intColuna);
    tempoFinal = System.currentTimeMillis();
    Arquivo.criarArquivoCsv(arquivoCsv, tiposCaminhos[5]+ tipoDecaso[tipoArquivo-1]);
    mostrarTempo(tempoInicial, tempoFinal);
  }

  public void gerarQuickSortDurationM3() {
    int tipoArquivo = lerTipo();
    tempoInicial = System.currentTimeMillis();
    lerArquivoEColuna(duration, tipoArquivo);
    intColuna = SortUtil.toIntArray(coluna);
    QuickSortM3Duration qs = new QuickSortM3Duration(arquivoCsv);
    qs.sort(intColuna);
    tempoFinal = System.currentTimeMillis();
    Arquivo.criarArquivoCsv(arquivoCsv, tiposCaminhos[6]+ tipoDecaso[tipoArquivo-1]);
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
    AbrirArquivoCsv aba = new AbrirArquivoCsv(LAMetroTrips[tipo - 1]);
    this.arquivoCsv = aba.lerArquivo();

    CsvMetods csvM = new CsvMetods(arquivoCsv);
    this.coluna = csvM.getColuna(coluna);
  }
}
