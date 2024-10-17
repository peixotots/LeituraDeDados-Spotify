package controller;

import data.SpotifyData;
import exception.OpcaoInvalidaException;
import filter.SpotifyDeezerPlayCountFilter;
import filter.TopFiveFilter;
import util.Util;

import java.util.List;

import static data.DataReader.lerMusicasDoArquivo;

public class MenuPrincipal extends Menu {
    @Override
    public void selecionaOpcao() {
        String menu = Menu.geraMenuComOpcoes("FILTRO", List.of("Top 5 mais ouvidas", "Comparar Spotify vs Deezer - Top 5", "...", "Sair"));

        int opcaoSelecionada = 0;
        String caminhoArquivo = "src/spotify-2023.csv";
        List<SpotifyData> data = lerMusicasDoArquivo(caminhoArquivo);
        do {
            try {
                System.out.println(menu);
                opcaoSelecionada = Util.lerNumeroInteiro("DIGITE UMA OPÇÃO:");
                switch (opcaoSelecionada) {
                    case 1:
                        TopFiveFilter topFiveFilter = new TopFiveFilter();
                        List<SpotifyData> top5MaisOuvidas = topFiveFilter.applyFilter(data);
                        System.out.println(geraSaidaTop5(top5MaisOuvidas, "Top 5 mais ouvidas"));
                        break;
                    case 2:
                        SpotifyDeezerPlayCountFilter spotifyDeezerFilter = new SpotifyDeezerPlayCountFilter();

                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        System.err.println("Encerrando o programa...");
                        break;
                    default:
                        throw new OpcaoInvalidaException();
                }
            } catch (OpcaoInvalidaException e) {
                System.err.println("Opção inválida! Por favor, digite uma opção válida.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (opcaoSelecionada != 5);
    }
}