package filter;

import data.SpotifyData;

import java.util.List;
import java.util.stream.Collectors;

public class TopSongsIn2000 {

    public List<SpotifyData> Top5SongsIn2000(List<SpotifyData> musicas) {
        return musicas.stream()
                .filter(musica -> musica.getAnoDeLancamento() == 2000)
                .sorted((m1, m2) -> Integer.compare(m2.getNumeroDeReproducoes(), m1.getNumeroDeReproducoes()))
                .limit(5)
                .collect(Collectors.toList());
    }

}