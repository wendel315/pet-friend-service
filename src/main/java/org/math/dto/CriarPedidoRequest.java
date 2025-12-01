package org.math.dto;

public class CriarPedidoRequest {
    private String clienteId;
    private String petId;
    private String descricao;
    private Double valor;

    public CriarPedidoRequest() {
    }

    public CriarPedidoRequest(String clienteId, String petId, String descricao, Double valor) {
        this.clienteId = clienteId;
        this.petId = petId;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}

