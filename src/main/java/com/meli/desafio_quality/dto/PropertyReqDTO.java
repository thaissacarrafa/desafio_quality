package com.meli.desafio_quality.dto;

import java.math.BigDecimal;
import javax.validation.constraints.*;
import lombok.*;

@Data
public class PropertyReqDTO {

    @NotBlank(message = "O nome da propriedade não pode estar vazio.")
    @NotNull(message = "O nome da propriedade não pode ser nulo.")
    @Pattern(
        regexp = "^[A-Z].*",
        message = "O nome da propriedade deve começar com uma letra maiúscula."
    )
    @Size(
        max = 30,
        message = "O nome da propriedade não pode ter mais de 30 caracteres."
    )
    private String propName;

    @NotBlank(message = "O nome do bairro não pode ser vazio.")
    @NotNull(message = "O nome do bairro não pode ser vazio.")
    @Size(
        max = 45,
        message = "O nome do bairro não pode ter mais de 45 caracteres."
    )
    private String propDistrict;

    @NotBlank(
        message = "O valor do metro quadrado no bairro não pode ser vazio."
    )
    @NotNull(message = "O valor do metro quadrado no bairro não pode ser nulo.")
    @Size(
        max = 13,
        message = "O valor do metro quadrado no bairro não pode ter mais de 13 caracteres."
    )
    private BigDecimal valueDistrictM2;

    @NotBlank(message = "O nome do cômodo não pode ser vazio.")
    @NotNull(message = "O nome do bairro não pode ser vazio.")
    @Pattern(
        regexp = "^[A-Z].*",
        message = "O nome do cômodo deve começar com uma letra maiúscula."
    )
    @Size(
        max = 30,
        message = "O nome do cômodo não pode ter mais de 30 caracteres."
    )
    private String roomName;

    @NotBlank(message = "A largura do cômodo não pode estar vazia.")
    @Size(max = 25, message = "A largura máxima do cômodo é de 25 metros.")
    private double roomWidth;

    @NotBlank(message = "O comprimento do cômodo não pode estar vazio.")
    @Size(max = 33, message = "O comprimento máximo do cômodo é de 33 metros.")
    private double roomLength;
}
