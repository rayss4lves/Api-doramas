package api.dorama.controller;

import api.dorama.model.*;
import api.dorama.model.enuns.StatusProgress;
import api.dorama.service.DoramaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class ProgressControllerMovie {
    private final DoramaService doramaService;
    public ProgressControllerMovie(DoramaService doramaService) {
        this.doramaService = doramaService;
    }

    @PostMapping("/filmes/inicializar/{id}")
    public ResponseEntity<String> inicializarProgressoMovie(@PathVariable Long id) {
        Movie foundMovie = doramaService.searchMovie(id);
        if (foundMovie != null) {
            doramaService.inicializarProgressoMovie(foundMovie, foundMovie.getDuration(), 0, StatusProgress.ASSISTINDO);
            return ResponseEntity.ok("Progresso do filme inicializado com sucesso.");
        }
        return ResponseEntity.status(404).body("Filme não encontrada.");
    }

    @GetMapping("/filmes/listprogresso/{id}")
    public ResponseEntity<ProgressDorama> listarProgressoMovie(@PathVariable Long id) {
        Movie movie = doramaService.searchMovie(id);
        if (movie != null) {
            ProgressDorama progress = doramaService.verProgressoAtual(movie);
            return ResponseEntity.ok().body(progress);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/filmes/atualizarprogresso/{id}")
    public ResponseEntity<String> atualizarProgressoMovie(@PathVariable Long id, @RequestBody int minutosAssistidos) {
        Movie movie = doramaService.searchMovie(id);
        if (movie != null) {
            ProgressDorama progressoAtual = doramaService.verProgressoAtual(movie);
            if (progressoAtual instanceof ProgressFilme) {
                doramaService.atualizarProgressoFilme(movie, minutosAssistidos);
                return ResponseEntity.ok("Progresso do Filme atualizado com sucesso.");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O progress não é do tipo esperado.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrada.");
    }

    //@DeleteMapping("/filmes/deletarprogresso/{id}")
    //public ResponseEntity<String> deletarProgressoMovie(@PathVariable Long id) {
    //    Movie movie = doramaService.searchMovie(id);
    //     if (movie != null) {
    //        ProgressDorama progressoAtual = doramaService.verProgressoAtual(movie);
    //        if (progressoAtual != null) {
    //            doramaService.deletarProgresso(progressoAtual);
    //            return ResponseEntity.ok("Progresso do filme deletado com sucesso.");
    //        }
    //        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Progresso não encontrado.");
    //    }
    //    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrada.");
    //}

}
