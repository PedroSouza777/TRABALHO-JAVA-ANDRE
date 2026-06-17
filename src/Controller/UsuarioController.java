package Controller;

import model.BancoDados;
import model.Plano;
import model.Usuario;
import view.UsuarioView;

public class UsuarioController {
    private final BancoDados banco;
    private final UsuarioView view;

    public UsuarioController(BancoDados banco, UsuarioView view) {
        this.banco = banco;
        this.view = view;
    }

    public void cadastrarUsuario() {
        String nome = view.lerNome();
        String email = view.lerEmailCadastro();
        String senha = view.lerSenha();
        Plano plano = banco.buscarPlanoPorNome("Free");
        Usuario usuario = new Usuario(nome, email, senha, plano);
        banco.cadastrar(usuario);
        banco.registrarHistorico(email, "Cadastro de usuario");
        view.mostrarCadastrado();
    }

    public void listarUsuarios() {
        for (Usuario usuario : banco.getUsuarios()) {
            view.mostrarUsuario(usuario);
        }
    }

    public void alterarUsuario() {
        Usuario usuario = buscarPorEmail();
        String novoNome = view.lerNovoNome();
        String novaSenha = view.lerNovaSenha();
        usuario.setNome(novoNome);
        usuario.setSenha(novaSenha);
        banco.alterar(usuario);
        banco.registrarHistorico(usuario.getEmail(), "Alteracao de cadastro");
        view.mostrarAlterado();
    }

    public void deletarUsuario() {
        Usuario usuario = buscarPorEmail();
        if (banco.deletar(usuario.getId(), Usuario.class)) {
            banco.registrarHistorico(usuario.getEmail(), "Usuario removido");
            view.mostrarDeletado();
        }
    }

    private Usuario buscarPorEmail() {
        String email = view.lerEmail();
        Usuario usuario = banco.buscarUsuarioPorEmail(email);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario nao encontrado.");
        }
        return usuario;
    }
}