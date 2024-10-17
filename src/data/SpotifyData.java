package data;

public class SpotifyData {
    private String nome;
    private String artista;
    private int numeroDeOuvidas;
    private int numeroDePlaylists;

    public SpotifyData(String nome, String artista, int numeroDeOuvidas, int numeroDePlaylists) {
        this.nome = nome;
        this.artista = artista;
        this.numeroDeOuvidas = numeroDeOuvidas;
        this.numeroDePlaylists = numeroDePlaylists;
    }


    public int getNumeroDeOuvidas() {
        return numeroDeOuvidas;
    }


    @Override
    public String toString() {
        return String.format("%s - %s (%d ouvidas, %d playlists)", nome, artista, numeroDeOuvidas, numeroDePlaylists);
    }

    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }

    public int getNumeroDePlaylists() {
        return numeroDePlaylists;
    }
}
