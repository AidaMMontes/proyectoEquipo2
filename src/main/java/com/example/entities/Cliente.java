package com.example.entities;
/*Cliente: (@ManyToOne(Un cliente puede viajar a 1 ó muchos destinos)
-          ID (int)
-          Nombre (String)
-          Apellidos (String)
-          DNI escaneado
-          Fecha de Salida (Local Date)
-          Fecha de Regreso (Local Date) 
-          Teléfono (String)
-          Email (String)
-          Destino */

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
// @Getter
// @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellidos;
    private String imagenDni;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaSalida;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegreso;
    private String telefono;
    private String email;

    @ManyToOne
    @NotNull
    private Viaje viaje;

}
