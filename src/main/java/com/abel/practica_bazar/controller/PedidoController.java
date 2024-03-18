package com.abel.practica_bazar.controller;
import com.abel.practica_bazar.model.Pedido;
import com.abel.practica_bazar.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/pedidos")
@RestController
public class PedidoController {
    @Autowired
    PedidoService pedidoServ;

    @GetMapping("/traer")
    public List<Pedido> getPedidos(){
        return pedidoServ.getPedidos();
    }

    @GetMapping("/{id}")
    public Pedido getPedido(@PathVariable Long id){
        return pedidoServ.getPedido(id);
    }

    @PostMapping ("/agregar")
    public void savePedido(@RequestBody Pedido pedido){
        pedidoServ.saveOrEditPedido(pedido);
    }

    @PutMapping("/editar")
    public void editPedido(@RequestBody Pedido pedido){
        pedidoServ.saveOrEditPedido(pedido);
    }

    @DeleteMapping("/borrar/{id}")
    public void deletePedido(@PathVariable Long id){
        pedidoServ.deletePedido(id);
    }
}
