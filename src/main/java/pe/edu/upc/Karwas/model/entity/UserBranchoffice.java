package pe.edu.upc.Karwas.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users_branchoffices")
@Getter
@Setter
public class UserBranchoffice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Ingrese user")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user; 
	
	@NotNull(message = "Ingrese el local")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "branch_office_id")
	private BranchOffice branchOffice;
	
	@NotBlank(message = "Ingrese turno de trabajo")
	@Column(name = "work_shift", length = 40, nullable = false)
	private String workShift;
	
	@Min(value = 0, message = "El valor minimo de tiempo es 0")
	@Max(value = 24, message = "El valor maximo de tiempo es 0")
	@Column(name = "start_hour",length = 2,nullable = false)
	private int startHour;
	
	@Min(value = 0, message = "El valor minimo de tiempo es 0")
	@Max(value = 24, message = "El valor maximo de tiempo es 0")
	@Column(name = "end_hour", length = 2 ,nullable = false)
	private int endHour;
}
