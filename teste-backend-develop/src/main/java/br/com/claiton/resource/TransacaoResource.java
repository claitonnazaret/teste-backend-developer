package br.com.claiton.resource;

import br.com.claiton.domain.Transacao;
import br.com.claiton.service.TransacaoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transacao")
public class TransacaoResource {

    private final TransacaoService service;

    public TransacaoResource(TransacaoService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Transacao>> listAll(Pageable pageable) {
        return ResponseEntity.ok(service.listAll(pageable));
    }
}
