package com.service3it.mscv_trinitianos.infraestructure.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "trinitianos")
@AllArgsConstructor
public class TrinitianosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "apellido", length = 50)
    private String apellido;

    @Column(name = "email", length = 50, unique = true)
    private String correo_electronico;

    @Column(name = "telefono", length = 50)
    private String telefono;

    @Column(name = "estado", length = 50)
    private String estado;

    @Column(name = "enlace_bizneo", length = 50)
    private String enlace_bizneo;

    @Column(name = "enlace_hubspot", length = 50)
    private String enlace_hubspot;

    @Column(name = "enlace_jira", length = 50)
    private String enlace_jira;

    @CreationTimestamp
    @Column(name = "fecha_creacion")
    private LocalDateTime fecha_creacion;

    public TrinitianosEntity() {
    }

    public static TrinitianosEntity fromDomainModel(Trinitianos trinitianos) {
        return new TrinitianosEntity(trinitianos.getId(), trinitianos.getNombre(), trinitianos.getApellido(),
                trinitianos.getCorreo_electronico(), trinitianos.getTelefono(), trinitianos.getEstado(),
                trinitianos.getEnlace_bizneo(), trinitianos.getEnlace_hubspot(), trinitianos.getEnlace_jira(), trinitianos.getFecha_creacion());
    }

    public Trinitianos toDomainModel() {
        return new Trinitianos(id, nombre, apellido, correo_electronico, telefono, estado, enlace_bizneo, enlace_hubspot,
                enlace_jira, fecha_creacion);
    }

}
