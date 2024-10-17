package controller;

import data.Music;
import filter.TopFiveFilter;
import util.csvUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpotifyFiveController {
    public static void main(String[] args) {
        String caminhoArquivo = "src/spotify-2023.csv";
        List<Music> musicas = lerMusicasDoArquivo(caminhoArquivo);

        // Filtrar as top 5 músicas mais ouvidas
        List<Music> top5MaisOuvidas = TopFiveFilter.filtrarTop5MaisOuvidas(musicas);

        System.out.println("Top 5 músicas mais ouvidas:");
        top5MaisOuvidas.forEach(System.out::println);
    }

    private static List<Music> lerMusicasDoArquivo(String caminhoArquivo) {
        List<Music> musicas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            br.readLine(); // Pular o cabeçalho

            while ((linha = br.readLine()) != null) {
                String[] colunas = csvUtil.parseLinhaCSV(linha);
                if (colunas.length < 9) {
                    continue;
                }

                String nome = colunas[0].trim();
                String artista = colunas[1].trim();
                int numeroDeOuvidas = 0;
                int numeroDePlaylists = 0;

                try {
                    numeroDeOuvidas = Integer.parseInt(colunas[8].trim());
                    numeroDePlaylists = Integer.parseInt(colunas[6].trim());
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter número na linha: " + Arrays.toString(colunas));
                    continue;
                }

                Music musica = new Music(nome, artista, numeroDeOuvidas, numeroDePlaylists);
                musicas.add(musica);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return musicas;
    }
}
