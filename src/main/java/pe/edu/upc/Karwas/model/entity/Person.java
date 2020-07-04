package pe.edu.upc.Karwas.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "people")
@Getter
@Setter
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Ingrese el nombre")
	@Column(name="name", length=20, nullable=false)
	private String name;
	
	@NotBlank(message = "Ingrese el apellido")
	@Column(name="lastName", length=30, nullable=false)
	private String lastName;
	
	@NotBlank(message = "Ingrese el dni")
	@Size(max=8,message = "El dni no debe tener más de 8 digitos")
	@Column(name = "dni", length = 8, nullable = false)
	private String dni;
	
	@Min(value = 9, message = "El valor ingresado debe tener 9 digitos")
	@Column(name = "numberPhone", nullable = false)
	private Long numberPhone;
	
	@NotBlank(message = "Ingrese el distrito")
	@Column(name="district", length=20, nullable=false)
	private String district;
	
	@NotBlank(message = "Ingrese la direccion")
	@Column(name="address", length=40, nullable=false)
	private String address;
	
	@OneToOne(mappedBy = "person")
	private User user;
}
