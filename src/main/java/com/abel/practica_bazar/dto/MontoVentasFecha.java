package com.abel.practica_bazar.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class MontoVentasFecha {
    private LocalDate fecha;
    private double monto_final;
    private int pedidos;
}
