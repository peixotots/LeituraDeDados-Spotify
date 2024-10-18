package data;

public class AppleData extends SpotifyData {
    private int destaqueApple;

    public AppleData(String nome, String artista, int numeroDeOuvidas, int numeroDePlaylists, int destaqueApple) {
        super(nome, artista, numeroDeOuvidas, numeroDePlaylists);
        this.destaqueApple = destaqueApple;
    }

    public int getDestaqueApple() {
        return destaqueApple;
    }
}
