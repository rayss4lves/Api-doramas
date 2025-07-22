package api.dorama.model;


public class Serie extends Dorama{

    private Long idSerie;
    private int seasons;
    private int episodes;

    public Serie() {
        super();
    }

    public Long getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Long idSerie){
        this.idSerie = idSerie;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public void listaDoramasFormatado(){
        System.out.println("Título: " + getTitle());
        System.out.println("Gêneros: " + getGender());
        System.out.println("Emissora: " + getBroadcast_network());
        System.out.println("País de Origem: " + getCountry());
        System.out.println("Quantidade de Seasons: " + getSeasons());
        System.out.println("Quantidade de Episódios: " + getEpisodes());

    }
}