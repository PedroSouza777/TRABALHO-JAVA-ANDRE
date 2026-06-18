package controller;

import model.BancoDados;
import model.Plano;
import model.Usuario;
import view.PagamentoView;

public class PagamentoController {
    private final BancoDados banco;
    private final PagamentoView view;

    public PagamentoController(BancoDados banco, PagamentoView view) {
        this.banco = banco;
        this.view = view;
    }

    public void simularPagamento() {
        String email = view.lerEmailUsuario();
        Usuario usuario = banco.buscarUsuarioPorEmail(email);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario nao encontrado.");
        }
        Plano plano = usuario.getPlano();
        int meses = view.lerMesesPagos();
        double valor = plano.calcularValor(meses);
        banco.registrarHistorico(email, "Pagamento simulado de R$ " + String.format("%.2f", valor));
        view.mostrarPagamentoAprovado(usuario, valor);
    }
}