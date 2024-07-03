package src.main.java.org.generation.joyaDelCaribe.controllers;


@RestController
@RequestMapping(path = "/api/orden/")
public class OrdenController {
	private final OrdenService ordenService;
	
	@Autowired
	public OrdenController(OrdenService ordenService) {
		this.ordenService = ordenService;
	}//Autowired
	
	@GetMApping
	public ArrayList<Orden> getOrdenes(){
		return ordenService.getAllOrdenes();
	}
	
	@GetMapping(path = "{ordenId}")
	public Orden getOrden(@PathVariable("ordenId") int id) {
		return ordenService.getOrden(id);
	}
	
	@DeleteMapping(path ="{ordenId}")
	public Orden deleteOrden(@PathVariable("ordenId")int id) {
		return ordenService.deleteOrden(id);
	}
	
	
}//class OrdenController
