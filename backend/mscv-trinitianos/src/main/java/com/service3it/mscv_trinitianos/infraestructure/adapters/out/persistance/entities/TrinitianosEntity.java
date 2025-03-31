package com.service3it.mscv_trinitianos.infraestructure.adapters.out.persistance.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.FractionalSeconds;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name = "trinitianos")
@AllArgsConstructor
@NoArgsConstructor
public class TrinitianosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "apellido", length = 50)
    private String apellido;

    @Column(name = "email", length = 50, unique = true)
    private String correoElectronico;

    @Column(name = "telefono", length = 50)
    private String telefono;

    @Column(name = "estado", length = 50)
    private String estado;

    @Column(name = "enlace_bizneo", length = 50)
    private String enlaceBizneo;

    @Column(name = "enlace_hubspot", length = 50)
    private String enlaceHubspot;

    @Column(name = "enlace_jira", length = 50)
    private String enlaceJira;

    @CreationTimestamp
    @FractionalSeconds(value = 0)
    @Column(name = "fecha_creacion", updatable = false, nullable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @FractionalSeconds(value = 0)
    @Column(name = "fecha_modificacion", nullable = false)
    private LocalDateTime fechaModificacion;

}
