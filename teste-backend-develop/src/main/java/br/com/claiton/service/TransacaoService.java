package br.com.claiton.service;

import br.com.claiton.domain.Transacao;
import br.com.claiton.repository.TransacaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService  {

    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public Page<Transacao> listAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
