package br.com.desafio.backend.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobStatusRequest implements Serializable {
    private static final long serialVersionUID = 4901565620249501533L;

    @NotNull
    private Boolean active;

}
