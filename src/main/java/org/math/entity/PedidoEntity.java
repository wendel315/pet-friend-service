package org.math.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {
    @Id
    private String pedidoId;
    private String clienteId;
    private String petId;
    private String descricao;
    private Double valor;
    private Instant criadoEm;

    public PedidoEntity() {
    }

    public PedidoEntity(String pedidoId, String clienteId, String petId, String descricao, Double valor, Instant criadoEm) {
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.petId = petId;
        this.descricao = descricao;
        this.valor = valor;
        this.criadoEm = criadoEm;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
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

    public Instant getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Instant criadoEm) {
        this.criadoEm = criadoEm;
    }
}

