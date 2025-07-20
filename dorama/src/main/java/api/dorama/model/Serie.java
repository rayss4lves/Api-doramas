package api.dorama.model;


public class Serie extends Dorama{

    private Long idSerie;
    private int qtdTemporadas;
    private int qtdEpisodios;

    public Serie() {
        super();
    }

    public Long getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Long idSerie){
        this.idSerie = idSerie;
    }

    public int getQtdTemporadas() {
        return qtdTemporadas;
    }

    public void setQtdTemporadas(int qtdTemporadas) {
        this.qtdTemporadas = qtdTemporadas;
    }

    public int getQtdEpisodios() {
        return qtdEpisodios;
    }

    public void setQtdEpisodios(int qtdEpisodios) {
        this.qtdEpisodios = qtdEpisodios;
    }

    public void listaDoramasFormatado(){
        System.out.println("Título: " + getTitulo());
        System.out.println("Gêneros: " + getGenero());
        System.out.println("Emissora: " + getEmissora());
        System.out.println("País de Origem: " + getPaisOrigem());
        System.out.println("Quantidade de Temporadas: " + getQtdTemporadas());
        System.out.println("Quantidade de Episódios: " + getQtdEpisodios());

    }
}