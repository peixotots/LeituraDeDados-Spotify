package filter;

import data.DataFilter;
import data.SpotifyData;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TopFiveFilter implements DataFilter {

    @Override
    public List<SpotifyData> applyFilter(List<SpotifyData> data) {
            return data.stream()
                    .sorted(Comparator.comparingInt(SpotifyData::getNumeroDeOuvidas).reversed())
                    .limit(5)
                    .collect(Collectors.toList());
        }
    }

