package model;

public class Plano extends EntidadeBase {
    private static final long serialVersionUID = 1L;

    private double precoMensal;
    private int diasValidade;

    public Plano(String nome, double precoMensal, int diasValidade) {
        super(nome);
        setPrecoMensal(precoMensal);
        this.diasValidade = diasValidade;
    }

    public double getPrecoMensal() {
        return precoMensal;
    }

    public void setPrecoMensal(double precoMensal) {
        if (precoMensal < 0) {
            throw new IllegalArgumentException("Preco nao pode ser negativo.");
        }
        this.precoMensal = precoMensal;
    }

    public int getDiasValidade() {
        return diasValidade;
    }

    public double calcularValor(int meses) {
        return precoMensal * meses;
    }

    public double calcularValor(int meses, double desconto) {
        double valor = calcularValor(meses);
        return valor - (valor * desconto / 100.0);
    }

    public String renovar() {
        return "Plano renovado por " + diasValidade + " dias.";
    }

    public String renovar(int meses) {
        return "Plano renovado por " + (meses * diasValidade) + " dias.";
    }

    @Override
    public String resumo() {
        return "#" + getId() + " Plano: " + getNome() + " | R$ " + String.format("%.2f", precoMensal);
