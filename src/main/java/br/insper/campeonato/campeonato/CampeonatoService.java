package br.insper.campeonato.campeonato;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CampeonatoService {

    private ArrayList<Campeonato> campeonatos = new java.util.ArrayList<>();

    public void cadastraCampeonato(Campeonato campeonato) {
        if (campeonato.getNome().equals("")) {
            return;
        } else {
            campeonatos.add(campeonato);
        }
    }

    public ArrayList<Campeonato> listaCampeonatos(String nome) {
        if (nome != null) {
            ArrayList<Campeonato> lista = new ArrayList<>();
            for (Campeonato campeonato : campeonatos) {
                if (campeonato.getNome().equals(nome)) {
                    lista.add(campeonato);
                    break;
                }
            }
            return lista;
        }
        return campeonatos;
    }

    public Campeonato getCampeonato(String id) {
        for (Campeonato campeonato : campeonatos) {
            if (campeonato.getId().equals(id)) {
                return campeonato;
            }
        }
        return null;
    }
}
