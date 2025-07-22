package api.dorama.controller;

import api.dorama.model.Movie;
import api.dorama.service.DoramaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class MovieController {

    private final DoramaService doramaService;

    public MovieController(DoramaService doramaService) {
        this.doramaService = doramaService;
    }
    @GetMapping
    public List<Movie> listMovie() {
        return doramaService.listMovie();
    }

    @PostMapping
    public ResponseEntity<Movie> createSerie(@RequestBody Movie filme) {
        Movie filmeCriado = doramaService.createMovieDorama(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarMovie(@PathVariable Long id, @RequestBody Movie novoMovie){
        Movie existe = doramaService.searchMovie(id);
        if (existe!= null){
            doramaService.editMovies(existe, novoMovie);

            return ResponseEntity.accepted().body("Editada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie não encontrada.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id){
        Movie existe = doramaService.searchMovie(id);
        if (existe != null){
            doramaService.deleteMovie(existe);
            return ResponseEntity.ok("filme excluida com sucesso!");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("o filme não foi encontrada.");
    }
}
