package data;

public class AppleData extends SpotifyData {
    private final int destaqueApple;

    public AppleData(String nome, String artista, int numeroDeOuvidas, int numeroDePlaylists, int destaqueApple) {
        super(nome, artista, numeroDeOuvidas, numeroDePlaylists, 0);
        this.destaqueApple = destaqueApple;
    }

    public int getDestaqueApple() {
        return destaqueApple;
    }
}
