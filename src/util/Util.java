package util;

import exception.OpcaoInvalidaException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util {
    private static Scanner entrada = new Scanner(System.in);

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

    public static int lerNumeroInteiro(String pergunta) throws OpcaoInvalidaException {
        System.out.println(pergunta);
        String texto = entrada.nextLine();
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            throw new OpcaoInvalidaException();
        }
    }
}
