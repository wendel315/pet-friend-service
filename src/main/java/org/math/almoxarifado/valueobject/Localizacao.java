package org.math.almoxarifado.valueobject;

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
public class Localizacao {

    private String corredor;
    private String prateleira;
    private String posicao;

    public String getEnderecoCompleto() {
        return String.format("%s-%s-%s", corredor, prateleira, posicao);
    }
}
