package br.com.alura.loja;

import br.com.alura.loja.DAO.CategoriaDAO;
import br.com.alura.loja.DAO.ClienteDAO;
import br.com.alura.loja.DAO.PedidoDAO;
import br.com.alura.loja.DAO.ProdutoDAO;
import br.com.alura.loja.VO.RelatorioDeVendasVO;
import br.com.alura.loja.modelo.*;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDePedido {
    public static void main(String[] args) {
        popularBancoDeDados();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);

        Produto produto = produtoDAO.buscaPorId(1l);
        Cliente cliente = clienteDAO.buscaPorId(1l);

        Produto produto2 = produtoDAO.buscaPorId(2l);

        Produto produto3 = produtoDAO.buscaPorId(3l);

        em.getTransaction().begin();
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarPedido(new ItemPedido(10,pedido, produto));


        Pedido pedido2 = new Pedido(cliente);
        pedido2.adicionarPedido(new ItemPedido(7,pedido, produto2));

        Pedido pedido3 = new Pedido(cliente);
        pedido3.adicionarPedido(new ItemPedido(12,pedido, produto3));


        PedidoDAO pedidoDAO = new PedidoDAO(em);
        pedidoDAO.cadastrar(pedido);
        pedidoDAO.cadastrar(pedido2);
        pedidoDAO.cadastrar(pedido3);

        em.getTransaction().commit();

        BigDecimal totalVendido = pedidoDAO.valorTotalVendido();
        System.out.println("VALOR TOTAL: " + totalVendido);
        List<RelatorioDeVendasVO> relatorio = pedidoDAO.relatorioDeVendas();
        relatorio.forEach(System.out::println);
    }

    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria computadores = new Categoria("COMPUTADORES");
        Categoria alimentos = new Categoria("ALIMENTOS");

        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );
        Produto notebook = new Produto("Notebook", "Preciso comprar outro", new BigDecimal("7000"), computadores );
        Produto banana = new Produto("Banana", "Saborosa", new BigDecimal("15000"), alimentos );

        Cliente cliente = new Cliente("hiwi", "123456789");

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDao = new ProdutoDAO(em);
        CategoriaDAO categoriaDao = new CategoriaDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        clienteDAO.cadastrar(cliente);

        categoriaDao.cadastrar(computadores);
        produtoDao.cadastrar(notebook);
        clienteDAO.cadastrar(cliente);

        categoriaDao.cadastrar(alimentos);
        produtoDao.cadastrar(banana);
        clienteDAO.cadastrar(cliente);

        em.getTransaction().commit();
        em.close();
    }
}
