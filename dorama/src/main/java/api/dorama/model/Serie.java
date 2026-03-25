package api.dorama.model;


public class Serie extends Dorama{

    private Long idSerie;
    private Integer seasons;
    private Integer episodes;

    public Serie() {
        super();
    }

    public Long getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Long idSerie){
        this.idSerie = idSerie;
    }

    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
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