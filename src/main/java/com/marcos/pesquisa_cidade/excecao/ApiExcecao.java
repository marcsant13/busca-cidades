package com.marcos.pesquisa_cidade.excecao;

public class ApiExcecao extends RuntimeException{
    public ApiExcecao(String mensagem){
        super(mensagem);
    }
}


