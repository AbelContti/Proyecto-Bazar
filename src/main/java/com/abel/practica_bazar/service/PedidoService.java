package com.abel.practica_bazar.service;
import com.abel.practica_bazar.model.Pedido;
import com.abel.practica_bazar.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepo;

    public void saveOrEditPedido(Pedido pedido){
        pedidoRepo.save(pedido);
    }

    public List<Pedido> getPedidos(){
        return pedidoRepo.findAll();
    }

    public Pedido getPedido(Long id){ return  pedidoRepo.findById(id).orElse(null);}

    public void deletePedido(Long id){
        pedidoRepo.deleteById(id);
    }
}
