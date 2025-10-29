package padroescomportamentais.observer;

import java.util.Observable;
import java.util.Observer;
import java.util.Locale;

public class Cliente implements Observer {

    private String nome;
    private String email;
    private String ultimaNotificacao;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void assinarNotificacao(Produto produto) {
        produto.addObserver(this);
    }

    @Override
    public void update(Observable produto, Object arg1) {
        Produto prod = (Produto) produto;
        this.ultimaNotificacao = "Prezado(a) " + this.nome + ", o produto " + prod.getNome() + " está agora disponível por R$ " + String.format(java.util.Locale.forLanguageTag("pt-BR"), "%.2f", prod.getPreco()) + ".";
        // System.out.println(this.ultimaNotificacao);
    }
}
