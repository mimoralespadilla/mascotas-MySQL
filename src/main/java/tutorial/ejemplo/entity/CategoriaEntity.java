package tutorial.ejemplo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = "mascotas")
/**
 * Representación de los difrentes tipos de mascotas
 * una categoria puede tener varias mascotas
 * @author m.morales.padilla
 *
 */
@Entity
@Table(name = "categoria")
public class CategoriaEntity {
	@Id
	private String especie;

	private String mezcla;

	@OneToMany(mappedBy = "especie", fetch = FetchType.LAZY)
	private List<MascotasEntity> mascotas;
}
