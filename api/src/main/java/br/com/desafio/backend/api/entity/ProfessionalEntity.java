package br.com.desafio.backend.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Professional", uniqueConstraints = { @UniqueConstraint(columnNames = { "email", "cell_phone" }) })
public class ProfessionalEntity implements Serializable {

	private static final long serialVersionUID = -9066598081196681838L;

	public static ProfessionalEntity getInstance() {
		return new ProfessionalEntity();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank
	@Column(name = "name")
	private String name;

	@NotBlank
	@Column(name = "email")
	private String email;

	@NotBlank
	@Column(name = "cell_phone")
	@Length(min = 11, max = 11)
	private String cellPhone;

}
