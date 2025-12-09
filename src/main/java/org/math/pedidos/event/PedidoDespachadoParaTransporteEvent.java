package org.math.pedidos.event;

import lombok.Getter;

import java.time.Instant;

@Getter
public class PedidoDespachadoParaTransporteEvent {

    private final String pedidoId;
    private final String clienteId;
    private final EnderecoDestinatario enderecoDestinatario;
    private final Instant occurredOn;

    public PedidoDespachadoParaTransporteEvent(String pedidoId, String clienteId,
                                                EnderecoDestinatario enderecoDestinatario) {
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.enderecoDestinatario = enderecoDestinatario;
        this.occurredOn = Instant.now();
    }

    @Getter
    public static class EnderecoDestinatario {
        private final String logradouro;
        private final String numero;
        private final String complemento;
        private final String bairro;
        private final String cidade;
        private final String estado;
        private final String cep;

        public EnderecoDestinatario(String logradouro, String numero, String complemento,
                                    String bairro, String cidade, String estado, String cep) {
            this.logradouro = logradouro;
            this.numero = numero;
            this.complemento = complemento;
            this.bairro = bairro;
            this.cidade = cidade;
            this.estado = estado;
            this.cep = cep;
        }

    }
}
