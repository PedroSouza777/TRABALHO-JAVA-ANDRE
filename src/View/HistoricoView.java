package view;

import model.Historico;

public class HistoricoView extends ConsoleView {
    public void mostrarHistorico(Historico historico) {
        mostrar(historico.resumo());
    }
}