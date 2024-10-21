package controller;

import data.SpotifyData;
import filter.*;
import exception.OpcaoInvalidaException;
import util.Util;

import java.util.List;

import static data.DataReader.lerMusicasDoArquivo;

public class MenuPrincipal extends Menu {
    @Override
    public void selecionaOpcao() {
        String menu = Menu.gerarMenuComOpcoes("🎧 ADA MUSIC ", List.of("TOP 5 MÚSICAS MAIS OUVIDAS NO SPOTIFY",
                "TOP 5 DESTAQUES - APPLE", "TOP 5 DESTAQUES - DEEZER", "TOP 5 MÚSICAS MAIS ANTIGAS OUVIDAS EM 2023",
                "MÚSICAS MAIS TOCADAS NO ANO 2000", "ARTISTAS MAIS TOCADOS EM 2023", "TOTAL DE REPRODUÇÕES - TOP 5 SPOTIFY", "ENCERRAR PROGRAMA"));

        String caminhoArquivo = "src/spotify-2023.csv";
        int opcaoSelecionada = 0;

        do {
            try {
                System.out.println(menu);
                opcaoSelecionada = Util.lerNumeroInteiro("DIGITE UMA OPÇÃO: ");

                switch (opcaoSelecionada) {
                    case 1:
                        SpotifyTopFiveFilter spotifyTopFiveFilter = new SpotifyTopFiveFilter();
                        List<SpotifyData> spotifyData = lerMusicasDoArquivo(caminhoArquivo, "1");
                        List<SpotifyData> top5MaisOuvidasSpotify = spotifyTopFiveFilter.applyFilter(spotifyData);
                        System.out.println(gerarSaidaFiltros(top5MaisOuvidasSpotify, "TOP 5 MÚSICAS MAIS OUVIDAS NO SPOTIFY"));
                        break;

                    case 2:
                        Apple5ChartsFilter appleFilter = new Apple5ChartsFilter();
                        List<SpotifyData> appleData = lerMusicasDoArquivo(caminhoArquivo, "2");
                        List<SpotifyData> top5DestaquesApple = appleFilter.applyFilter(appleData);
                        System.out.println(gerarSaidaFiltros(top5DestaquesApple, "TOP 5 DESTAQUES - APPLE"));
                        break;

                    case 3:
                        Deezer5ChartsFilter deezerFilter = new Deezer5ChartsFilter();
                        List<SpotifyData> deezerData = lerMusicasDoArquivo(caminhoArquivo, "3");
                        List<SpotifyData> top5DestaquesDeezer = deezerFilter.applyFilter(deezerData);
                        System.out.println(gerarSaidaFiltros(top5DestaquesDeezer, "TOP 5 - DEEZER"));
                        break;

                    case 4:
                        OldestSongsFilter oldestSongsFilter = new OldestSongsFilter();
                        List<SpotifyData> oldestSongsData = lerMusicasDoArquivo(caminhoArquivo, "1");
                        List<SpotifyData> top5OldestSongs = oldestSongsFilter.applyFilter(oldestSongsData);
                        System.out.println(gerarSaidaFiltros(top5OldestSongs, "TOP 5 MÚSICAS MAIS ANTIGAS OUVIDAS EM 2023"));
                        break;

                    case 5:
                        TopSongsIn2000 topSongsIn2000 = new TopSongsIn2000();
                        List<SpotifyData> topSongs2000Data = lerMusicasDoArquivo(caminhoArquivo, "1");
                        List<SpotifyData> top5Songs2000 = topSongsIn2000.applyFilter(topSongs2000Data);
                        System.out.println(gerarSaidaFiltros(top5Songs2000, "MÚSICAS MAIS TOCADAS NO ANO 2000"));
                        break;

                    case 6:
                        ArtistNamesFilter artistNamesFilter = new ArtistNamesFilter();
                        List<SpotifyData> allMusicas = lerMusicasDoArquivo(caminhoArquivo, "1");
                        List<SpotifyData> top5Artistas2023 = artistNamesFilter.applyFilter(allMusicas);
                        System.out.println(gerarSaidaFiltros(top5Artistas2023, "TOP 5 ARTISTAS MAIS TOCADOS EM 2023"));
                        break;

                    case 7:
                        TotalStreamsCounterFilter totalStreamsCounterFilter = new TotalStreamsCounterFilter();
                        List<SpotifyData> spotifyListData = lerMusicasDoArquivo(caminhoArquivo, "1");
                        long totalStreamsTop5Spotify = totalStreamsCounterFilter.applyFilter(spotifyListData);
                        gerarSaidaTotalStreams(totalStreamsTop5Spotify, "TOTAL");
                        break;

                    case 8:
                        System.err.println("Encerrando o programa... Até a próxima! 👋");
                        break;

                    default:
                        throw new OpcaoInvalidaException();
                }
            } catch (OpcaoInvalidaException e) {
                System.err.println("❌ Opção inválida! Por favor, digite uma opção válida.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (opcaoSelecionada != 8);
    }
}