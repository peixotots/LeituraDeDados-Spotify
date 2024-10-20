package data;

public class DeezerData extends SpotifyData {
    private final int destaqueDeezer;

    public DeezerData(String nome, String artista, int getNumeroDeReproducoes, int numeroDePlaylists, int destaqueDeezer) {
        super(nome, artista, getNumeroDeReproducoes, numeroDePlaylists, 0);
        this.destaqueDeezer = destaqueDeezer;
    }

    public int getDestaqueDeezer() {
        return destaqueDeezer;
    }
}
