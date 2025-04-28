package com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "trinitianos_lenguajes")
@AllArgsConstructor
@NoArgsConstructor
public class TrinitianosLenguajesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long trinitianoId;

    @ManyToOne
    @JoinColumn(name = "lenguaje_id", referencedColumnName = "id")
    private LenguajesEntity lenguajeId;

    private String nivel;



}
