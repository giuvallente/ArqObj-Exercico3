package br.insper.campeonato.time;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TimeService {

    private ArrayList<Time> times = new ArrayList<>();

    public void cadastraTime(Time time) {

        if (time.equals("") || time.equals("")) {
            return;
        } else {
            times.add(time);
        }
    }

    public ArrayList<Time> listaTimes(String estado) {
        if (estado != null) {
            ArrayList<Time> lista = new ArrayList<>();
            for (Time time : times) {
                if (time.getEstado().equals(estado)) {
                    lista.add(time);
                    break;
                }
            }
            return lista;
        }
        return times;
    }

    public Time getTime(String id) {
        for (Time time : times) {
            if (time.getId().equals(id)) {
                return time;
            }
        }

        return null;
    }
}
