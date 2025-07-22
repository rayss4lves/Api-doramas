package api.dorama.service;

import api.dorama.model.*;
import api.dorama.model.enuns.StatusProgress;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoramaService {

    private List<Serie> seriesDoramas = new ArrayList<Serie>();
    private List<Movie> moviesDoramas = new ArrayList<Movie>();
    private List<ProgressDorama> progressDorama = new ArrayList<ProgressDorama>();

    //SERIES

    public Serie createSerieDorama(Serie serieDorama) {

        seriesDoramas.add(serieDorama);
        return serieDorama;
    }

    public void editSeries(Serie foundSeries, Serie newSerie) {

        foundSeries.setIdSerie(newSerie.getIdSerie());

        foundSeries.setTitle(newSerie.getTitle());

        foundSeries.setBroadcast_network(newSerie.getBroadcast_network());

        foundSeries.setCountry(newSerie.getCountry());

        foundSeries.setSeasons(newSerie.getSeasons());

        foundSeries.setEpisodes(newSerie.getEpisodes());

        foundSeries.setStatusDorama(newSerie.getStatusDorama());


    }

    public void deleteSerie(Serie foundSeries) {
        seriesDoramas.remove(foundSeries);
    }

    public List<Serie> listSeries() {
        return new ArrayList<>(seriesDoramas);
    }

    public Serie searchSerie(Long id) {
        for (Serie serie : seriesDoramas) {
            if (serie.getIdSerie().equals(id)) {
                return serie;
            }
        }
        return null;
    }


    //FILMES

    public Movie createMovieDorama(Movie movieDorama) {
        moviesDoramas.add(movieDorama);
        return movieDorama;
    }

    public void editMovies(Movie foundMovie, Movie newMovie){

        foundMovie.setIdMovie(newMovie.getIdMovie());
        foundMovie.setTitle(newMovie.getTitle());
        foundMovie.setBroadcast_network(newMovie.getBroadcast_network());
        foundMovie.setCountry(newMovie.getCountry());
        foundMovie.setDuration(newMovie.getDuration());
        foundMovie.setStatusDorama(newMovie.getStatusDorama());

    }

    public void deleteMovie(Movie foundMovie) {
        moviesDoramas.remove(foundMovie);
        progressDorama.removeIf(progresso -> progresso.getDorama().equals(foundMovie));

    }

    public List<Movie> listMovie() {
        return new ArrayList<>(moviesDoramas);
    }

    public Movie searchMovie(Long id) {

        return moviesDoramas.stream()
                .filter(movie -> id.equals(movie.getIdMovie()))
                .findFirst().orElse(null);
    }


    //FILTROS

    public List<Dorama> getAllDoramas() {

        List<Dorama> allDoramas = new ArrayList<Dorama>();

        allDoramas.addAll(moviesDoramas);
        allDoramas.addAll(seriesDoramas);

        return allDoramas;
    }

    public List<Dorama> filterGender(String gender){

        List<Dorama> allDoramas = getAllDoramas();
        List<Dorama> filteredDorama = allDoramas.stream()
                .filter(dorama-> gender.equalsIgnoreCase(dorama.getGender()))
                .collect(Collectors.toList());

        return filteredDorama;
    }


    public List<Dorama> filterBroadcast_network(String emissora){
        List<Dorama> allDoramas = getAllDoramas();

        List<Dorama> filteredDorama = allDoramas.stream()
                .filter(dorama -> emissora.equalsIgnoreCase(dorama.getBroadcast_network()))
                .collect(Collectors.toList());

        return filteredDorama;
    }

    public List<Dorama> filterCountry(String country){

        List<Dorama> allDoramas = getAllDoramas();

        List<Dorama> filteredDorama = allDoramas.stream()
                .filter(dorama -> country.equalsIgnoreCase(dorama.getCountry()))
                .collect(Collectors.toList());

        return filteredDorama;
    }

    // PROGRESSO DORAMA

    public void setProgressDoramaList(List<ProgressDorama> progressDorama) {
        this.progressDorama = progressDorama;
    }

    public void inicializarProgressoSerie(Dorama dorama, int totalEpisodios, int episodios, StatusProgress status) {
        progressDorama.add(new ProgressSerie(dorama, totalEpisodios, episodios, status));
    }

    public void inicializarProgressoMovie(Dorama dorama, int duracao, int minutosAssistidos, StatusProgress status) {
        progressDorama.add(new ProgressFilme(dorama, duracao, minutosAssistidos, status));
    }

    public ProgressDorama getProgressoDoramaList(Dorama dorama) {
        for (ProgressDorama progresso : progressDorama) {
            if (progresso.getDorama().equals(dorama)) {
                return progresso;
            }
        }
        return null;
    }

    public ProgressDorama verProgressoAtual(Dorama dorama) {
        ProgressDorama progresso = getProgressoDoramaList(dorama);

        return progresso;
    }


    public void atualizarProgressoSerie(Dorama dorama, int episodesAssistidos) {
        ProgressDorama progresso = getProgressoDoramaList(dorama);

        if (progresso instanceof ProgressSerie) {
            ProgressSerie progressoSerie = (ProgressSerie) progresso;

            progressoSerie.setEpisodesAssistidos(progressoSerie.getEpisodesAssistidos() + episodesAssistidos);
        }
    }


    public void atualizarProgressoFilme(Dorama dorama, int minutosAssistidos) {
        ProgressDorama progresso = getProgressoDoramaList(dorama);

        if (progresso instanceof ProgressFilme) {
            ProgressFilme progressoFilme = (ProgressFilme) progresso;;

            progressoFilme.adicionarMinutesAssistidos(progressoFilme.getMinutesAssistidos()+ minutosAssistidos);

        }
    }



}