package data;

public class DeezerData extends SpotifyData {
    private int destaqueDeezer;

    public DeezerData(String nome, String artista, int getNumeroDeReproducoes, int numeroDePlaylists, int destaqueDeezer) {
        super(nome, artista, getNumeroDeReproducoes, numeroDePlaylists);
        this.destaqueDeezer = destaqueDeezer;
    }

    public int getDestaqueDeezer() {
        return destaqueDeezer;
    }
}
