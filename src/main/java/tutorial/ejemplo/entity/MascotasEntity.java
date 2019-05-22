package tutorial.ejemplo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
/**
 * Representa una mascota en la base de datos varias mascotas pueden estar en
 * una categoria
 * 
 * @author m.morales.padilla
 *
 */
@Entity
@Table(name = "mascotas")
public class MascotasEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "especie")
	private CategoriaEntity especie;

	private String name;

	private int edad;

	private String mezcla;

	private String venta;

}
