package br.com.fiap.domain.service;

import br.com.fiap.domain.entity.Estilo;
import br.com.fiap.domain.repository.ArtistaRepository;
import br.com.fiap.domain.repository.EstiloRepository;

import java.util.List;
import java.util.Objects;

public class EstiloService implements Service<Estilo,Long>{

    private EstiloRepository repository;

    public EstiloService(){
        this.repository = new EstiloRepository();
    }

    @Override
    public List<Estilo> findAll() {
        return repository.findAll();
    }

    @Override
    public Estilo findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Estilo> findByName(String texto) {
        return repository.findByName(texto);
    }

    @Override
    public Estilo persist(Estilo estilo) {
       if(Objects.nonNull(estilo)){
           return repository.persist(estilo);
       }else{
           return null;
       }
    }
}