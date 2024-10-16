package data;

import java.util.List;

public interface DataFilter {
        List<SpotifyData> applyFilter(List<SpotifyData> data);
}
