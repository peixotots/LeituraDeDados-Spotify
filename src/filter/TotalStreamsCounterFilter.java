package filter;
import data.SpotifyData;

import java.util.Comparator;
import java.util.List;

public class TotalStreamsCounterFilter {

    public long applyFilter(List<? extends SpotifyData> data) {
        return data.stream()
                .sorted(Comparator.comparingInt(SpotifyData::getNumeroDeReproducoes).reversed())
                .limit(5)
                .mapToLong(SpotifyData::getNumeroDeReproducoes)
                .reduce(0L, Long::sum);
    }
}
