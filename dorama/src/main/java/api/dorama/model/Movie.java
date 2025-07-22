package api.dorama.model;

public class Movie extends Dorama{

    private Long idMovie;
    private int duration;

    public Movie() {
        super();
    }


    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie){
        this.idMovie = idMovie;
    }

    public int getDuration() {
        return duration/60;
    }
    public void setDuration(int duration) {
        if(duration < 0) {
            this.duration = 0;
        } else {
            this.duration = duration;
        }
    }

    public void listarDoramasFormatado(){
        System.out.println("Id: "+getIdMovie());
        System.out.println("Título: " + getTitle());
        System.out.println("Gêneros: " + getGender());
        System.out.println("Emissora: " + getBroadcast_network());
        System.out.println("País de Origem: " + getCountry());
        System.out.println("Duração: " + getDuration());
    }
}
