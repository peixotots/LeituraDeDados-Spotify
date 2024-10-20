package data;

import java.util.List;

public interface DataFilter {
        List<SpotifyData> applyFilter(List<? extends SpotifyData> data);
}
