package controller;

import data.AppleData;
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

        for (String opcao : opcoes) {
            largura = Math.max(largura, opcao.length() + 4);
        }

        String bordaTopo = "╔" + "═".repeat(largura) + "╗";
        String linhaCentral = "╠" + "═".repeat(largura) + "╣";
        String bordaFim = "╚" + "═".repeat(largura) + "╝";
        String linhaTitulo = "║" + " ".repeat((largura - tituloMenu.length()) / 2) + tituloMenu + " ".repeat((largura - tituloMenu.length()) / 2) + " ║";

        for (String opcao : opcoes) {
            opcoesConcatenadas.append("* ").append(contador).append(". ").append(opcao)
                    .append(" ".repeat(largura - opcao.length() - 4)).append("║").append("\n");
            contador++;
        }

        return bordaTopo + "\n" + linhaTitulo + "\n" + linhaCentral + "\n" + opcoesConcatenadas + bordaFim;
    }

    public abstract void selecionaOpcao() throws OpcaoInvalidaException;

    protected String geraSaidaFiltros(List<SpotifyData> musicas, String titulo) {
        int larguraMaxima = titulo.length();

        for (SpotifyData musica : musicas) {
            String linhaMusica;

            if (musica instanceof AppleData appleData) {
                linhaMusica = String.format("🎵 Musica: %s | 🎤 Artista: %s | 🌟 Destaque Apple: %d | 🔥 Reproduções: %d",
                        appleData.getNome(), appleData.getArtista(), appleData.getDestaqueApple(), appleData.getNumeroDeReproducoes());
            } else {
                linhaMusica = String.format("🎵 Musica: %s | 🎤 Artista: %s | 🔥 Reproduções: %d | Playlists: %d",
                        musica.getNome(), musica.getArtista(), musica.getNumeroDeReproducoes(), musica.getNumeroDePlaylists());
            }

            if (linhaMusica.length() > larguraMaxima) {
                larguraMaxima = linhaMusica.length();
            }
        }

        int larguraFinal = larguraMaxima + 9;

        StringBuilder saida = new StringBuilder();
        String bordaTopo = "╔" + "═".repeat(larguraFinal) + "╗";
        saida.append(bordaTopo).append("\n");

        int espacosAntesTitulo = (larguraFinal - titulo.length()) / 2;
        int espacosDepoisTitulo = larguraFinal - titulo.length() - espacosAntesTitulo;
        String linhaTitulo = "║" + " ".repeat(espacosAntesTitulo) + titulo + " ".repeat(espacosDepoisTitulo) + "║";
        saida.append(linhaTitulo).append("\n");

        String linhaCentral = "╠" + "═".repeat(larguraFinal) + "╣";
        saida.append(linhaCentral).append("\n");

        for (SpotifyData musica : musicas) {
            String linhaMusica;

            if (musica instanceof AppleData appleData) {
                linhaMusica = String.format("🎵 Musica: %s | 🎤 Artista: %s | 🌟 Destaque Apple: %d | 🔥 Reproduções: %d",
                        appleData.getNome(), appleData.getArtista(), appleData.getDestaqueApple(), appleData.getNumeroDeReproducoes());
            } else {
                linhaMusica = String.format("🎵 Musica: %s | 🎤 Artista: %s | 🔥 Reproduções: %d | Playlists: %d",
                        musica.getNome(), musica.getArtista(), musica.getNumeroDeReproducoes(), musica.getNumeroDePlaylists());
            }

            saida.append("║").append(linhaMusica)
                    .append(" ".repeat(Math.max(0, larguraFinal - linhaMusica.length() - 1)))
                    .append("║\n");
        }

        String bordaFim = "╚" + "═".repeat(larguraFinal) + "╝";
        saida.append(bordaFim);

        return saida.toString();
    }
}