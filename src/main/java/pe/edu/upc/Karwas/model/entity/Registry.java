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
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "records")
@Getter
@Setter
public class Registry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Ingrese el lavado")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "washed_id")
	private Washed washed;
	
	@NotNull(message = "Ingrese el auto")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "car_id")
	private Car car;
	
	@Min(value = 0, message = "El tiempo minimo es 0")
	@Max(value = 24, message = "El tiempo maximo es 24")
	@Column(name = "start_time_wash", length = 2, nullable = false)
	private int startTimeWash;
	
	@Min(value = 0, message = "El tiempo minimo es 0")
	@Max(value = 24, message = "El tiempo maximo es 24")
	@Column(name = "end_time_wash", length = 2, nullable = false)
	private int endTimeWash;
	
	@NotNull(message = "Ingrese el pago")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id")
	private Payment payment;
}
