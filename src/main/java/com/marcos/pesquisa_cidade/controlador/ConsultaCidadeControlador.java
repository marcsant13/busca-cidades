package com.marcos.pesquisa_cidade.controlador;

import com.marcos.pesquisa_cidade.api.ServicoAPI;
import com.marcos.pesquisa_cidade.dto.CidadeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consultar-cidade")
public class ConsultaCidadeControlador {

    private final ServicoAPI servicoAPI;

    public ConsultaCidadeControlador(ServicoAPI servicoAPI) {
        this.servicoAPI = servicoAPI;
    }

    @GetMapping("/{estado}")
    public ResponseEntity<List<CidadeDTO>> buscarCidades(@PathVariable String estado){
        var cidades = servicoAPI.buscarCidades(estado);
        return ResponseEntity.ok(cidades);
    }

    @GetMapping("/{estado}/{prefixo}")
    public ResponseEntity<List<CidadeDTO>> buscarCidadesPorPrefixo(@PathVariable String estado, @PathVariable String prefixo){
        var listaCidadesPrefixo = servicoAPI.buscarCidadesPorPrefixo(estado, prefixo);
        return ResponseEntity.ok(listaCidadesPrefixo);
    }
}
