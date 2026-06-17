package Model;

import Model.EntidadeBase;

public class Usuario extends EntidadeBase {
    private static final long serialVersionUID = 1L;

    private String email;
    private String senha;
    private Plano plano;

    public Usuario(String nome, String email, String senha, Plano plano) {
        super(nome);
        setEmail(email);
        setSenha(senha);
        this.plano = plano;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null  !email.contains("@")) {
            throw new IllegalArgumentException("Email invalido.");
        }
        this.email = email.trim().toLowerCase();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha == null  senha.length() < 4) {
            throw new IllegalArgumentException("Senha deve ter ao menos 4 caracteres.");
        }
        this.senha = senha;
    }

    public Plano getPlano() {
        return plano;
    }

    public void mudarPlano(Plano novoPlano) {
        if (novoPlano == null) {
            throw new IllegalArgumentException("Plano nao encontrado.");
        }
        this.plano = novoPlano;
    }

    @Override
    public String resumo() {
        String nomePlano = plano == null ? "Sem plano" : plano.getNome();
        return "#" + getId() + " Usuario: " + getNome() + " | " + email + " | Plano: " + nomePlano;
    }
}
