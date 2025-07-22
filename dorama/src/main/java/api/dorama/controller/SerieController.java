package api.dorama.controller;

import api.dorama.model.Serie;
import api.dorama.service.DoramaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serie")
public class SerieController {

    private final DoramaService doramaService;

    public SerieController(DoramaService doramaService) {
        this.doramaService = doramaService;
    }

    @GetMapping
    public List<Serie> listSeries() {
        return doramaService.listSeries();
    }

    @PostMapping
    public ResponseEntity<Serie> createSerie(@RequestBody Serie serie) {
        Serie crietedSerie = doramaService.createSerieDorama(serie);
        return ResponseEntity.status(HttpStatus.CREATED).body(crietedSerie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarSerie(@PathVariable Long id, @RequestBody Serie novaSerie){
        Serie exist = doramaService.searchSerie(id);
        if (exist!= null){
            doramaService.editSeries(exist, novaSerie);

            return ResponseEntity.accepted().body("Editada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serie não encontrada.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSerie(@PathVariable Long id){
        Serie exist = doramaService.searchSerie(id);
        if (exist != null){
            doramaService.deleteSerie(exist);
            return ResponseEntity.ok("serie excluida com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A serie não foi encontrada.");
    }


}
