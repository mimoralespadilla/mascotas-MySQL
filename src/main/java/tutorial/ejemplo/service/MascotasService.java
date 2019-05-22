package tutorial.ejemplo.service;

import java.util.List;

import tutorial.ejemplo.entity.MascotasEntity;
import tutorial.ejemplo.model.Mascotas;

/**
 * Interfaz de los servicios de mascotas
 * 
 * @author m.morales.padilla
 *
 */
public interface MascotasService {

	Mascotas getMascotaByName(String name);

	List<Mascotas> getAllMascotas();

	String deleteMascota(Integer id);

	MascotasEntity addNewMascota(Integer id, int edad, String name, String venta);

	Mascotas getMascotasById(Integer id);
}
