package api.dorama.model;

public class Filme extends Dorama{

    private Long idFilme;
    private int duracao;

    public Filme() {
        super();
    }


    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme){
        this.idFilme = idFilme;
    }

    public int getDuracao() {
        return duracao/60;
    }
    public void setDuracao(int duracao) {
        if (duracao < 0) {
            this.duracao = 0;
        } else {
            this.duracao = duracao;
        }
    }

    public void listaDoramasFormatado(){
        System.out.println("Id: "+getIdFilme());
        System.out.println("Título: " + getTitulo());
        System.out.println("Gêneros: " + getGenero());
        System.out.println("Emissora: " + getEmissora());
        System.out.println("País de Origem: " + getPaisOrigem());
        System.out.println("Duração: " + getDuracao());
    }
}
