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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

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
    
	@Min(value = 11, message = "Un RUC debe tener como minimo 11 digitos")
	@Column(name = "ruc", length = 11, nullable = false)
    private Long ruc;
   
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<BranchOffice> branchOffice;

	public Company() {
		branchOffice = new ArrayList<>();
	}
    
}
