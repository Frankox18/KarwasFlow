package pe.edu.upc.Karwas.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Ingrese el metodo de pago ")
	@Column(name = "method", length = 30, nullable = false)
	private String method;

	@Min(16)
	@Max(16)
	@Column(name = "number_card", length = 16, nullable = false)
	private Long numberCard;
	
	@Future(message = "La fecha debe ser futura")
	@Column(name = "date_exp", length = 30, nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateExp;
	
	@Min(3)
	@Max(3)
	@Column(name = "cvv", length = 3, nullable = false)
	private int cvv;

	@NotEmpty(message = "Ingrese el detalle del lavado")
	@OneToMany(mappedBy = "payment")
	private List<Registry> servicesDetails;

	public Payment() {
		servicesDetails = new ArrayList<>();
	}
}
