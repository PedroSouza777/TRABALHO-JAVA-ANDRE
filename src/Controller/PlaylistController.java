package Controller;

import model.BancoDados;
import model.Musica;
import model.Playlist;
import model.Usuario;
import view.PlaylistView;

public class PlaylistController {
    private final BancoDados banco;
    private final PlaylistView view;

    public PlaylistController(BancoDados banco, PlaylistView view) {
        this.banco = banco;
        this.view = view;
    }

    public void criarPlaylist() {
        Usuario usuario = buscarUsuario();
        String nome = view.lerNomePlaylist();
        banco.cadastrar(new Playlist(nome, usuario));
        banco.registrarHistorico(usuario.getEmail(), "Criacao de playlist");
        view.mostrarCriada();
    }

    public void adicionarMusica() {
        Playlist playlist = buscarPlaylist();
        String nomeMusica = view.lerNomeMusica();
        Musica musica = banco.buscarMusicaPorNome(nomeMusica);
        if (musica == null) {
            throw new IllegalArgumentException("Musica nao encontrada.");
        }
        playlist.adicionarMusica(musica);
        banco.alterar(playlist);
        banco.registrarHistorico(playlist.getDono().getEmail(), "Musica adicionada na playlist");
        view.mostrarMusicaAdicionada();
    }

    public void listarPlaylists() {
        for (Playlist playlist : banco.getPlaylists()) {
            view.mostrarPlaylist(playlist);
            for (Musica musica : playlist.getMusicas()) {
                view.mostrarMusica(musica);
            }
        }
    }

    private Usuario buscarUsuario() {
        String email = view.lerEmailUsuario();
        Usuario usuario = banco.buscarUsuarioPorEmail(email);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario nao encontrado.");
        }
        return usuario;
    }

    private Playlist buscarPlaylist() {
        String nome = view.lerNomePlaylist();
        for (Playlist playlist : banco.getPlaylists()) {
            if (playlist.getNome().equalsIgnoreCase(nome)) {
                return playlist;
            }
        }
        throw new IllegalArgumentException("Playlist nao encontrada.");
    }
}