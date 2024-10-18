package data;

import util.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public static List<SpotifyData> lerMusicasDoArquivo(String caminhoArquivo, String opcao) {
        List<SpotifyData> musicas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] colunas = Util.parseLinhaCSV(linha);
                if (colunas.length < 13) {
                    continue;
                }

                String nome = colunas[0].trim();
                String artista = colunas[1].trim();
                int numeroDeOuvidas = Integer.parseInt(colunas[8].trim());
                int numeroDePlaylists = Integer.parseInt(colunas[6].trim());
                int inAppleCharts = Integer.parseInt(colunas[10].trim());

                if (opcao.equals("1")) {
                    SpotifyData dataSpotify = new SpotifyData(nome, artista, numeroDeOuvidas, numeroDePlaylists);
                    musicas.add(dataSpotify);
                }
                if (opcao.equals("2")) {
                    AppleData dataApple = new AppleData(nome, artista, numeroDeOuvidas, numeroDePlaylists, inAppleCharts);
                    musicas.add(dataApple);
                }
                if (opcao.equals("3")) {
                    //...
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return musicas;
    }
}

