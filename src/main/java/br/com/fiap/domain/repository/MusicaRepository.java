package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Musica;

import java.util.ArrayList;
import java.util.List;

public class MusicaRepository implements Repository<Musica, Long>{

    private  List<Musica> musicas;

   public MusicaRepository () {
       musicas = new ArrayList<>();

   }

    @Override
    public List<Musica> findAll() {
        return musicas;
    }

    @Override
    public Musica findById(Long id) {
        for (Musica m : musicas){
            if(m.getId().equals(id)){
                return m;
            }
        }
        return null;
    }

    @Override
    public List<Musica> findByName(String texto) {
        List<Musica> musicasEncontrados = new ArrayList<>();
        for (Musica m:musicas){
            if(m.getNome().equalsIgnoreCase(texto)){
                musicasEncontrados.add(m);
            }
        }
        return musicasEncontrados;
    }

    @Override
    public Musica persist(Musica m) {
        m.setId(musicas.size()+1L);
        this.musicas.add(m);
        return m;

    }
}
