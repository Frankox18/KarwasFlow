package pe.edu.upc.Karwas.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "companys")
@Getter
@Setter
public class Company {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@NotBlank(message = "Ingrese el nombre de la compañia")
	@Column(name = "name", length = 30, nullable = false)
    private String name;
    
	@Max(11)
	@Min(11)
	@Column(name = "ruc", length = 11, nullable = false)
    private Long ruc;
   
	@NotEmpty(message = "Ingrese los locales de la compañia")
	@Size(min = 1, message = "La compañia debe tener 1 local como mínimo")
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<BranchOffice> branchOffice;

	public Company() {
		branchOffice = new ArrayList<>();
	}
    
}
