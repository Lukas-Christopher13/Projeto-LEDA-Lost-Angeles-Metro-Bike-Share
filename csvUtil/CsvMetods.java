package csvUtil;

public class CsvMetods {

    public String[] dadosCSV;
    public String[] colunaFiltrada;
    
    public CsvMetods(String[] dadosCSV) {
        this.dadosCSV = dadosCSV;
        this.colunaFiltrada = new String[dadosCSV.length-1];
    }
    
    //Recebe a posição da coluna de 0 até 9... eu acho..
    public String[] getColuna(int posicaoDaColuna){
        
        for(int i = 1; i < dadosCSV.length-1; i++){ //subitrai 1 por conta do problema do null
            String[] temp = dadosCSV[i].split(",");
            colunaFiltrada[i] = temp[posicaoDaColuna];
        }
        return colunaFiltrada.clone();
    }

    //vamos utilizar isso aqui na hora de atualizar os valores apos o sort!
    public void setColuna(String[] coluna, int posicaoDaColuna) {
        Linha atualizarLinha = new Linha(posicaoDaColuna);

        for(int i = 1; i < dadosCSV.length-1; i++){
            dadosCSV[i] = atualizarLinha.atualizarLinha(dadosCSV[i], coluna[i]);
        }
    }
}
