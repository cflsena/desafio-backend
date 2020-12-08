package br.com.desafio.backend.api.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor(staticName = "create")
@Entity
@Table(name = "Professional")
public class ProfessionalEntity implements Serializable {

    private static final long serialVersionUID = -9066598081196681838L;

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
