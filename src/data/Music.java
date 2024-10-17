package data;

public class Music {
    private String nome;
    private String artista;
    private int numeroDeOuvidas;
    private int numeroDePlaylists;

    public Music(String nome, String artista, int numeroDeOuvidas, int numeroDePlaylists) {
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
}
