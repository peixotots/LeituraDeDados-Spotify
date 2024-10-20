package data;

public class SpotifyData {
    private final String nome;
    private final String artista;
    private final int getNumeroDeReproducoes;
    private final int numeroDePlaylists;
    private final int anoDeLancamento;

    public SpotifyData(String nome, String artista, int getNumeroDeReproducoes, int numeroDePlaylists, int anoDeLancamento) {
        this.nome = nome;
        this.artista = artista;
        this.getNumeroDeReproducoes = getNumeroDeReproducoes;
        this.numeroDePlaylists = numeroDePlaylists;
        this.anoDeLancamento = anoDeLancamento;
    }

    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }

    public int getNumeroDeReproducoes() {
        return getNumeroDeReproducoes;
    }

    public int getNumeroDePlaylists() {
        return numeroDePlaylists;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }
}