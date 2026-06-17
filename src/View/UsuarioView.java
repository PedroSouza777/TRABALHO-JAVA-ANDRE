package View;

import model.Usuario;

public class UsuarioView extends ConsoleView {
    public int menu() {
        mostrar("\n1 - Cadastrar | 2 - Listar | 3 - Alterar | 4 - Excluir");
        return lerInt("Escolha: ");
    }

    public String lerNome() {
        return lerTexto("Nome: ");
    }

    public String lerEmail() {
        return lerTexto("Email do usuario: ");
    }

    public String lerEmailCadastro() {
        return lerTexto("Email: ");
    }

    public String lerSenha() {
        return lerTexto("Senha: ");
    }

    public String lerNovoNome() {
        return lerTexto("Novo nome: ");
    }

    public String lerNovaSenha() {
        return lerTexto("Nova senha: ");
    }

    public void mostrarUsuario(Usuario usuario) {
        mostrar(usuario.resumo());
    }

    public void mostrarCadastrado() {
        mostrar("Usuario cadastrado no plano Free.");
    }

    public void mostrarAlterado() {
        mostrar("Usuario alterado.");
    }

    public void mostrarDeletado() {
        mostrar("Usuario deletado.");
    }
}