package br.com.fiap.domain.entity;

import java.util.Set;

public class Artista {

    private Long id;

    private String nome;

    public Artista() {
    }

    public Artista(Long id, String nome) {
        this.id = id;
        this.nome = nome;

    }

    public Long getId() {
        return id;
    }

    public Artista setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Artista setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
