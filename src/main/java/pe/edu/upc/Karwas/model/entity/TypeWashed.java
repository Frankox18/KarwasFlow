package pe.edu.upc.Karwas.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "type_washeds")
@Getter
@Setter
public class TypeWashed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Ingrese el nombre del servicio")
	@Column(name = "service_name", length = 30, nullable = false)
    private String serviceName;
	
	@NotEmpty(message = "Ingrese los lavados")
	@OneToMany(mappedBy = "typewashed")
	private List<Washed> washeds;
	
	public TypeWashed() {
		washeds = new ArrayList<>();
	}
}
