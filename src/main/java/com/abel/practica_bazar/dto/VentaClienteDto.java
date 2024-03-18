package com.abel.practica_bazar.dto;
import com.abel.practica_bazar.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class VentaClienteDto {
    private String nombre_cliente;
    private String apellido_cliente;
    private Long id_venta;
    private double monto;
    private List<Producto> productos;
}
