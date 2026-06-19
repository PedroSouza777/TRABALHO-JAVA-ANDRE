package view;

import model.Usuario;

public class PagamentoView extends ConsoleView {
    public String lerEmailUsuario() {
        return lerTexto("Email do usuario: ");
    }

    public int lerMesesPagos() {
        return lerInt("Meses pagos: ");
    }

    public void mostrarPagamentoAprovado(Usuario usuario, double valor) {
        mostrar("Pagamento aprovado para " + usuario.getNome() + ": R$ " + String.format("%.2f", valor));
    }
}