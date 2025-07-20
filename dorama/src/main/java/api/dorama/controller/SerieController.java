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
    public List<Serie> listarSeries() {
        return doramaService.listarSeries();
    }

    @PostMapping
    public ResponseEntity<Serie> criarSerie(@RequestBody Serie serie) {
        Serie serieCriada = doramaService.criarSerieDorama(serie);
        return ResponseEntity.status(HttpStatus.CREATED).body(serieCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarSerie(@PathVariable Long id, @RequestBody Serie novaSerie){
        Serie existe = doramaService.buscarSerie(id);
        if (existe!= null){
            doramaService.editarSeries(existe, novaSerie);

            return ResponseEntity.accepted().body("Editada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serie não encontrada.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirSerie(@PathVariable Long id){
        Serie existe = doramaService.buscarSerie(id);
        if (existe != null){
            doramaService.excluirSerie(existe);
            return ResponseEntity.ok("serie excluida com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A serie não foi encontrada.");
    }


}
