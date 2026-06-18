package controller;

import model.BancoDados;
import model.Plano;
import model.Usuario;
import view.PlanoView;

public class PlanoController {
    private final BancoDados banco;
    private final PlanoView view;

    public PlanoController(BancoDados banco, PlanoView view) {
        this.banco = banco;
        this.view = view;
    }

    public void listarPlanos() {
        for (Plano plano : banco.getPlanos()) {
            view.mostrarPlano(plano);
        }
    }

    public void renovarPlano() {
        Usuario usuario = buscarUsuario();
        int meses = view.lerMeses();
        double desconto = view.lerDesconto();
        Plano plano = usuario.getPlano();
        double valor = desconto > 0 ? plano.calcularValor(meses, desconto) : plano.calcularValor(meses);
        banco.registrarHistorico(usuario.getEmail(), "Renovacao do plano " + plano.getNome());
        view.mostrarRenovacao(plano.renovar(meses), valor);
    }

    public void mudarPlano() {
        Usuario usuario = buscarUsuario();
        listarPlanos();
        String nomePlano = view.lerNovoPlano();
        Plano novoPlano = banco.buscarPlanoPorNome(nomePlano);
        usuario.mudarPlano(novoPlano);
        banco.alterar(usuario);
        banco.registrarHistorico(usuario.getEmail(), "Mudanca para o plano " + novoPlano.getNome());
        view.mostrarPlanoAlterado();
    }

    private Usuario buscarUsuario() {
        String email = view.lerEmailUsuario();
        Usuario usuario = banco.buscarUsuarioPorEmail(email);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario nao encontrado.");
        }
        return usuario;
    }
}