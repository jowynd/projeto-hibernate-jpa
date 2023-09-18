package br.com.alura.loja.modelo;

import javax.persistence.*;

@Table(name = "categorias")
@Entity
public class Categoria {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String nome;

    public Categoria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }
}
