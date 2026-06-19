package view;

import model.Plano;

public class PlanoView extends ConsoleView {
    public int menu() {
        mostrar("\n1 - Listar | 2 - Renovar plano | 3 - Mudar plano");
        return lerInt("Escolha: ");
    }

    public String lerEmailUsuario() {
        return lerTexto("Email do usuario: ");
    }

    public int lerMeses() {
        return lerInt("Quantidade de meses: ");
    }

    public double lerDesconto() {
        return lerDouble("Desconto em % (0 se nao tiver): ");
    }

    public String lerNovoPlano() {
        return lerTexto("Novo plano: ");
    }

    public void mostrarPlano(Plano plano) {
        mostrar(plano.resumo());
    }

    public void mostrarRenovacao(String mensagem, double valor) {
        mostrar(mensagem);
        mostrar("Valor total: R$ " + String.format("%.2f", valor));
    }

    public void mostrarPlanoAlterado() {
        mostrar("Plano alterado com sucesso.");
    }
}