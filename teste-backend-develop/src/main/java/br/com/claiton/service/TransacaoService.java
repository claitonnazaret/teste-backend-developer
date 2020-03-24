package br.com.claiton.service;

import br.com.claiton.domain.Transacao;
import br.com.claiton.repository.TransacaoRepository;
import br.com.claiton.utils.Calculator;
import br.com.claiton.vo.SaldoVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransacaoService  {

    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public Transacao realizaTransacao(Transacao transacao) {
        Calculator.aplicaTaxas(transacao);
        Calculator.calculaRecebimento(transacao);
        return repository.save(transacao);
    }



    public List<Transacao> listAll() {
        return repository.findAll();
    }

    public SaldoVO listSaldo() {
        SaldoVO saldo = new SaldoVO();
        repository.findAll().stream()
                .forEach(transacao -> {
                    //Saldos disponíveis
                    if(transacao.getDisponivel().before(new Date())) {
                        saldo.setDisponivel(saldo.getDisponivel().add(transacao.getLiquido()));
                    } else {
                        saldo.setReceber(saldo.getReceber().add(transacao.getLiquido()));
                    }
                });
        return saldo;
    }
}
