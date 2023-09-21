package br.com.alura.loja.DAO;

import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.Pedido;

import javax.persistence.EntityManager;

public class ClienteDAO {
    private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }
    public void cadastrar(Cliente cliente) {
        this.em.persist(cliente);
    }
    public Cliente buscaPorId(Long id) {

        return em.find(Cliente.class, id);
    }
}