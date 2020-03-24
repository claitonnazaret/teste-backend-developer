package br.com.claiton.resource;

import br.com.claiton.domain.Transacao;
import br.com.claiton.service.TransacaoService;
import br.com.claiton.vo.SaldoVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransacaoResource {

    private final TransacaoService service;

    public TransacaoResource(TransacaoService service) {
        this.service = service;
    }

    @PostMapping(path = "/terminal", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Transacao> realizaTransacao(@RequestBody Transacao transacao) {
        return ResponseEntity.ok(service.realizaTransacao(transacao));
    }

    @GetMapping("/portal/list")
    public ResponseEntity<List<Transacao>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/portal/saldo")
    public ResponseEntity<SaldoVO> listSaldo() {
        return ResponseEntity.ok(service.listSaldo());
    }
}
