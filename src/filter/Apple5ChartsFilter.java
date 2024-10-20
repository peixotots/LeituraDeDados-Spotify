package filter;

import data.AppleData;
import data.DataFilter;
import data.SpotifyData;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Apple5ChartsFilter implements DataFilter {
    @Override
    public List<SpotifyData> applyFilter(List<? extends SpotifyData> data) {
        return data.stream()
                .filter(AppleData.class::isInstance)
                .map(AppleData.class::cast)
                .sorted(Comparator.comparingInt(AppleData::getDestaqueApple).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}


