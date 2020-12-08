package br.com.desafio.backend.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.desafio.backend.api.controller.dto.ProfessionalRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor(staticName = "create")
@Entity
@Table(name = "Professional")
@Builder
public class ProfessionalEntity implements Serializable {

    private static final long serialVersionUID = -9066598081196681838L;

    public static ProfessionalEntity from(final ProfessionalRequest entity) {
    	return builder()
    			.name(entity.getName())
    			.email(entity.getEmail())
    			.cellPhone(entity.getCellPhone())
    		.build();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank
    @Column(name = "cell_phone", unique = true)
    @Size(min = 10, max = 11)
    private String cellPhone;

}
