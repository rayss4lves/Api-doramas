package api.dorama.model;

public class Dorama {
    private String titulo;
    private String genero;
    private String emissora;
    private String paisOrigem;

    public Dorama(){

    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getEmissora() {
        return emissora;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEmissora(String emissora) {
        this.emissora = emissora;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

}
