package com.application.rest.controllers.dto;

import com.application.rest.entities.Fabricante;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class ProductoDTO {

    private Long id;
    @NotNull(message = "El campo nombre no puede ser null, intenta nuevamente!")
    private String nombre;
    @NotNull(message = "El campo precio no puede ser null, intenta nuevamente!")
    private BigDecimal precio;
    @Valid
    private Fabricante fabricante;
}
