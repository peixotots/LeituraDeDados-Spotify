package data;

public class SpotifyData {
    private String nome;
    private String artista;
    private int getNumeroDeReproducoes;
    private int numeroDePlaylists;

    public SpotifyData(String nome, String artista, int getNumeroDeReproducoes, int numeroDePlaylists) {
        this.nome = nome;
        this.artista = artista;
        this.getNumeroDeReproducoes = getNumeroDeReproducoes;
        this.numeroDePlaylists = numeroDePlaylists;
    }

    public String getArtista() {
        return artista;
    }

    public int getNumeroDePlaylists() {
        return numeroDePlaylists;
    }

    public int getNumeroDeReproducoes() {
        return getNumeroDeReproducoes;
    }

    public String getNome() {
        return nome;
    }
}
