package org.math.command;

public class CriarPedidoCommand extends BaseCommand {
    private final String clienteId;
    private final String petId;
    private final String descricao;
    private final Double valor;

    public CriarPedidoCommand(String pedidoId, String clienteId, String petId, String descricao, Double valor) {
        super(pedidoId);
        this.clienteId = clienteId;
        this.petId = petId;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getPetId() {
        return petId;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }
}

