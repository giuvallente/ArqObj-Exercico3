package br.insper.campeonato.campeonato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;

    @PostMapping("/campeonato")
    public void postCampeonato(@RequestBody Campeonato campeonato) {
        campeonatoService.cadastraCampeonato(campeonato);
    }

    @GetMapping("/campeonato")
    public ArrayList<Campeonato> getCampeonatos(@RequestParam(required = false) String nome) {
        return campeonatoService.listaCampeonatos(nome);
    }
}
