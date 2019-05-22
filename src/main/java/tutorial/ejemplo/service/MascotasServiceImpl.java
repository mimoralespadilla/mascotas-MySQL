package tutorial.ejemplo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tutorial.ejemplo.entity.CategoriaEntity;
import tutorial.ejemplo.entity.MascotasEntity;
import tutorial.ejemplo.model.Categoria;
import tutorial.ejemplo.model.Mascotas;
import tutorial.ejemplo.reposity.MascotasRepositorio;

/**
 * Implementación de los servicios que va a utulizar el back para manipular
 * infornación
 * 
 * @author m.morales.padilla
 *
 */
@Service
public class MascotasServiceImpl implements MascotasService {
	@Autowired
	private MascotasRepositorio service;

	public Mascotas getMascotaByName(String name) {
		Optional<MascotasEntity> mascotasNombre =  service.findByname(name);
		Mascotas mascotas = null;
		if (mascotasNombre.isPresent()) {
			CategoriaEntity categoriaEntity = mascotasNombre.get().getEspecie();
			Categoria categoria = Categoria.builder().especie(categoriaEntity.getEspecie())
					.mezcla(categoriaEntity.getMezcla()).build();
			mascotas = Mascotas.builder().id(mascotasNombre.get().getId()).edad(mascotasNombre.get().getEdad())
					.name(mascotasNombre.get().getName()).venta(mascotasNombre.get().getVenta())
					.mezcla(mascotasNombre.get().getMezcla()).build();
			mascotas.setEspecie(categoria);
		}
		return mascotas;
	}

	public List<Mascotas> getAllMascotas() {
		Iterable<MascotasEntity> mascotasEntity = service.findAll();
		List<Mascotas> mascotasLista = new ArrayList<Mascotas>();
		Iterator<MascotasEntity> iterator = mascotasEntity.iterator();

		while (iterator.hasNext()) {
			MascotasEntity mascota = iterator.next();
			CategoriaEntity categoriaEntity = mascota.getEspecie();

			Categoria categoria = Categoria.builder().especie(categoriaEntity.getEspecie())
					.mezcla(categoriaEntity.getMezcla()).build();

			Mascotas mascotas = Mascotas.builder().id(mascota.getId()).edad(mascota.getEdad()).name(mascota.getName())
					.venta(mascota.getVenta()).mezcla(mascota.getMezcla()).build();

			mascotas.setEspecie(categoria);
			mascotasLista.add(mascotas);

		}
		return mascotasLista;
	}

	public String deleteMascota(Integer id) {
		service.deleteById(id);
		return "mascota eliminada";
	}

	public Mascotas getMascotasById(Integer id) {
		Optional<MascotasEntity> mascotasEntity = service.findById(id);
		Mascotas mascotas = null;
		if (mascotasEntity.isPresent()) {
			CategoriaEntity categoriaEntity = mascotasEntity.get().getEspecie();
			Categoria categoria = Categoria.builder().especie(categoriaEntity.getEspecie())
					.mezcla(categoriaEntity.getMezcla()).build();
			mascotas = Mascotas.builder().id(mascotasEntity.get().getId()).edad(mascotasEntity.get().getEdad())
					.name(mascotasEntity.get().getName()).venta(mascotasEntity.get().getVenta())
					.mezcla(mascotasEntity.get().getMezcla()).build();
			mascotas.setEspecie(categoria);
		}
		return mascotas;
	}

	public MascotasEntity addNewMascota(Integer id, int edad, String name, String venta) {
		MascotasEntity mascota = new MascotasEntity();
		mascota.setEdad(edad);
		mascota.setId(id);
		mascota.setName(name);
		mascota.setVenta(venta);
		service.save(mascota);
		return mascota;
	}
}
