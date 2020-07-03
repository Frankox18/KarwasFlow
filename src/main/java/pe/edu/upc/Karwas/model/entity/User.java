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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Ingrese el username")
	@Column(name = "user_name", length = 30, nullable = false)
    private String username;
	
	@NotBlank(message = "Ingrese la contraseña")
	@Column(name = "password", length = 60, nullable = false)
    private String password;
	
	private boolean enable;
	
	@NotEmpty(message = "Ingrese el rol")
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Role> roles;
	
	@NotNull() 
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Person person;
	
	@NotEmpty()
	@OneToMany(mappedBy = "user")
	private List<Car> car;
	
	@NotEmpty()
	@OneToMany(mappedBy = "user")
	private List<UserBranchoffice> userBranchoffices;
	
	public User() {
		this.enable = true;
		this.roles = new ArrayList<>();
		car = new ArrayList<>();
		userBranchoffices = new ArrayList<>();
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.enable = true;
		this.roles = new ArrayList<>();
		car = new ArrayList<>();
		userBranchoffices = new ArrayList<>();
	}
	
	public void addRoles(String rol) {
		Role role = new Role();
		role.setNameRole(rol);
		role.setUser(this);
		this.roles.add(role);
	}
}
