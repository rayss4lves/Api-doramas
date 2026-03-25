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
    public ResponseEntity<List<Dorama>> filtrarPorGenero(@RequestParam String gender, @RequestParam String type) {
        List<Dorama> filtrados = doramaService.filterGender(gender);
        if(type!=null){
            filtrados = doramaService.filterType(type, filtrados);
        }
        if (filtrados!=null)
            if (filtrados.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        return ResponseEntity.ok(filtrados);
    }

    @GetMapping("/emissora")
    public ResponseEntity<List<Dorama>> filterBroadcast_network(@RequestParam String broadcastName, @RequestParam String type) {
        List<Dorama> filtrados = doramaService.filterBroadcast_network(broadcastName);
        if(type!=null){
            filtrados = doramaService.filterType(type, filtrados);
        }
        if (filtrados!=null)
            if (filtrados.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        return ResponseEntity.ok(filtrados);

    }

    @GetMapping("/pais")
    public ResponseEntity<List<Dorama>> filterCountry(@RequestParam String countryName, @RequestParam String type) {
        List<Dorama> filtrados = doramaService.filterCountry(countryName);
        if(type!=null){
            filtrados = doramaService.filterType(type, filtrados);
        }
        if (filtrados.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        return ResponseEntity.ok(filtrados);
    }



}
