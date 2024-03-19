package br.insper.campeonato.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TimeController {
    @Autowired
    private TimeService timeService;

    @GetMapping("/time")
    public ArrayList<Time> getTimes(@RequestParam(required = false) String estado) {
        return timeService.listaTimes(estado);
    }

    @GetMapping("/time/{id}")
    public Time getTime(@PathVariable String id) {
        return timeService.getTime(id);
    }

    @PostMapping("/time")
    public void postCliente(@RequestBody Time time) {
        timeService.cadastraTime(time);
    }
}
