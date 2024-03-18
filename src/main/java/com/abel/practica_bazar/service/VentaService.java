package com.abel.practica_bazar.service;
import com.abel.practica_bazar.dto.MontoVentasFecha;
import com.abel.practica_bazar.dto.VentaClienteDto;
import com.abel.practica_bazar.model.Producto;
import com.abel.practica_bazar.model.Venta;
import com.abel.practica_bazar.model.Pedido;
import com.abel.practica_bazar.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService {
    @Autowired
    VentaRepository ventaRepo;

    @Autowired
    PedidoService pedidoServ;

    @Autowired
    ProductoService productoServ;

    public List<Venta> getVentas(){
        return ventaRepo.findAll();
    }

    public Venta getVenta(Long id){
        return ventaRepo.findById(id).orElse(null);
    }

    public void saveVenta(Venta venta){
        double monto = 0;
        List<Pedido> pedidos = venta.getPedidos();

        for(Pedido p : pedidos){
            Pedido pedido_actual = pedidoServ.getPedido(p.getId_pedido());

            pedido_actual.restar_stock_prod();
            productoServ.saveOrEdit(pedido_actual.getProducto());

            monto += pedido_actual.calcular_monto();
        }

        venta.setMonto(monto);
        ventaRepo.save(venta);
    }

    public void editVenta(Venta venta){
        ventaRepo.save(venta);
    }

    public MontoVentasFecha getMontoVentasFecha(LocalDate fecha){
        List<Venta> trans_fecha = ventaRepo.findByFecha(fecha);
        MontoVentasFecha aux = new MontoVentasFecha();
        aux.setFecha(fecha);

        if(trans_fecha != null){
            for(Venta t : trans_fecha){
                aux.setPedidos(aux.getPedidos() + t.getPedidos().size());
                aux.setMonto_final(aux.getMonto_final() + t.getMonto());
            }
        }

        return aux;
    }

    public VentaClienteDto getMaxMonto(){
        Venta max_trans = ventaRepo.findFirstByOrderByMontoDesc();
        List<Producto> productos = new ArrayList<>();

        for(Pedido v : max_trans.getPedidos()){
            productos.add(v.getProducto());
        }

        return new VentaClienteDto(max_trans.getCliente().getNombre(), max_trans.getCliente().getApellido(),
                max_trans.getId_venta(), max_trans.getMonto(), productos);
    }

    public void deleteVenta(Long id){
        ventaRepo.deleteById(id);
    }
}
