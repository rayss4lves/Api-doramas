package api.dorama.controller;

import api.dorama.model.*;
import api.dorama.model.enuns.StatusProgress;
import api.dorama.service.DoramaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping

public class ProgressControllerSerie {
    private final DoramaService doramaService;
    public ProgressControllerSerie(DoramaService doramaService) {
        this.doramaService = doramaService;
    }

    @PostMapping("/series/inicializar/{id}")
    public ResponseEntity<String> inicializarProgressoSerie(@PathVariable Long id) {
        Serie foundSerie = doramaService.searchSerie(id);
        if (foundSerie != null) {
            doramaService.inicializarProgressoSerie(foundSerie, foundSerie.getEpisodes(), 0, StatusProgress.ASSISTINDO);
            return ResponseEntity.ok("Progresso da série inicializado com sucesso.");
        }
        return ResponseEntity.status(404).body("Série não encontrada.");
    }



    @GetMapping("/series/listprogresso/{id}")
    public ResponseEntity<ProgressDorama> listarProgressoSerie(@PathVariable Long id) {
        Serie serie = doramaService.searchSerie(id);
        if (serie != null) {
            ProgressDorama progresso = doramaService.verProgressoAtual(serie);
            return ResponseEntity.ok().body(progresso);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/series/atualizarprogresso/{id}")
    public ResponseEntity<String> atualizarProgressoSerie(@PathVariable Long id, @RequestBody int episodesAssistidos) {
        Serie serie = doramaService.searchSerie(id);
        if (serie != null) {
            ProgressDorama progressoAtual = doramaService.verProgressoAtual(serie);
            if (progressoAtual instanceof ProgressSerie) {
                doramaService.atualizarProgressoSerie(serie, episodesAssistidos);
                return ResponseEntity.ok("Progresso da série atualizado com sucesso.");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O progresso não é do tipo esperado.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Série não encontrada.");
    }


}
