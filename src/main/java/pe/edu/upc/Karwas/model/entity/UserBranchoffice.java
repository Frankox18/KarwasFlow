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
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user; 
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "branch_office_id")
	private BranchOffice branchOffice;
	
	@Column(name = "work_shift", length = 40, nullable = false)
	private String workShift;
	
	@Column(name = "start_hour",length = 2,nullable = false)
	private int startHour;
	
	@Column(name = "end_hour", length = 2 ,nullable = false)
	private int endHour;
}
