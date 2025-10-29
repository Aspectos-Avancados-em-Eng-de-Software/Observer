package padroescomportamentais.observer;

import java.util.Observable;

public class Produto extends Observable {

    private String nome;
    private double preco;
    private int estoque;

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void alterarPreco(double novoPreco) {
        this.preco = novoPreco;
        setChanged();
        notifyObservers();
    }

    public void adicionarEstoque(int quantidade) {
        this.estoque += quantidade;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + String.format("%.2f", preco) +
                ", estoque=" + estoque +
                '}';
    }
}

