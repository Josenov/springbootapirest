package com.application.rest.controllers.dto;

import com.application.rest.advice.annotation.ValidName;
import com.application.rest.entities.Producto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;


import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class FabricanteDTO {


    private Long id;
    @ValidName
    private String nombre;
    @Valid
    private List<Producto> productoList = new ArrayList<>();

}
