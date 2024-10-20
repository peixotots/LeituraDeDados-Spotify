package filter;

import data.DataFilter;
import data.SpotifyData;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OldestSongsFilter implements DataFilter {

    @Override
    public List<SpotifyData> applyFilter(List<? extends SpotifyData> data) {
        return data.stream()
                .sorted(Comparator.comparingInt(SpotifyData::getAnoDeLancamento))
                .limit(5)
                .collect(Collectors.toList());
    }
}