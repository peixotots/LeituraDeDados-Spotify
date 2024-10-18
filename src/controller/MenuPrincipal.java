package controller;

import data.SpotifyData;
import exception.OpcaoInvalidaException;
import filter.Apple10ChartsFilter;
import filter.TopFiveFilter;
import util.Util;

import java.util.List;

import static data.DataReader.lerMusicasDoArquivo;

public class MenuPrincipal extends Menu {
    @Override
    public void selecionaOpcao() {
        String menu = Menu.geraMenuComOpcoes("FILTROS", List.of("TOP 5 MAIS ESCUTADAS NO SPOTIFY", "TOP 5 DESTAQUES NA APPLE", "...", "Sair"));

        String caminhoArquivo = "src/spotify-2023.csv";
        int opcaoSelecionada = 0;
        do {
            try {
                System.out.println(menu);
                opcaoSelecionada = Util.lerNumeroInteiro("DIGITE UMA OPÇÃO:");
                switch (opcaoSelecionada) {
                    case 1:
                        TopFiveFilter topFiveFilter = new TopFiveFilter();
                        List<SpotifyData> dataSpotify = lerMusicasDoArquivo(caminhoArquivo, "1");
                        List<SpotifyData> top5MaisOuvidasSpotify = topFiveFilter.applyFilter(dataSpotify);
                        System.out.println(geraSaidaFiltros(top5MaisOuvidasSpotify,"TOP 5 NO SPOTIFY"));
                        break;
                    case 2:
                        Apple10ChartsFilter appleFilter = new Apple10ChartsFilter();
                        List<SpotifyData> dataApple = lerMusicasDoArquivo(caminhoArquivo, "2");
                        List<SpotifyData> top5DestaquesApple = appleFilter.applyFilter(dataApple);
                        System.out.println(geraSaidaFiltros(top5DestaquesApple, "TOP 5 DESTAQUES NA APPLE"));
                        break;
                    case 3:
                        break;
                    case 4:
                        System.err.println("Saindo...");
                        break;
                    default:
                        throw new OpcaoInvalidaException();
                }
            } catch (OpcaoInvalidaException e) {
                System.err.println("Opção inválida! Por favor, digite uma opção válida.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (opcaoSelecionada != 4);
    }
}