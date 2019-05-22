package tutorial.ejemplo.reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tutorial.ejemplo.entity.CategoriaEntity;

@Repository
public interface CategoriaRepositorio extends JpaRepository<CategoriaEntity, String> {
}
