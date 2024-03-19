package br.insper.campeonato.partida;

import br.insper.campeonato.time.Time;
import br.insper.campeonato.time.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PartidaController {

    @Autowired
    private PartidaService partidaService;

    @PostMapping("/partida")
    public void postPartida(@RequestBody Partida partida) {
        partidaService.cadastrarPartida(partida);
    }

    @GetMapping("/partida")
    public ArrayList<Partida> getPartidas(@RequestParam(required = false) String timeMandante) {
        return partidaService.listaPartidas(timeMandante);
    }

    @GetMapping("/partida/{time}")
    public Integer getVitorias(@PathVariable String time) {
        return partidaService.calculaVitorias(time);
    }
}
