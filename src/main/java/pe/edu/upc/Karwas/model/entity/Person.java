package pe.edu.upc.Karwas.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@Column(name="name", length=20, nullable=false)
	private String name;
	
	@Column(name="lastName", length=30, nullable=false)
	private String lastName;
	
	@Column(name = "dni", length = 8, nullable = false)
	private String dni;
	
	@Column(name = "numberPhone", length = 9, nullable = false)
	private Long numberPhone;
	
	@Column(name="district", length=20, nullable=false)
	private String district;
	
	@Column(name="address", length=40, nullable=false)
	private String address;
	
	@OneToOne(mappedBy = "person")
	private User user;
}
