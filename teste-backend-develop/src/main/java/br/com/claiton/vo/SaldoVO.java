package br.com.claiton.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaldoVO {
    private BigDecimal disponivel = new BigDecimal(0);
    private BigDecimal receber = new BigDecimal(0);
}
