package com.facade.subsistema1.crm;

public class CrmService {
    private CrmService() {
        super();
    }

    public static void gravarCliente(String nomeCliente, String cep, String cidade , String estado){
        System.out.println("Cliente salvo no sistema de CRM.");
        System.out.println(nomeCliente);
        System.out.println(cep);
        System.out.println(cidade);
        System.out.println(estado);

    }
}
