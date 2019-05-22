package tutorial.ejemplo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tutorial.ejemplo.entity.CategoriaEntity;
import tutorial.ejemplo.entity.MascotasEntity;
import tutorial.ejemplo.model.Categoria;
import tutorial.ejemplo.model.Mascotas;
import tutorial.ejemplo.reposity.CategoriaRepositorio;

/**
 * Implementación del servicio de categoria.
 * 
 * @author m.morales.padilla
 *
 */
@Service
public class CategoriasServiceImple implements CategoriaService {
	ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private CategoriaRepositorio servicio;

	/**
	 * @param especie Indica la especie de las mascotas que se buscan
	 * @return Devuelve las macotas de la misma especie
	 */
	public Categoria getMascotasByEspecie(String especie) {
		CategoriaEntity categoriaEntity = servicio.findById(especie).orElse(null);
		Categoria categoria = null;
		if (categoriaEntity != null) {
			categoria = Categoria.builder().especie(categoriaEntity.getEspecie()).mezcla(categoriaEntity.getMezcla())
					.build();
			if (categoriaEntity.getMascotas() != null) {
				for (MascotasEntity entity : categoriaEntity.getMascotas()) {
					Mascotas temp = Mascotas.builder().edad(entity.getEdad()).id(entity.getId()).name(entity.getName())
							.mezcla(entity.getMezcla()).venta(entity.getVenta()).build();
					categoria.setMascotas(temp);
				}
			}
		}
		return categoria;
	}
}
