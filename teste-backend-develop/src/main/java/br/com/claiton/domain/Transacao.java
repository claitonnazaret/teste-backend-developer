package br.com.claiton.domain;

import br.com.claiton.enuns.BandeiraEnum;
import br.com.claiton.enuns.ModalidadeEnum;
import br.com.claiton.utils.LocalDateTimeDeserializer;
import br.com.claiton.utils.LocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Negative;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Transacao extends SuperEntity {

    private String nsu;

    @PositiveOrZero(message = "O Valor não pode ser negativo")
    private BigDecimal valor;

    private BigDecimal liquido;

    @Enumerated(EnumType.STRING)
    private BandeiraEnum bandeira;

    @Enumerated(EnumType.STRING)
    private ModalidadeEnum modalidade;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime horario;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date disponivel;

}
