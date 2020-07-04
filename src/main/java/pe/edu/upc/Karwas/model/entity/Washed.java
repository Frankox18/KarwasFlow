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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	
	@NotNull(message = "Ingrese el tipo de lavado")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "type_washed_id")
	private TypeWashed typewashed;
	
	@NotBlank(message = "Ingrese la descripcion")
	@Column(name="description", length = 40, nullable = false)
	private String description;
	
	@Min(value = 0, message = "El valor minimo de tiempo es 0")
	@Max(value = 24, message = "El valor maximo de tiempo es 24")
	@Column(name="wash_time", length = 10, nullable = false)
	private int washTime;
	
	@Column(name="total_amount", length = 40, nullable = false)
	private int totalAmount;
	
	@NotNull(message = "Ingrese el anuncio")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "announcement_id")
	private Announcement announcement;
	
	@OneToMany(mappedBy = "washed")
	private List<Registry> washedsDetails;
	
	public Washed() {
		washedsDetails = new ArrayList<>();
	}
	
	
}
