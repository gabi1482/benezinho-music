package br.com.fiap.domain.view;

import br.com.fiap.domain.entity.Artista;
import br.com.fiap.domain.entity.Estilo;
import br.com.fiap.domain.entity.Musica;
import br.com.fiap.domain.repository.ArtistaRepository;
import br.com.fiap.domain.repository.EstiloRepository;
import br.com.fiap.domain.service.ArtistaService;
import br.com.fiap.domain.service.MusicaService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MusicaView {

    List<Artista> artistas = new ArrayList<>();
    List<Estilo> estilos = new ArrayList<>();


    private MusicaService service = new MusicaService();

    public  void menu() {

        int escolha = 0;

        do {

            escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: \n " +
                    "[1] - Adicionar música \n" +
                    "[2] - Procurar música pelo ID \n" +
                    "[3] - Procurar música pelo Nome \n" +
                    "[4] - Encerrar programa "));

            switch (escolha){
                case 1 -> {
                    Musica musica = addMusica();
                    JOptionPane.showMessageDialog(null, musica);
                    menu();
                }

                case 2 -> {
                    Long id = Long.valueOf(JOptionPane.showInputDialog("ID da múdica: "));
                    Musica m = service.findById(id);
                    JOptionPane.showMessageDialog(null,m);
                }

                case 3 -> {
                    String nome = JOptionPane.showInputDialog("Nome da música:");
                    List<Musica> list = service.findByName(nome);
                    list.forEach(m -> {
                        JOptionPane.showMessageDialog(null, m);
                    });

                }
                case 4 -> {

                }

                default -> {
                    JOptionPane.showMessageDialog(null, "Opção inválida :( ");
                }

            }

        } while (escolha != 4);
    }

    public Musica addMusica(){

        Musica m = null;

        ArtistaRepository artistaRepository = new ArtistaRepository();
        EstiloRepository estiloRepository = new EstiloRepository();

        artistas = artistaRepository.findAll();
        estilos = estiloRepository.findAll();

        if (artistas.size() > 0 && estilos.size() > 0){
            Artista artista = (Artista) JOptionPane.showInputDialog(null, "Escolha o artista:", "Seleção de Artistas:", JOptionPane.QUESTION_MESSAGE, null, artistas.toArray(), artistas.get(0));
            if(Objects.isNull(artista)) return m;

            Estilo estilo = (Estilo) JOptionPane.showInputDialog(null, "Escolha o estilo da música:", "Seleção de Estilo:", JOptionPane.QUESTION_MESSAGE, null, estilos.toArray(), estilos.get(0));
            if(Objects.isNull(estilo)) return m;

            String musica = "";

            do{
                musica = JOptionPane.showInputDialog("Informe o nome da música que deseja adicionar:");
            }while(musica == "");



            m = new Musica();
            m.addArtista(artista).setEstilo(estilo).setNome(musica);
            Musica persist = service.persist(m);

            if (Objects.nonNull(persist)){
                JOptionPane.showMessageDialog(null,"Sucesso! Sua música foi adicionada:");

            }else{
                JOptionPane.showMessageDialog(null,"Não foi possivel adicionar sua música");
            }

        }
        return m;
    }


}


