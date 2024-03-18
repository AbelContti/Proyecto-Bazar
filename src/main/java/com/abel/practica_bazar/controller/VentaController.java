package com.abel.practica_bazar.controller;
import com.abel.practica_bazar.dto.MontoVentasFecha;
import com.abel.practica_bazar.dto.VentaClienteDto;
import com.abel.practica_bazar.model.Venta;
import com.abel.practica_bazar.model.Pedido;
import com.abel.practica_bazar.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/ventas")
@RestController
public class VentaController {
    @Autowired
    VentaService ventaService;

    @GetMapping("/traer")
    public List<Venta> getVentas(){
        return ventaService.getVentas();
    }

    @GetMapping("/{id}")
    public Venta getVenta(@PathVariable Long id){
        return ventaService.getVenta(id);
    }

    @GetMapping("/ventas/{id}")
    public List<Pedido> getPedidos(@PathVariable Long id){
        Venta venta = ventaService.getVenta(id);
        return venta != null ? venta.getPedidos() : null;
    }

    @GetMapping("/fecha/{fecha}")
    public MontoVentasFecha getMontoVentasFecha(@PathVariable String fecha){
        return ventaService.getMontoVentasFecha(LocalDate.parse(fecha));
    }

    @GetMapping("/max_monto")
    public VentaClienteDto getMaxMonto(){
        return ventaService.getMaxMonto();
    }

    @PostMapping("/agregar")
    public void saveVenta(@RequestBody Venta venta){
        ventaService.saveVenta(venta);
    }

    @PutMapping("/editar")
    public void editVenta(@RequestBody Venta venta){
        ventaService.editVenta(venta);
    }

    @DeleteMapping("/borrar/{id}")
    public void deleteVenta(@PathVariable Long id){
        ventaService.deleteVenta(id);
    }
}
