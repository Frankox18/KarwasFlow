package pe.edu.upc.Karwas.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Getter
@Setter
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Ingrese la placa del auto")
	@Column(name = "license", length = 6, nullable = false)
	private String license;
	
	@NotBlank(message = "Ingrese la marca del auto")
	@Column(name = "brand", length = 30, nullable = false)
	private String brand;
	
	@NotBlank(message = "Ingrese el modelo del auto")
	@Column(name = "model", length = 30, nullable = false)
	private String model;

	@NotBlank(message = "Ingrese el color del auto")
	@Column(name = "color", length = 15, nullable = false)
	private String color;
	
	@NotNull(message = "Ingrese al usuario")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@NotEmpty(message = "Ingrese los detalles del lavado")
	@OneToMany(mappedBy = "car")
	private List<Registry> washedsDetails;
	
	public Car() {
		washedsDetails = new ArrayList<>();
	}
}
