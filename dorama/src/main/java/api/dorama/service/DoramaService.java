package api.dorama.service;

import api.dorama.model.Dorama;
import api.dorama.model.Filme;
import api.dorama.model.Serie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoramaService {

    private List<Serie> seriesDoramas = new ArrayList<Serie>();
    private List<Filme> filmeDoramas = new ArrayList<Filme>();

    //SERIES

    public Serie criarSerieDorama(Serie serieDorama) {

        seriesDoramas.add(serieDorama);
        return serieDorama;
    }

    public void editarSeries(Serie serieExistente, Serie novaSerie) {

        serieExistente.setIdSerie(novaSerie.getIdSerie());

        serieExistente.setTitulo(novaSerie.getTitulo());

        serieExistente.setEmissora(novaSerie.getEmissora());

        serieExistente.setPaisOrigem(novaSerie.getPaisOrigem());

        serieExistente.setQtdTemporadas(novaSerie.getQtdTemporadas());

        serieExistente.setQtdEpisodios(novaSerie.getQtdEpisodios());


    }

    public void excluirSerie(Serie serieEncontrada) {
        seriesDoramas.remove(serieEncontrada);
    }

    public List<Serie> listarSeries() {
        return new ArrayList<>(seriesDoramas);
    }

    public Serie buscarSerie(Long id) {
        for (Serie serie : seriesDoramas) {
            if (serie.getIdSerie().equals(id)) {
                return serie;
            }
        }
        return null;
    }


    //FILMES

    public Filme criarFilmeDorama(Filme filmeDorama) {
        filmeDoramas.add(filmeDorama);
        return filmeDorama;
    }

    public void editarFilmes(Filme filmeEncontrado, Filme novoFilme){

        filmeEncontrado.setIdFilme(novoFilme.getIdFilme());
        filmeEncontrado.setTitulo(novoFilme.getTitulo());
        filmeEncontrado.setEmissora(novoFilme.getEmissora());
        filmeEncontrado.setPaisOrigem(novoFilme.getPaisOrigem());
        filmeEncontrado.setDuracao(novoFilme.getDuracao());

    }

    public void excluirFilme(Filme filmeEncontrado) {
        filmeDoramas.remove(filmeEncontrado);
    }

    public List<Filme> listarFilme() {
        return new ArrayList<>(filmeDoramas);
    }

    public Filme buscarFilme(Long id) {
        for (Filme filme : filmeDoramas) {
            if (filme.getIdFilme().equals(id)) {
                return filme;
            }
        }
        return null;
    }


    //FILTROS

    public List<Dorama> filtrarGenero(String genero){

        List<Dorama> doramasFiltrados = new ArrayList<Dorama>();
        List<Dorama> todosDoramas = new ArrayList<Dorama>();

        todosDoramas.addAll(filmeDoramas);
        todosDoramas.addAll(seriesDoramas);
        for (Dorama dorama : todosDoramas) {
            if (dorama.getGenero().equalsIgnoreCase(genero)) {
                doramasFiltrados.add(dorama);
            }
        }
        return doramasFiltrados;
    }


    public List<Dorama> filtrarEmissora(String emissora){

        List<Dorama> doramasFiltrados = new ArrayList<Dorama>();
        List<Dorama> todosDoramas = new ArrayList<Dorama>();

        todosDoramas.addAll(filmeDoramas);
        todosDoramas.addAll(seriesDoramas);
        for (Dorama dorama : todosDoramas) {
            if (emissora.equalsIgnoreCase(dorama.getEmissora())) {
                doramasFiltrados.add(dorama);
            }
        }

        return doramasFiltrados;
    }

    public List<Dorama> filtrarPais(String paisOrigem){

        List<Dorama> doramasFiltrados = new ArrayList<Dorama>();
        List<Dorama> todosDoramas = new ArrayList<Dorama>();

        todosDoramas.addAll(filmeDoramas);
        todosDoramas.addAll(seriesDoramas);
        for (Dorama dorama : todosDoramas) {
            if (paisOrigem.equalsIgnoreCase(dorama.getPaisOrigem())) {
                doramasFiltrados.add(dorama);
            }
        }

        return doramasFiltrados;
    }


}