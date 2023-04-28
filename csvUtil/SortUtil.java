package csvUtil;

import java.time.LocalDateTime;

public class SortUtil {
    
    public static int[] toIntArray(String[] strArray) {
        int[] intArray = new int[strArray.length];

        for(int i = 1; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }

    public static LocalDateTime[] toDateTime(String[] strArray) {
        LocalDateTime[] datas = new LocalDateTime[strArray.length];

        for(int i = 1; i < strArray.length; i++) {
            String[] dataSplit = strArray[i].split("[/: ]");

            int dia = Integer.parseInt(dataSplit[0]);
            int mes = Integer.parseInt(dataSplit[1]);
            int ano = Integer.parseInt(dataSplit[2]);
            int hora = Integer.parseInt(dataSplit[3]);
            int minuto = Integer.parseInt(dataSplit[4]);

            datas[i] = LocalDateTime.of(ano,mes,dia,hora,minuto);
        }
        return datas;
    }   
}


