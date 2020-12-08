package br.com.desafio.backend.api.entity;

import br.com.desafio.backend.api.converter.BooleanConverter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(of="id")
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor(staticName = "create")
@Entity
@Table(name = "Job", uniqueConstraints = { @UniqueConstraint(columnNames = {"category_id"}) })
public class JobEntity implements Serializable {

	private static final long serialVersionUID = -8515263941998390820L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@JoinColumn(name = "professional_id")
	@ManyToOne
	@NotNull
	private ProfessionalEntity professional;
	
	@JoinColumn(name = "category_id")
	@ManyToOne
	@NotNull
	private CategoryEntity category;
	
	@NotBlank
	@Column(name = "description")
	private String description;
	
	@NotNull
	@Convert(converter = BooleanConverter.class)
	@Column(name = "weekend_service", columnDefinition = "char", length = 1)
	private Boolean weekendService;
	
	@NotNull
	@Convert(converter = BooleanConverter.class)
	@Column(name = "active", columnDefinition = "char", length = 1)
	private Boolean active;
	
	@Column(name = "references")
	private String references;

}
