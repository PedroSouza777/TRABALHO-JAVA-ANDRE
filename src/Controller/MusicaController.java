package Controller;

import Model.Artista;
import Model.BancoDados;
import Model.Musica;
import View.MusicaView;

public class MusicaController {
    private final BancoDados banco;
    private final MusicaView view;

    public MusicaController(BancoDados banco, MusicaView view) {
        this.banco = banco;
        this.view = view;
    }

    public void cadastrarMusica() {
        String nome = view.lerNomeMusica();
        String nomeArtista = view.lerNomeArtista();
        Artista artista = banco.buscarArtistaPorNome(nomeArtista);
        if (artista == null) {
            throw new IllegalArgumentException("Cadastre o artista antes da musica.");
        }
        int duracao = view.lerDuracao();
        Musica musica = new Musica(nome, artista, duracao);
        artista.adicionarMusica(musica);
        banco.cadastrar(musica);
        banco.alterar(artista);
        view.mostrarCadastrada();
    }

    public void listarMusicas() {
        for (Musica musica : banco.getMusicas()) {
            view.mostrarMusica(musica);
        }
    }

    public void pesquisarMusica() {
        Musica musica = buscarPorNome();
        view.mostrarMusica(musica);
    }

    public void alterarMusica() {
        Musica musica = buscarPorNome();
        musica.setNome(view.lerNovoNome());
        musica.setDuracaoSegundos(view.lerNovaDuracao());
        banco.alterar(musica);
        view.mostrarAlterada();
    }

    public void deletarMusica() {
        Musica musica = buscarPorNome();
        if (banco.deletar(musica.getId(), Musica.class)) {
            view.mostrarDeletada();
        }
    }

    private Musica buscarPorNome() {
        String nome = view.lerNomeMusica();
        Musica musica = banco.buscarMusicaPorNome(nome);
        if (musica == null) {
            throw new IllegalArgumentException("Musica nao encontrada.");
        }
        return musica;
    }
}