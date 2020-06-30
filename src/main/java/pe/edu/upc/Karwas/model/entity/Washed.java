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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "washeds")
@Getter
@Setter
public class Washed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_washed_id")
	private TypeWashed typewashed;

	@Column(name="description", length = 40, nullable = false)
	private String description;
	
	@Column(name="wash_time", length = 10, nullable = false)
	private int wash_Time;
	
	@Column(name="total_amount", length = 40, nullable = false)
	private int totalAmount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "announcement_id")
	private Announcement announcement;
	
	@OneToMany(mappedBy = "washed")
	private List<Registry> washedsDetails;
	
	public Washed() {
		washedsDetails = new ArrayList<>();
	}
	
	
}
