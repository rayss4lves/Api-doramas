package api.dorama.controller;

import api.dorama.model.Filme;
import api.dorama.service.DoramaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    private final DoramaService doramaService;

    public FilmeController(DoramaService doramaService) {
        this.doramaService = doramaService;
    }
    @GetMapping
    public List<Filme> listarFilme() {
        return doramaService.listarFilme();
    }

    @PostMapping
    public ResponseEntity<Filme> criarSerie(@RequestBody Filme filme) {
        Filme filmeCriado = doramaService.criarFilmeDorama(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarFilme(@PathVariable Long id, @RequestBody Filme novoFilme){
        Filme existe = doramaService.buscarFilme(id);
        if (existe!= null){
            doramaService.editarFilmes(existe, novoFilme);

            return ResponseEntity.accepted().body("Editada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrada.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirFilme(@PathVariable Long id, @RequestBody Filme filme){
        Filme existe = doramaService.buscarFilme(id);
        if (existe != null){
            doramaService.excluirFilme(existe);
            return ResponseEntity.ok("filme excluida com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("o filme não foi encontrada.");
    }
}
