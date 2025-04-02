package com.service3it.mscv_trinitianos.infraestructure.adapters.in.rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrinitianosDTO {

    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 1, max = 50, message = "El apellido debe tener entre 1 y 50 caracteres")
    private String apellido;

    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Email(message = "El correo electrónico no es válido")
    @Size(min = 1, max = 50, message = "El correo electrónico debe tener entre 1 y 50 caracteres")
    @Pattern(regexp = "^[^@\\s]+@[^@\\s]+$", message = "El correo electrónico debe contener un '@' y no puede tener espacios")
    private String correoElectronico;

    @NotBlank(message = "El RUT no puede estar vacío")
    @Size(min = 9, max = 10, message = "El RUT debe tener entre 9 y 10 caracteres")
    @Pattern(regexp = "^[0-9]{7,8}-[0-9kK]$", message = "El RUT debe tener el formato '12345678-9' o '12345678-K'")
    private String rut;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "^\\+[0-9]{11}$", message = "El número de teléfono debe tener el formato '+12345678901' con 11 dígitos")
    private String telefono;

    @NotBlank(message = "El estado no puede estar vacío")
    @Pattern(regexp = "^(Activo|Inactivo|En Proceso)$", message = "El estado debe ser 'Activo', 'Inactivo' o 'En Proceso'")
    private String estado;


    @NotBlank(message = "El enlace de Bizneo no puede estar vacío")
    @Size(min = 1, max = 50, message = "El enlace de Bizneo debe tener entre 1 y 50 caracteres")
    private String enlaceBizneo;

    @NotBlank(message = "El enlace de Hubspot no puede estar vacío")
    @Size(min = 1, max = 50, message = "El enlace de Hubspot debe tener entre 1 y 50 caracteres")
    private String enlaceHubspot;

    @NotBlank(message = "El enlace de Jira no puede estar vacío")
    @Size(min = 1, max = 50, message = "El enlace de Jira debe tener entre 1 y 50 caracteres")
    private String enlaceJira;

}
