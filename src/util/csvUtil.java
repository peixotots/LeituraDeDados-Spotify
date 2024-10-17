package util;

import java.util.ArrayList;
import java.util.List;

public class csvUtil {
    // Método para dividir uma linha de CSV respeitando aspas e vírgulas
    public static String[] parseLinhaCSV(String linha) {
        List<String> resultado = new ArrayList<>();
        StringBuilder campoAtual = new StringBuilder();
        boolean dentroDeAspas = false;

        for (char c : linha.toCharArray()) {
            if (c == '"') {
                dentroDeAspas = !dentroDeAspas;
            } else if (c == ',' && !dentroDeAspas) {

                resultado.add(campoAtual.toString());
                campoAtual.setLength(0);
            } else {
                campoAtual.append(c);
            }
        }

        resultado.add(campoAtual.toString());

        return resultado.toArray(new String[0]);
    }
}
