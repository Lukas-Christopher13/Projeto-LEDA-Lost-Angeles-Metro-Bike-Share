package csvUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class AbrirArquivoCsv {

    private String nomeDoArquivo;
    private String[] file;
    private int lineNunber;

    //ler a quantidade de linhas do arquivo
    public AbrirArquivoCsv(String nomeDoArquivo){
        File caminhoAbsoluto = new File("");

        this.nomeDoArquivo = caminhoAbsoluto.getAbsolutePath() + nomeDoArquivo;
        this.lineNunber = LerQuatidadeDeLinhasDoArquivo()+1; //para corrigir(uma linha á mais é salva com null por isso o mais +1)
        this.file = new String[lineNunber];
    }
    
    public int LerQuatidadeDeLinhasDoArquivo (){
        try {
            return tryLerQuatidadeDeLinhasDoArquivo();
        } catch (IOException ex) {
            System.err.println("Não foi possivel ler a quantidade de linhas do arquivo");
            return 0;
        }
    }

    private int tryLerQuatidadeDeLinhasDoArquivo() throws IOException {
        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(nomeDoArquivo));
        lineNumberReader.skip(Long.MAX_VALUE);

        int numeroDeLinhas = lineNumberReader.getLineNumber();
        lineNumberReader.close();

        return  numeroDeLinhas;
    }

    public String[] lerArquivo(){
        try {
            tryLerArquivo();
            return file;
        } catch (IOException ex) {
            System.err.println("Erro ao tentar ler o arquivo!");
            return file;
        }
    }

    private void tryLerArquivo() throws IOException { 
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nomeDoArquivo));
        String linha = "";

        int count = 0;

        while(linha != null){
            linha = bufferedReader.readLine();
            file[count] = linha;
            count++;
        }
        bufferedReader.close();
    }
}
