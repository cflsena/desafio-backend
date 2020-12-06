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

import br.com.desafio.backend.api.converter.BooleanConverter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of="id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Job", uniqueConstraints = { @UniqueConstraint(columnNames = {"cateogry_id"}) })
public class JobEntity implements Serializable {

	private static final long serialVersionUID = -8515263941998390820L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@JoinColumn(name = "id")
	@ManyToOne
	@NotNull
	private ProfessionalEntity professional;
	
	@JoinColumn(name = "id")
	@ManyToOne
	@NotNull
	private CategoryEntity category;
	
	@NotBlank
	@Column(name = "description")
	private String description;
	
	@NotBlank
	@Column(name = "weekend_service")
	private String weekendService;
	
	@NotNull
	@Convert(converter = BooleanConverter.class)
	@Column(name = "active", columnDefinition = "char", length = 1)
	private Boolean active;
	
	@Column(name = "references")
	private String references;

}
