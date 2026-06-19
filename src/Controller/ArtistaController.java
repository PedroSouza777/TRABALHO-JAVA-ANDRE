package controller;

import model.Artista;
import model.BancoDados;
import model.Musica;
import view.ArtistaView;

public class ArtistaController {
    private final BancoDados banco;
    private final ArtistaView view;

    public ArtistaController(BancoDados banco, ArtistaView view) {
        this.banco = banco;
        this.view = view;
    }

    public void cadastrarArtista() {
        String nome = view.lerNomeArtista();
        String genero = view.lerGenero();
        banco.cadastrar(new Artista(nome, genero));
        view.mostrarCadastrado();
    }

    public void listarArtistas() {
        for (Artista artista : banco.getArtistas()) {
            view.mostrarArtista(artista);
        }
    }

    public void pesquisarArtista() {
        Artista artista = buscarPorNome();
        view.mostrarArtista(artista);
        for (Musica musica : artista.getMusicas()) {
            view.mostrarMusicaDoArtista(musica);
        }
    }

    public void alterarArtista() {
        Artista artista = buscarPorNome();
        artista.setNome(view.lerNovoNome());
        artista.setGenero(view.lerNovoGenero());
        banco.alterar(artista);
        view.mostrarAlterado();
    }

    public void deletarArtista() {
        Artista artista = buscarPorNome();
        if (banco.deletar(artista.getId(), Artista.class)) {
            view.mostrarDeletado();
        }
    }

    private Artista buscarPorNome() {
        String nome = view.lerNomeArtista();
        Artista artista = banco.buscarArtistaPorNome(nome);
        if (artista == null) {
            throw new IllegalArgumentException("Artista nao encontrado.");
        }
        return artista;
    }
}
