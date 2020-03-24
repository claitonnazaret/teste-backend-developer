package br.com.claiton.utils;

import br.com.claiton.domain.Transacao;
import br.com.claiton.enuns.ModalidadeEnum;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public abstract class Calculator {
    private static final Double TAXA_DEBITO = 0.02D;
    private static final Double TAXA_CREDITO = 0.03D;
    private static final int DIAS_DEBITO = 1;
    private static final int DIAS_CREDITO = 30;

    public static void aplicaTaxas(Transacao transacao) {
        final BigDecimal TAXA = new BigDecimal(transacao.getModalidade()
                .equals(ModalidadeEnum.CREDITO) ? TAXA_CREDITO : TAXA_DEBITO);
        BigDecimal valorLiquido = transacao.getValor()
                .subtract(transacao.getValor().multiply(TAXA)).setScale(2, BigDecimal.ROUND_HALF_UP);
        transacao.setLiquido(valorLiquido);
    }

    public static void calculaRecebimento(Transacao transacao) {
        final int SOMA_DIAS = transacao.getModalidade()
                .equals(ModalidadeEnum.CREDITO) ? DIAS_CREDITO : DIAS_DEBITO;
        LocalDateTime dataCalculada = transacao.getHorario().plusDays(SOMA_DIAS);
        transacao.setDisponivel(verificarFinalDeSemana(dataCalculada));
    }

    private static Date verificarFinalDeSemana(LocalDateTime dataAgendada) {
        LocalDateTime dataAnalyzed = dataAgendada;
        if (dataAgendada.getDayOfWeek() == DayOfWeek.SATURDAY){
            dataAnalyzed = dataAgendada.plusDays(2);
        } else if(dataAgendada.getDayOfWeek() == DayOfWeek.SUNDAY) {
            dataAnalyzed = dataAgendada.plusDays(1);
        }
        return Date.from(dataAnalyzed.atZone(ZoneId.systemDefault()).toInstant());
    }
}
