package br.com.fiap.domain.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Musica {

    private Long id;
    private String nome;
    private Estilo estilo;
    private Set<Artista> artistas = new HashSet<>();

    public Musica() {
    }

    public Musica(Long id, String nome, Estilo estilo, Set<Artista> artistas) {
        this.id = id;
        this.nome = nome;
        this.estilo = estilo;
        this.artistas = Objects.isNull(artistas) ? new HashSet<>():artistas;
    }

    public Long getId() {
        return id;
    }

    public Musica setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Musica setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public Musica setEstilo(Estilo estilo) {
        this.estilo = estilo;
        return this;
    }

    public Set<Artista> getArtistas() {
        return Collections.unmodifiableSet( artistas );
    }

    public Musica addArtista(Artista a) {
        this.artistas.add( a );
        return this;
    }

    public Musica removeArtista(Artista a) {
        this.artistas.remove( a );
        return this;
    }


    @Override
    public String toString() {
        return "Musica{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estilo=" + estilo +
                ", artistas=" + artistas +
                '}';
    }
}
