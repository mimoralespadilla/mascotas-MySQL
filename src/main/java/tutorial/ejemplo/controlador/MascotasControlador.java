package tutorial.ejemplo.controlador;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tutorial.ejemplo.entity.MascotasEntity;
import tutorial.ejemplo.model.Categoria;
import tutorial.ejemplo.model.Mascotas;
import tutorial.ejemplo.service.CategoriaService;
import tutorial.ejemplo.service.MascotasService;

/**
 * Clase que controla las salida de datos de los fi
 * 
 * @author m.morales.padilla
 *
 */
@RestController
@RequestMapping("/mascotas")
public class MascotasControlador {

	@Autowired
	private MascotasService service;

	@Autowired
	private CategoriaService serviceCategoria;

	/**
	 * 
	 * @return Devuelve todas las mascotas de la base de datos
	 */

	@GetMapping(path = "/mascotas")
	public @ResponseBody List<Mascotas> getAllMascotas() {
		return service.getAllMascotas();
	}

	/**
	 * 
	 * @param id Sirve para localizar a la mascota.
	 * @return Devuelve una las características de la mascota que se ha seleccionado
	 *         por su id
	 */
	@GetMapping(path = "/id/{id}")
	public @ResponseBody Mascotas getMascotasById(@PathVariable("id") Integer id) {
		return service.getMascotasById(id);

	}

	/**
	 * 
	 * @param name Nombre de la mascota a localizar
	 * @return Una mascota por el nombre
	 */
	@GetMapping(path = "/name/{name}")
	public @ResponseBody Mascotas getMascotaByName(@PathVariable("name") String name) {
		return service.getMascotaByName(name);
	}

	/**
	 * 
	 * @param especie Nombre de la especie con la que se van a agrupar las mascotas
	 * @return Devuelve las mascotas que tiene esa especie
	 */
	@GetMapping(path = "/especie/{especie}")
	public @ResponseBody Categoria getMascotasByEspecie(@PathVariable("especie") String especie) {
		return serviceCategoria.getMascotasByEspecie(especie);
	}
	/**
	 * 
	 * @param id      Nueva id de la mascota ha crear
	 * @param edad    Nueva edad de la mascota ha crear
	 * @param especie Añadimos la especie a la que pertenece la mascota ha crear
	 * @param name    Nombre de la mascota ha crear
	 * @param venta   Indicación de si la mascota esta a la venta o no
	 * @return devuelve un string que confirma que la mascota se ha creado
	 */

	@GetMapping(path = "/add/") // Map ONLY GET Requests
	@Transactional
	public @ResponseBody MascotasEntity addNewMascota(@RequestParam Integer id, @RequestParam int edad,
			@RequestParam String name, @RequestParam String venta) {
		return service.addNewMascota(id, edad, name, venta);
	}

	/**
	 * 
	 * @param id Id de la mascota que se va a borrar
	 * @return Devuelve un string confirmando de que la mascota se ha borrado
	 */
	@GetMapping(path = "/borrar/")
	public @ResponseBody String deleteMascota(@RequestParam int id) {
		return service.deleteMascota(id);

	}
}