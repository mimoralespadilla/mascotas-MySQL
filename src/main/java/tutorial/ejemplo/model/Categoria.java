package tutorial.ejemplo.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(exclude = "mascotas")
/**
 * Representación de los difrentes tipos de mascotas una categoria puede tener
 * varias mascotas
 * 
 * @author m.morales.padilla
 *
 */
public class Categoria {
	private String especie;

	private String mezcla;

	private Mascotas mascotas;
}
