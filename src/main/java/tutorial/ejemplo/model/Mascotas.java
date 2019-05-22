package tutorial.ejemplo.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Builder
/**
 * Representa una mascota en la base de datos varias mascotas pueden estar en
 * una categoria
 * 
 * @author m.morales.padilla
 *
 */
public class Mascotas {
	private Integer id;

	private Categoria especie;

	private String name;

	private int edad;

	private String mezcla;

	private String venta;

}
