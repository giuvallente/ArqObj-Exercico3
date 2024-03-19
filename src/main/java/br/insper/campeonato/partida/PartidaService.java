package br.insper.campeonato.partida;

import br.insper.campeonato.campeonato.CampeonatoService;
import br.insper.campeonato.time.Time;
import br.insper.campeonato.time.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class PartidaService {

    private ArrayList<Partida> partidas = new ArrayList<>();
    @Autowired
    private TimeService timeService;
    @Autowired
    private CampeonatoService campeonatoService;

    public Partida cadastrarPartida(Partida partida) {
        if (timeService.getTime(partida.getTimeMandante().getId()) == null) {
            throw new RuntimeException("Time da casa não encontrado");
        }
        if (timeService.getTime(partida.getTimeVisitante().getId()) == null) {
            throw new RuntimeException("Time visitante não encontrado");
        }
        if (campeonatoService.getCampeonato(partida.getCampeonato().getId()) == null) {
            throw new RuntimeException("Campeonato não encontrado");
        }
        partidas.add(partida);
        return partida;
    }

    public ArrayList<Partida> listaPartidas(Time timeMandante) {

        if (timeMandante != null) {
            ArrayList<Partida> lista = new ArrayList<>();
            for (Partida partida : partidas) {
                if (partida.getTimeMandante().equals(timeMandante)) {
                    lista.add(partida);
                    break;
                }
            }
            return lista;
        }
        return partidas;
    }

    public Integer calculaVitorias(Time time) {
        Integer vitorias = 0;
        for (Partida partida : partidas) {
            if (partida.getTimeMandante().equals(time)) {
                if (partida.getPlacarMandante() > partida.getPlacarVisitante()) {
                    vitorias++;
                }
            } else if (partida.getTimeVisitante().equals(time)) {
                if (partida.getPlacarVisitante() > partida.getPlacarMandante()) {
                    vitorias++;
                }
            }
        }
        return vitorias;
    }
}
