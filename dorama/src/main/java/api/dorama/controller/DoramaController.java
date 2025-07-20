package api.dorama.controller;

import api.dorama.model.Dorama;
import api.dorama.service.DoramaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/doramas")
public class DoramaController {
    private final DoramaService doramaService;

    public DoramaController(DoramaService doramaService) {
        this.doramaService = doramaService;
    }

    @GetMapping("/genero")
    public ResponseEntity<List<Dorama>> filtrarPorGenero(@RequestParam String genero) {
        List<Dorama> filtrados = doramaService.filtrarGenero(genero);
        if (filtrados!=null)
            if (filtrados.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        return ResponseEntity.ok(filtrados);
    }

    @GetMapping("/emissora")
    public ResponseEntity<List<Dorama>> filtrarPorEmissora(@RequestParam String nomeEmi){
        List<Dorama> filtrados = doramaService.filtrarEmissora(nomeEmi);
        if (filtrados!=null)
            if (filtrados.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        return ResponseEntity.ok(filtrados);

    }

    @GetMapping("/pais")
    public ResponseEntity<List<Dorama>> filtrarPorPais(@RequestParam String nomePais){
        List<Dorama> filtrados = doramaService.filtrarPais(nomePais);
        if (filtrados.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        return ResponseEntity.ok(filtrados);
    }
}
