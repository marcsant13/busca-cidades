package com.marcos.pesquisa_cidade.api;

import com.marcos.pesquisa_cidade.dto.CidadeDTO;
import com.marcos.pesquisa_cidade.excecao.ApiExcecao;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoAPI {

    private final ConfRestTemplate confRestTemplate;

    public ServicoAPI(ConfRestTemplate confRestTemplate) {
        this.confRestTemplate = confRestTemplate;
    }

    public List<CidadeDTO> buscarCidades(String estado){
        String url = "https://brasilapi.com.br/api/ibge/municipios/v1/" + estado;

        try {
            CidadeDTO[] cidadeDTO = confRestTemplate.restTemplate().getForObject(url, CidadeDTO[].class);
            if (cidadeDTO != null){
                return Arrays.asList(cidadeDTO);
            } else {
                return Collections.emptyList();
            }
        } catch (RestClientException e) {
            throw new ApiExcecao("Erro ao conectar: " + e.getMessage());
        }
    }

    public List<CidadeDTO> buscarCidadesPorPrefixo(String estado, String prefixo){
        var listaCidades = buscarCidades(estado);

        List<CidadeDTO> listaCidadesPrefixo = listaCidades
                .stream()
                .filter(cidade -> cidade.getNome().startsWith(prefixo))
                .collect(Collectors.toList());

        return listaCidadesPrefixo;
    }
}
