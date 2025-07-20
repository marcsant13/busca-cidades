package com.marcos.pesquisa_cidade.controladorexcecao;

import com.marcos.pesquisa_cidade.excecao.ApiExcecao;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Excecao {

    @ExceptionHandler(ApiExcecao.class)
    public ResponseEntity<ErroResposta> apiExcecao(ApiExcecao e){
        ErroResposta erroResposta = new ErroResposta(HttpStatus.SERVICE_UNAVAILABLE.value(), e.getMessage());
        return new ResponseEntity<>(erroResposta, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @Data
    @AllArgsConstructor
    static class ErroResposta{
        private int status;
        private String mensagem;
    }
}
