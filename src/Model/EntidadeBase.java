package model;

import java.io.Serializable;

public abstract class EntidadeBase implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;

    protected EntidadeBase(String nome) {
        setNome(nome);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id nao pode ser negativo.");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome e obrigatorio.");
        }
        this.nome = nome.trim();
    }

    public abstract String resumo();

    @Override
    public String toString() {
        return resumo();
    }
}