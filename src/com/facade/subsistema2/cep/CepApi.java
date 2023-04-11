package com.facade.subsistema2.cep;

import com.gof.SingletonEager;

public class CepApi {
    private static CepApi instancia = new CepApi();

    private CepApi(){
        super();
    }
    public static CepApi getInstancia() {
        return instancia;
    }

    public String recuperarCidade(String cep){
        return "São paulo";
    }

    public String recuperarEstado(String cep){
        return "SP";
    }
}
