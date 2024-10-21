package controller;

import data.AppleData;
import data.DeezerData;
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
            opcoesConcatenadas.append("\uD83C\uDFB6").append(contador).append(". ").append(opcao)
                    .append(" ".repeat(largura - opcao.length() - 4)).append("║").append("\n");
            contador++;
        }

        return bordaTopo + "\n" + linhaTitulo + "\n" + linhaCentral + "\n" + opcoesConcatenadas + bordaFim;
    }

    public abstract void selecionaOpcao() throws OpcaoInvalidaException;

    protected String geraSaidaFiltros(List<SpotifyData> musicas, String titulo) {
        int larguraMaxima = titulo.length();
        boolean incluirAnoDeLancamento = titulo.equals("TOP 5 MÚSICAS MAIS OUVIDAS NO SPOTIFY") || titulo.equals("TOP 5 MÚSICAS MAIS ANTIGAS OUVIDAS EM 2023");

        for (SpotifyData musica : musicas) {
            String linhaMusica;

            if (musica instanceof AppleData appleData) {
                linhaMusica = String.format("🎵 MÚSICA: %s | 🎤 ARTISTA: %s | 🌟 DESTAQUE APPLE: %d | 🔥 REPRODUÇÕES: %d",
                        appleData.getNome(), appleData.getArtista(), appleData.getDestaqueApple(), appleData.getNumeroDeReproducoes());
            } else if (musica instanceof DeezerData deezerData) {
                linhaMusica = String.format("🎵 MÚSICA: %s | 🎤 ARTISTA: %s | 🌟 DESTAQUE DEEZER: %d | 🔥 REPRODUÇÕES: %d",
                        deezerData.getNome(), deezerData.getArtista(), deezerData.getDestaqueDeezer(), deezerData.getNumeroDeReproducoes());
            } else if (titulo.equals("TOP 5 ARTISTAS MAIS TOCADOS EM 2023")) {
                linhaMusica = String.format("🎤 ARTISTA: %s | 🔥 REPRODUÇÕES: %d | 📀 PLAYLISTS: %d",
                        musica.getArtista(), musica.getNumeroDeReproducoes(), musica.getNumeroDePlaylists());
            } else {
                linhaMusica = incluirAnoDeLancamento
                        ? String.format("🎵 MÚSICA: %s | 🎤 ARTISTA: %s | 📅 ANO DE LANÇAMENTO: %d | 🔥 REPRODUÇÕES: %d | 📀 PLAYLISTS: %d",
                        musica.getNome(), musica.getArtista(), musica.getAnoDeLancamento(), musica.getNumeroDeReproducoes(), musica.getNumeroDePlaylists())
                        : String.format("🎵 MÚSICA: %s | 🎤 ARTISTA: %s | 🔥 REPRODUÇÕES: %d | 📀 PLAYLISTS: %d",
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
                linhaMusica = String.format("🎵 MÚSICA: %s | 🎤 ARTISTA: %s | 🌟 DESTAQUE APPLE: %d | 🔥 REPRODUÇÕES: %d",
                        appleData.getNome(), appleData.getArtista(), appleData.getDestaqueApple(), appleData.getNumeroDeReproducoes());
            } else if (musica instanceof DeezerData deezerData) {
                linhaMusica = String.format("🎵 MÚSICA: %s | 🎤 ARTISTA: %s | 🌟 DESTAQUE DEEZER: %d | 🔥 REPRODUÇÕES: %d",
                        deezerData.getNome(), deezerData.getArtista(), deezerData.getDestaqueDeezer(), deezerData.getNumeroDeReproducoes());
            } else if (titulo.equals("TOP 5 ARTISTAS MAIS TOCADOS EM 2023")) {
                linhaMusica = String.format("🎤 ARTISTA: %s | 🔥 REPRODUÇÕES: %d | 📀 PLAYLISTS: %d",
                        musica.getArtista(), musica.getNumeroDeReproducoes(), musica.getNumeroDePlaylists());
            } else {
                linhaMusica = incluirAnoDeLancamento
                        ? String.format("🎵 MÚSICA: %s | 🎤 ARTISTA: %s | 📅 ANO DE LANÇAMENTO: %d | 🔥 REPRODUÇÕES: %d | 📀 PLAYLISTS: %d",
                        musica.getNome(), musica.getArtista(), musica.getAnoDeLancamento(), musica.getNumeroDeReproducoes(), musica.getNumeroDePlaylists())
                        : String.format("🎵 MÚSICA: %s | 🎤 ARTISTA: %s | 🔥 REPRODUÇÕES: %d | 📀 PLAYLISTS: %d",
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