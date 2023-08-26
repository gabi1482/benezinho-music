package br.com.fiap.domain.entity;

public class Estilo {

    private Long id;

    private String nome;

    public Estilo() {
    }

    public Estilo(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public Estilo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Estilo setNome(String nome) {
        this.nome = nome;
        return this;
    }


    @Override
    public String toString() {
        return "Estilo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
