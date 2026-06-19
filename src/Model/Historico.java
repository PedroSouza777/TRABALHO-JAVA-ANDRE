package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Historico extends EntidadeBase {
    private static final long serialVersionUID = 1L;

    private String usuarioEmail;
    private String acao;
    private LocalDateTime data;

    public Historico(String usuarioEmail, String acao) {
        super("Historico");
        this.usuarioEmail = usuarioEmail;
        this.acao = acao;
        this.data = LocalDateTime.now();
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public String getAcao() {
        return acao;
    }

    @Override
    public String resumo() {
        String dataFormatada = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        return "#" + getId() + " " + dataFormatada + " | " + usuarioEmail + " | " + acao;
    }
}