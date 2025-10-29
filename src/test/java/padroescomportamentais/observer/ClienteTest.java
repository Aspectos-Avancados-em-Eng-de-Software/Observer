package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveNotificarUmClienteAoAlterarPreco() {
        Produto produto = new Produto("Smartphone X", 1500.00, 10);
        Cliente cliente = new Cliente("João Silva", "joao.silva@email.com");
        cliente.assinarNotificacao(produto);

        produto.alterarPreco(1299.99);

        assertEquals("Prezado(a) João Silva, o produto Smartphone X está agora disponível por R$ 1299,99.", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientesAoAlterarEstoque() {
        Produto produto = new Produto("Fone Bluetooth", 250.00, 0);
        Cliente cliente1 = new Cliente("Maria Souza", "maria.souza@email.com");
        Cliente cliente2 = new Cliente("Pedro Alves", "pedro.alves@email.com");

        cliente1.assinarNotificacao(produto);
        cliente2.assinarNotificacao(produto);

        produto.adicionarEstoque(5);

        assertEquals("Prezado(a) Maria Souza, o produto Fone Bluetooth está agora disponível por R$ 250,00.", cliente1.getUltimaNotificacao());
        assertEquals("Prezado(a) Pedro Alves, o produto Fone Bluetooth está agora disponível por R$ 250,00.", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarClienteSemAssinatura() {
        Produto produto = new Produto("Smartwatch", 500.00, 20);
        Cliente cliente = new Cliente("Ana Costa", "ana.costa@email.com");

        produto.alterarPreco(450.00);

        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteApenasParaProdutoAssinado() {
        Produto produtoA = new Produto("Teclado Mecânico", 300.00, 5);
        Produto produtoB = new Produto("Mouse Gamer", 150.00, 10);
        Cliente cliente1 = new Cliente("Lucas Lima", "lucas.lima@email.com");
        Cliente cliente2 = new Cliente("Carla Dias", "carla.dias@email.com");

        cliente1.assinarNotificacao(produtoA);
        cliente2.assinarNotificacao(produtoB);

        produtoA.alterarPreco(280.00);

        assertEquals("Prezado(a) Lucas Lima, o produto Teclado Mecânico está agora disponível por R$ 280,00.", cliente1.getUltimaNotificacao());
        assertNull(cliente2.getUltimaNotificacao());

        produtoB.adicionarEstoque(1);

        assertEquals("Prezado(a) Lucas Lima, o produto Teclado Mecânico está agora disponível por R$ 280,00.", cliente1.getUltimaNotificacao());
        assertEquals("Prezado(a) Carla Dias, o produto Mouse Gamer está agora disponível por R$ 150,00.", cliente2.getUltimaNotificacao());
    }
}
