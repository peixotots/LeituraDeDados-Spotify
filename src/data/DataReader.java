package data;

import util.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReader {
    public static List<SpotifyData> lerMusicasDoArquivo(String caminhoArquivo) {
        List<SpotifyData> musicas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] colunas = Util.parseLinhaCSV(linha);
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

                SpotifyData data = new SpotifyData(nome, artista, numeroDeOuvidas, numeroDePlaylists);
                musicas.add(data);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return musicas;
    }
}
