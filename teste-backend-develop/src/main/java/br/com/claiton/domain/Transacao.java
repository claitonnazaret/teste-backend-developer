package br.com.claiton.domain;

import br.com.claiton.enuns.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Transacao extends SuperEntity {

    private String nsu;

    private BigDecimal valor;

    private BigDecimal liquido;

    @Enumerated(EnumType.STRING)
    private BandeiraEnum bandeira;

    @Enumerated(EnumType.STRING)
    private ModalidadeEnum modalidade;

    private Date disponivel;

}
