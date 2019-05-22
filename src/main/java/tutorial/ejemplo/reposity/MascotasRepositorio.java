package tutorial.ejemplo.reposity;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tutorial.ejemplo.entity.MascotasEntity;

@Repository
public interface MascotasRepositorio extends CrudRepository<MascotasEntity, Integer> {
	Optional<MascotasEntity> findByname(String name);

	Iterable<MascotasEntity> findByEspecie(String especie);

	Iterable<MascotasEntity> findByMezcla(String mezcla);

	Iterable<MascotasEntity> findByEspecieAndMezcla(String especie, String mezcla);
}
