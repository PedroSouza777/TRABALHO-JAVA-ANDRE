package controller;

import model.BancoDados;
import model.Historico;
import view.HistoricoView;

public class HistoricoController {
    private final BancoDados banco;
    private final HistoricoView view;

    public HistoricoController(BancoDados banco, HistoricoView view) {
        this.banco = banco;
        this.view = view;
    }

    public void listarHistorico() {
        for (Historico historico : banco.getHistoricos()) {
            view.mostrarHistorico(historico);
        }
    }
}