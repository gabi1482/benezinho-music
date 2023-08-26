package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Estilo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EstiloRepository implements Repository<Estilo,Long> {

    private static List<Estilo> estilos;

    static {
        estilos = new ArrayList<>();

        Estilo pop = new Estilo(1L,"Pop");
        Estilo rap = new Estilo(2L,"Rap");
        Estilo sertanejo = new Estilo(3L,"Sertanejo");

        estilos.addAll(Arrays.asList(pop,rap,sertanejo));
    }

    public List<Estilo>findAll(){
        return estilos;
    }

    public Estilo findById(Long id){
        for(int i = 0; i<estilos.size();i++){
            return estilos.get(i);
        }
        return null;
    }

    public List<Estilo> findByName(String texto){
        List<Estilo> estilosEncontrados = new ArrayList<>();
        for(Estilo e : estilos){
            if(e.getNome().equalsIgnoreCase(texto)){
                estilosEncontrados.add(e);
            }
        }
        return estilosEncontrados;
    }

    public Estilo persist(Estilo e){
        e.setId(estilos.size()+1L);
        estilos.add(e);
        return e;
    }


}
