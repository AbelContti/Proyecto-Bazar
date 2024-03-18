package com.abel.practica_bazar.service;
import com.abel.practica_bazar.model.Cliente;
import com.abel.practica_bazar.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService{
    @Autowired
    ClienteRepository clienteRepo;

    public List<Cliente> getClientes(){
        return clienteRepo.findAll();
    }

    public Cliente getCliente(Long id){
        return  clienteRepo.findById(id).orElse(null);
    }

    public void saveOrEditCliente(Cliente cliente){
        clienteRepo.save(cliente);
    }

    public void deleteCliente(Long id){
        clienteRepo.deleteById(id);
    }
}
