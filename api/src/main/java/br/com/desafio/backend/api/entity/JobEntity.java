package br.com.desafio.backend.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.desafio.backend.api.controller.dto.JobRequest;
import br.com.desafio.backend.api.converter.BooleanConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of="id")
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor(staticName = "create")
@Entity
@Table(name = "Job", uniqueConstraints = { @UniqueConstraint(columnNames = {"category_id"}) })
@Builder
public class JobEntity implements Serializable {

	private static final long serialVersionUID = -8515263941998390820L;
	
	public static JobEntity from(JobRequest request) {
		return builder()
			.professional(request.getProfessional())
			.category(request.getCategory())
			.description(request.getDescription())
			.weekendService(request.getWeekendService())
			.active(request.getActive())
			.references(request.getReferences())
		.build();
	}
	
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
