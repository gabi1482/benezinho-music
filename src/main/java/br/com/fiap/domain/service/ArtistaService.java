package br.com.fiap.domain.service;

import br.com.fiap.domain.entity.Artista;
import br.com.fiap.domain.repository.ArtistaRepository;
import com.sun.jdi.ObjectReference;

import java.util.List;
import java.util.Objects;

public class ArtistaService implements Service<Artista, Long> {

    private ArtistaRepository repository;

    public ArtistaService(){
        this.repository = new ArtistaRepository();
    }

    @Override
    public List<Artista> findAll() {
        return repository.findAll();
    }

    @Override
    public Artista findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Artista> findByName(String texto) {
        return repository.findByName(texto);
    }

    @Override
    public Artista persist(Artista artista) {
        if(Objects.nonNull(artista)){
            return repository.persist(artista);
        }else{
            return null;
        }

    }
}
