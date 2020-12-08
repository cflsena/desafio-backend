package br.com.desafio.backend.api.controller.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalResponse implements Serializable {

    private static final long serialVersionUID = 5514262027028063685L;

    public static ProfessionalResponse getInstance() {
        return new ProfessionalResponse();
    }

    private String name;
    private String email;
    private String cellPhone;

}
