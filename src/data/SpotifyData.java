package data;

public class SpotifyData {
    private String artist;
    private String musica;
    private String ano;
    private String mes;
    private String dia;
    private String inSpotifyPlaylists;
    private String inSpotifycharts;

    public SpotifyData(String artist, String musica, String ano, String mes, String dia, String inSpotifyPlaylists, String inSpotifycharts) {
        this.artist = artist;
        this.musica = musica;
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.inSpotifyPlaylists = inSpotifyPlaylists;
        this.inSpotifycharts = inSpotifycharts;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getInSpotifyPlaylists() {
        return inSpotifyPlaylists;
    }

    public void setInSpotifyPlaylists(String inSpotifyPlaylists) {
        this.inSpotifyPlaylists = inSpotifyPlaylists;
    }

    public String getInSpotifycharts() {
        return inSpotifycharts;
    }

    public void setInSpotifycharts(String inSpotifycharts) {
        this.inSpotifycharts = inSpotifycharts;
    }
}
