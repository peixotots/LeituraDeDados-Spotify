package controller;
import data.SpotifyData;
import exception.OpcaoInvalidaException;

import java.util.List;
import java.util.Scanner;

public abstract class Menu {

    protected final Scanner entrada;

    public Menu() {
        this.entrada = new Scanner(System.in);
    }

    public static String geraMenuComOpcoes(String tituloMenu, List<String> opcoes) {

        int contador = 1;
        StringBuilder opcoesConcatenadas = new StringBuilder();

        int largura = tituloMenu.length() + 29;

        String bordaTopo = "╔" + "═".repeat(largura) + "╗";
        String linhaCentral = "╠" + "═".repeat(largura) + "╣";
        String bordaFim = "╚" + "═".repeat(largura) + "╝";
        String linhaTitulo = "║" + " ".repeat((largura - tituloMenu.length() ) / 2 ) + tituloMenu + " ".repeat(((largura - tituloMenu.length()) / 2) + 1) + "║";

        for (String opcao : opcoes) {
            opcoesConcatenadas.append("* ").append(contador).append(". ").append(opcao).append(" ".repeat(largura - opcao.length() - 4)).append("║").append("\n");
            contador++;
        }

        return bordaTopo + "\n" + linhaTitulo + "\n" + linhaCentral + "\n" + opcoesConcatenadas + bordaFim;
    }

    public abstract void selecionaOpcao() throws OpcaoInvalidaException;

    protected String geraSaidaTop5(List<SpotifyData> top5MaisOuvidas, String titulo) {
        int largura = titulo.length() + 29;

        StringBuilder saida = new StringBuilder();
        String bordaTopo = "╔" + "═".repeat(largura) + "╗";
        String linhaTitulo = "║" + " ".repeat((largura - titulo.length()) / 2) + titulo + " ".repeat(((largura - titulo.length()) / 2) + 1) + "║";
        String linhaCentral = "╠" + "═".repeat(largura) + "╣";
        String bordaFim = "╚" + "═".repeat(largura) + "╝";

        saida.append(bordaTopo).append("\n").append(linhaTitulo).append("\n").append(linhaCentral).append("\n");

        int contador = 1;
        for (SpotifyData musica : top5MaisOuvidas) {
            String linhaMusica = String.format("%d. %s - %d ouvidas", contador, musica.getNome(), musica.getNumeroDeOuvidas());
            saida.append("║ ").append(linhaMusica).append(" ".repeat(largura - linhaMusica.length() - 1)).append("║\n");
            contador++;
        }

        saida.append(bordaFim);
        return saida.toString();
    }
}