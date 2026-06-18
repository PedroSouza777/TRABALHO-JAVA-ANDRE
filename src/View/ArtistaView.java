package view;

import model.Artista;
import model.Musica;

public class ArtistaView extends ConsoleView {
    public int menu() {
        mostrar("\n1 - Cadastrar | 2 - Listar | 3 - Pesquisar | 4 - Alterar | 5 - Excluir");
        return lerInt("Escolha: ");
    }

    public String lerNomeArtista() {
        return lerTexto("Nome do artista: ");
    }

    public String lerGenero() {
        return lerTexto("Genero: ");
    }

    public String lerNovoNome() {
        return lerTexto("Novo nome: ");
    }

    public String lerNovoGenero() {
        return lerTexto("Novo genero: ");
    }

    public void mostrarArtista(Artista artista) {
        mostrar(artista.resumo());
    }

    public void mostrarMusicaDoArtista(Musica musica) {
        mostrar(" - " + musica.resumo());
    }

    public void mostrarCadastrado() {
        mostrar("Artista cadastrado.");
    }

    public void mostrarAlterado() {
        mostrar("Artista alterado.");
    }

    public void mostrarDeletado() {
        mostrar("Artista deletado.");
    }
}
