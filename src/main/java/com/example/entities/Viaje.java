package com.example.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Viaje implements Serializable{
    
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "El nombre del destino no puede estar vacío")
    @Size(min = 3, max = 25, message = "El nombre tiene que tener entre 3 y 25 caracteres")
    private String nombreDestino;

    @Size(max = 255, message = "La descripción no puede superar los 255 caracteres")
    private String descripcion;

    @Min(value = 2, message = "El viaje tiene que tener al menos 2 pasajeros")
    private int plazasClaseTurista;

    @Min(value = 2, message = "El viaje tiene que tener al menos 2 pasajeros")
    private int plazasBussiness;

    @Min(value = 2, message = "El viaje tiene que tener al menos 2 pasajeros")
    private int plazasTotales;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaPartida;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaLlegada;

    @Min(value = 0, message = "El precio no puede ser negativo")
    private double precio;

    private boolean reportaje;
    private boolean disfraces;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @NotNull(message = "Todos los viajes tienen que pertenecer a una categoría")
    private int idCategoria;

}
