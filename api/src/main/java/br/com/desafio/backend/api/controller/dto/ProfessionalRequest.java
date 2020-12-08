package br.com.desafio.backend.api.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor(staticName = "create")
public class ProfessionalRequest implements Serializable {

    private static final long serialVersionUID = 5676116390421714288L;

    @NotBlank
    @Schema(description = "Campo texto para o nome completo do profissional", example = "Fulano Beltrano", required = true)
    private String name;

    @NotBlank
    @Schema(description = "Campo texto para o email do profissional", example = "teste@teste.com", required = true)
    private String email;

    @NotBlank
    @Schema(description = "Campo texto (porém, apenas números) para o celular do profissional", example = "12345678910", required = true)
    private String cellPhone;
}
