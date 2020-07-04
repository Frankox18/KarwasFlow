package pe.edu.upc.Karwas.model.entity;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "announcements")
@Getter
@Setter
public class Announcement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tittle", length = 30, nullable = false)
	private String title;
	
	@Column(name = "description", length = 500, nullable = false)
	private String description;
	
	@Column(name = "announcement_date", length = 30, nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date announcementDate;
	
	@OneToMany(mappedBy = "announcement")
	private List<Washed> service;
	
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "branchOffice_id")
	private BranchOffice branchOffice;
	
    public Announcement(){
			service = new ArrayList<>();
		}
}
