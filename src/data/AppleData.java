package data;

import java.util.ArrayList;
import java.util.List;

public class AppleData extends SpotifyData {
    private int destaqueApple;
    List<AppleData> appleData = new ArrayList<AppleData>();

    public AppleData(String nome, String artista, int numeroDeOuvidas, int numeroDePlaylists, int destaqueApple) {
        super(nome, artista, numeroDeOuvidas, numeroDePlaylists);
        this.destaqueApple = destaqueApple;
        this.appleData.add(this);
    }

    public int getDestaqueApple() {
        return destaqueApple;
    }

    public void setDestaqueApple(int destaqueApple) {
        this.destaqueApple = destaqueApple;
    }
}
