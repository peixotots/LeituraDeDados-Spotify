package controller;

import data.SpotifyData;
import filter.TopSongsIn2000;
import exception.OpcaoInvalidaException;
import filter.Apple5ChartsFilter;
import filter.Deezer5ChartsFilter;
import filter.TopFiveFilter;
import filter.OldestSongsFilter;
import filter.ArtistNamesFilter;
import util.Util;

import java.util.List;

import static data.DataReader.lerMusicasDoArquivo;

public class MenuPrincipal extends Menu {
    @Override
    public void selecionaOpcao() {
        String menu = Menu.geraMenuComOpcoes("🎧 ADA MUSIC", List.of("TOP 5 MÚSICAS MAIS OUVIDAS NO SPOTIFY",
                "TOP 5 DESTAQUES - APPLE", "TOP 5 DESTAQUES - DEEZER", "TOP 5 MÚSICAS MAIS ANTIGAS OUVIDAS EM 2023",
                "MÚSICAS MAIS TOCADAS NO ANO 2000", "ARTISTAS MAIS TOCADOS EM 2023", "ENCERRAR PROGRAMA"));
        String caminhoArquivo = "src/spotify-2023.csv";
        int opcaoSelecionada = 0;
        TopSongsIn2000 processor = new TopSongsIn2000();

        do {
            try {
                System.out.println(menu);
                opcaoSelecionada = Util.lerNumeroInteiro("DIGITE UMA OPÇÃO: ");

                switch (opcaoSelecionada) {
                    case 1:
                        TopFiveFilter topFiveFilter = new TopFiveFilter();
                        List<SpotifyData> spotifyData = lerMusicasDoArquivo(caminhoArquivo, "1");
                        List<SpotifyData> top5MaisOuvidasSpotify = topFiveFilter.applyFilter(spotifyData);
                        System.out.println(geraSaidaFiltros(top5MaisOuvidasSpotify, "TOP 5 MÚSICAS MAIS OUVIDAS NO SPOTIFY"));
                        break;

                    case 2:
                        Apple5ChartsFilter appleFilter = new Apple5ChartsFilter();
                        List<SpotifyData> appleData = lerMusicasDoArquivo(caminhoArquivo, "2");
                        List<SpotifyData> top5DestaquesApple = appleFilter.applyFilter(appleData);
                        System.out.println(geraSaidaFiltros(top5DestaquesApple, "TOP 5 DESTAQUES - APPLE"));
                        break;

                    case 3:
                        Deezer5ChartsFilter deezerFilter = new Deezer5ChartsFilter();
                        List<SpotifyData> deezerData = lerMusicasDoArquivo(caminhoArquivo, "3");
                        List<SpotifyData> top5DestaquesDeezer = deezerFilter.applyFilter(deezerData);
                        System.out.println(geraSaidaFiltros(top5DestaquesDeezer, "TOP 5 - DEEZER"));
                        break;

                    case 4:
                        OldestSongsFilter oldestSongsFilter = new OldestSongsFilter();
                        List<SpotifyData> allData = lerMusicasDoArquivo(caminhoArquivo, "1");
                        List<SpotifyData> top5OldestSongs = oldestSongsFilter.applyFilter(allData);
                        System.out.println(geraSaidaFiltros(top5OldestSongs, "TOP 5 MÚSICAS MAIS ANTIGAS OUVIDAS EM 2023"));
                        break;

                    case 5:
                        List<SpotifyData> musicas = lerMusicasDoArquivo(caminhoArquivo, "1");
                        List<SpotifyData> musicas2000 = processor.Top5SongsIn2000(musicas);
                        System.out.println(geraSaidaFiltros(musicas2000, "MÚSICAS MAIS TOCADAS NO ANO 2000"));
                        break;

                    case 6:
                        ArtistNamesFilter artistNamesFilter = new ArtistNamesFilter();
                        List<SpotifyData> allMusicas = lerMusicasDoArquivo(caminhoArquivo, "1");
                        List<SpotifyData> top5Artistas2023 = artistNamesFilter.applyFilter(allMusicas);
                        System.out.println(geraSaidaFiltros(top5Artistas2023, "TOP 5 ARTISTAS MAIS TOCADOS EM 2023"));
                        break;

                    case 7:
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
        } while (opcaoSelecionada != 7);
    }
}