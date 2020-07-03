package pe.edu.upc.Karwas.model.entity;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "branchOffices")
@Getter
@Setter
public class BranchOffice {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@NotBlank(message = "Ingrese el distrito del local")
	@Column(name = "district", length = 15, nullable = false)
    private String district;
    
	@NotBlank(message = "Ingrese la dirección del local")
	@Column(name = "address", length = 30, nullable = false)
    private String address;
	
	@NotNull(message = "Por favor, ingrese la compañia a la que pertenece el local")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Company company;

	@NotEmpty(message = "Ingrese los anuncios que pertenecen al local")
	@OneToMany(mappedBy="branchOffice", fetch = FetchType.LAZY)
    private List<Announcement> announcements;

	@NotEmpty(message = "Ingrese los usuarios que pertenecen al local")
	@OneToMany(mappedBy = "branchOffice", fetch = FetchType.LAZY)
	private List<UserBranchoffice> userBranchOffices;
	
	public BranchOffice() {
		announcements = new ArrayList<>();
		userBranchOffices = new ArrayList<>();
	}
	
}
