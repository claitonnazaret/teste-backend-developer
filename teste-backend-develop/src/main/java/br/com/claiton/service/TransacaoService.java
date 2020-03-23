package br.com.claiton.service;

import br.com.claiton.domain.Transacao;
import br.com.claiton.repository.TransacaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransacaoService  {

    private final BigDecimal TAXA_DEBITO = new BigDecimal(2);
    private final BigDecimal TAXA_CREDITO = new BigDecimal(3);
    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public Transacao realizaTransacao(Transacao transacao) {
        return repository.save(transacao);
    }

    public Page<Transacao> listAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
