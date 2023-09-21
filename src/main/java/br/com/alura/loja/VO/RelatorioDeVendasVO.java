package br.com.alura.loja.VO;

import java.time.LocalDate;

public class RelatorioDeVendasVO {
    private String nomeProduto;
    private Long quantidadeVendida;
    private LocalDate data;

    @Override
    public String toString() {
        return "RelatorioDeVendasVO{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", quantidadeVendida=" + quantidadeVendida +
                ", data=" + data +
                '}';
    }

    public RelatorioDeVendasVO(String nomeProduto, Long quantidadeVendida, LocalDate data) {
        this.nomeProduto = nomeProduto;
        this.quantidadeVendida = quantidadeVendida;
        this.data = data;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Long getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public LocalDate getData() {
        return data;
    }
}
