package com.gabriel.van.service;

import java.util.List;
import java.util.Optional;

import com.gabriel.van.exceptions.ClienteNaoEncontradoException;
import org.springframework.stereotype.Service;

import com.gabriel.van.dto.ClienteDTO;
import com.gabriel.van.dto.ClienteResponseDTO;
import com.gabriel.van.exceptions.EmailJaExistenteExceptions;
import com.gabriel.van.model.Cliente;
import com.gabriel.van.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public ClienteResponseDTO cadastrarCliente(ClienteDTO dto) {
        // ajustar para validar se email ja existe no banco para nao poder cadastar

        if (emailJaExiste(dto.getEmail())){

        }
        Cliente cliente = new Cliente();

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(dto.getSenha());

        Cliente salvo = repository.save(cliente);

        return new ClienteResponseDTO(
                salvo.getId(),
                salvo.getNome(),
                salvo.getEmail());
    };

    public boolean emailJaExiste(String email) {
        // retorna true se o email ja existe no banco
        boolean existe = repository.findByEmail(email).isPresent();
        if (existe){
            throw new EmailJaExistenteExceptions();
        }
        return existe;
    };

    public ClienteResponseDTO pesquisarClientePorId(Long id) {
        Optional<Cliente> clientePesquisa = repository.findById(id);
        // ajuste
        // falta trocar a Exceptions, criar uma para um cliente nao existente
        if (clientePesquisa.isEmpty()) {
            throw new ClienteNaoEncontradoException();
        }
        Cliente cliente = clientePesquisa.get();    
        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail());            
    };

    public void deletarCLientePorId(Long id) {
        repository.deleteById(id);
    };

    public Cliente atualizarCliente(Long id, Cliente dadosClienteNovo) {
        Cliente clienteNovo = repository.findById(id)
                .orElseThrow();
        // Atualiza os dados do cliente encontrado
        // usando os dados recebidos na requisição.
        clienteNovo.setEmail(dadosClienteNovo.getEmail());
        clienteNovo.setNome(dadosClienteNovo.getNome());
        clienteNovo.setSenha(dadosClienteNovo.getSenha());

        // Como o objeto possui um ID que já existe no banco,
        // o save() fará um UPDATE e não um INSERT.
        return repository.save(clienteNovo);
    };

    public List<Cliente> retornarTodosCliente() {
        return repository.findAll();
    };

}
