package data;

import filter.TopFiveFilter;

import java.util.ArrayList;
import java.util.List;

public class SpotifyData {
    private String nome;
    private String artista;
    private int getNumeroDeReproducoes;
    private int numeroDePlaylists;
    List<SpotifyData> musicas = new ArrayList<>();

    public SpotifyData(String nome, String artista, int getNumeroDeReproducoes, int numeroDePlaylists) {
        this.nome = nome;
        this.artista = artista;
        this.getNumeroDeReproducoes = getNumeroDeReproducoes;
        this.numeroDePlaylists = numeroDePlaylists;
        this.musicas.add(this);
        TopFiveFilter topFiveFilter = new TopFiveFilter();
        topFiveFilter.applyFilter(musicas);
    }

    public String getArtista() {
        return artista;
    }

    public int getNumeroDePlaylists() {
        return numeroDePlaylists;
    }

    public List<SpotifyData> getMusicas() {
        return musicas;
    }

    public int getNumeroDeReproducoes() {
        return getNumeroDeReproducoes;
    }

    public String getNome() {
        return nome;
    }
}
