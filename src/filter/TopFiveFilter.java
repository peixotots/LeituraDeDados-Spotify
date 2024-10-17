package filter;

import data.Music;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TopFiveFilter {
    public static List<Music> filtrarTop5MaisOuvidas(List<Music> musicas) {
        return musicas.stream()
                .sorted(Comparator.comparingInt(Music::getNumeroDeOuvidas).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}
