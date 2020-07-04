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
    
	@Column(name = "district", length = 15, nullable = false)
    private String district;
    
	@Column(name = "address", length = 30, nullable = false)
    private String address;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id")
	private Company company;

	@OneToMany(mappedBy="branchOffice", fetch = FetchType.LAZY)
    private List<Announcement> announcements;

	@OneToMany(mappedBy = "branchOffice", fetch = FetchType.LAZY)
	private List<UserBranchoffice> userBranchOffices;
	
	public BranchOffice() {
		announcements = new ArrayList<>();
		userBranchOffices = new ArrayList<>();
	}
	
}
