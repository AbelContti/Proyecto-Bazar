package com.abel.practica_bazar.controller;
import com.abel.practica_bazar.model.Cliente;
import com.abel.practica_bazar.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/clientes")
@RestController
public class ClienteController {
    @Autowired
    ClienteService clienteServ;

    @GetMapping("/traer")
    public List<Cliente> getClientes(){
        return clienteServ.getClientes();
    }

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable Long id){
        return clienteServ.getCliente(id);
    }

    @PostMapping("/agregar")
    public void saveCliente(@RequestBody Cliente cliente){
        clienteServ.saveOrEditCliente(cliente);
    }

    @PutMapping("/editar")
    public void editCliente(@RequestBody Cliente cliente){
        clienteServ.saveOrEditCliente(cliente);
    }

    @DeleteMapping("/borrar/{id}")
    public void deleteCliente(@PathVariable Long id){
        clienteServ.deleteCliente(id);
    }
}
