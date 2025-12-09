package org.math.transporte.valueobject;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EnderecoEntrega {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public String getEnderecoCompleto() {
        return String.format("%s, %s %s - %s, %s/%s - CEP: %s",
                logradouro, numero,
                complemento != null ? "(" + complemento + ")" : "",
                bairro, cidade, estado, cep);
    }
}
