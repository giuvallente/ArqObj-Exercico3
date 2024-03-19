package br.insper.campeonato.time;

import java.util.UUID;

import static java.util.UUID.randomUUID;

public class Time {
    private String id;
    private String nome;
    private String estadio;
    private String estado;

    public Time(String nome, String estadio, String estado) {
        this.id = randomUUID().toString();
        this.nome = nome;
        this.estadio = estadio;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
