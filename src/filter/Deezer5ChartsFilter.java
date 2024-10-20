package filter;

import data.DataFilter;
import data.DeezerData;
import data.SpotifyData;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Deezer10ChartsFilter implements DataFilter {

    @Override
    public List<SpotifyData> applyFilter(List<? extends SpotifyData> data) {
        return data.stream().filter(DeezerData.class::isInstance)
                .map(DeezerData.class::cast)
                .sorted(Comparator.comparingInt(DeezerData::getDestaqueDeezer).reversed()).limit(5)
                .collect(Collectors.toList());

    }
}
