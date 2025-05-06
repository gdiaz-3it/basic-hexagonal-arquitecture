package com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.out.persistance.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tritianos_lenguajes")
@AllArgsConstructor
@NoArgsConstructor
public class TritianosLenguajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nivel")
    private String nivel;

    @Column(name = "lenguaje")
    private String lenguaje;

    @Column(name = "cliente_id")
    private Long clienteId;



}
