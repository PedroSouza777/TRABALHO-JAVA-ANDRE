package view;

import model.Musica;

public class MusicaView extends ConsoleView {
    public int menu() {
        mostrar("\n1 - Cadastrar | 2 - Listar | 3 - Pesquisar | 4 - Alterar | 5 - Excluir");
        return lerInt("Escolha: ");
    }

    public String lerNomeMusica() {
        return lerTexto("Nome da musica: ");
    }

    public String lerNomeArtista() {
        return lerTexto("Artista: ");
    }

    public int lerDuracao() {
        return lerInt("Duracao em segundos: ");
    }

    public String lerNovoNome() {
        return lerTexto("Novo nome: ");
    }

    public int lerNovaDuracao() {
        return lerInt("Nova duracao em segundos: ");
    }

    public void mostrarMusica(Musica musica) {
        mostrar(musica.resumo());
    }

    public void mostrarCadastrada() {
        mostrar("Musica cadastrada.");
    }

    public void mostrarAlterada() {
        mostrar("Musica alterada.");
    }

    public void mostrarDeletada() {
        mostrar("Musica deletada.");
    }
}