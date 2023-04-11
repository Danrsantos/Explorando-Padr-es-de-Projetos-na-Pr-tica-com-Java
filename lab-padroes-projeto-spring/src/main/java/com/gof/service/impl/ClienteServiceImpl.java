package com.gof.service.impl;

import com.gof.model.Cliente;
import com.gof.model.ClienteRepository;
import com.gof.model.Endereco;
import com.gof.model.EnderecoRepository;
import com.gof.service.ClienteService;
import com.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Override
    public Iterable<Cliente> buscarTodos() {

        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {

        return clienteRepository.findById(id).get();
    }

    @Override
    public void inserir(Cliente cliente) {
        //Verificar se o endereço do cliente já existe atraves do CEP
        cadrastroClienteSave(cliente);
    }

    private void cadrastroClienteSave(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
        //Caso não exista, integrar com Viacep e perisitir o retorno
            Endereco novoEndereco = viaCepService.consultaCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        //Inserir cliente, vinculando o endereço (novo ou existente))
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        //Buscar cliente por id, caso exista
        Optional<Cliente> cliente1 = clienteRepository.findById(id);
        if (cliente1.isPresent()) {
            //verificar se o endereco do cliente já existe (pelo CEP)
            //caso não exista, integrar com o Viacep e persistir o retorno
            //Alterar cliente, vinculando o endereco (novo ou existente)
            cadrastroClienteSave(cliente);
        } else {
            System.out.println("O cliente buscado não existe");
        }


    }

    @Override
    public void deletar(Long id) {
        //Deletar cliente por id
        clienteRepository.deleteById(id);
    }
}
