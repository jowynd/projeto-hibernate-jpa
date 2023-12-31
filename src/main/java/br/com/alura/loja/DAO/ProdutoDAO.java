package br.com.alura.loja.DAO;

import br.com.alura.loja.modelo.Produto;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDAO {
    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }
    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }
    public Produto buscaPorId(Long id) {
        return em.find(Produto.class, id);
    }
    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }
    public List<Produto> buscarPorNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }
    public List<Produto> buscarPorNomeDaCategoria(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    /*        mesma classe, porém com anotações

    public List<Produto> buscarPorNomeDaCategoria(String nome) {
        return em.createNamedQuery("Produto.produtosPorCategoria", Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }*/
    public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }
}
