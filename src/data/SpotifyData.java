package data;

public class SpotifyData {
    private final String nome;
    private final String artista;
    private final int numeroDeReproducoes;
    private final int numeroDePlaylists;
    private final int anoDeLancamento;

    public SpotifyData(String nome, String artista, int numeroDeReproducoes, int numeroDePlaylists, int anoDeLancamento) {
        this.nome = nome;
        this.artista = artista;
        this.numeroDeReproducoes = numeroDeReproducoes;
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
        return numeroDeReproducoes;
    }

    public int getNumeroDePlaylists() {
        return numeroDePlaylists;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }
}