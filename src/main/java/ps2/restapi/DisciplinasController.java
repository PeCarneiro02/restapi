package ps2.restapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DisciplinasController {

	private List<Disciplinas> disciplinas;

	public DisciplinasController() {
		this.disciplinas = new ArrayList<>();
		disciplinas.add(new Disciplinas(1, "Estrutura de Dados","ED", "SI",3));
		disciplinas.add(new Disciplinas(2, "Web mobile", "WM", "SI",2));
		disciplinas.add(new Disciplinas(3, "Fundamentos da", "FM", "Matematica",2));
	}

	@GetMapping("/api/disciplinas")
	Iterable<Disciplinas> getDisciplinas() {
		return this.disciplinas;
	}
	
	@GetMapping("/api/disciplinas/{id}")
	Optional<Disciplinas> getDisciplinas(@PathVariable long id) {
		for (Disciplinas p: disciplinas) {
			if (p.getId() == id) {
				return Optional.of(p);
			}
		}
		return Optional.empty();
	}
	
	@PostMapping("/api/disciplinas")
	Disciplinas createDisciplinas(@RequestBody Disciplinas d) {
		long maxId = 1;
		for (Disciplinas disc: disciplinas) {
			if (disc.getId() > maxId) {
				maxId = disc.getId();
			}
		}
		d.setId(maxId+1);
		disciplinas.add(d);
		return d;
	}
	
	@PutMapping("/api/discplinas/{disciplinasId}")
	Optional<Disciplinas> updateDisciplinas(@RequestBody Disciplinas disciplinasRequest, @PathVariable long disciplinasId) {
		Optional<Disciplinas> opt = this.getDisciplinas(disciplinasId);
		if (opt.isPresent()) {
			Disciplinas disciplinas = opt.get();
			disciplinas.setNome(disciplinasRequest.getNome());
			disciplinas.setSigla(disciplinasRequest.getSigla());
			disciplinas.setCurso(disciplinasRequest.getCurso());
            disciplinas.setSemestre(disciplinasRequest.getSemestre());
		}

		return opt;				
	}	
	
	@DeleteMapping(value = "/api/disciplinas/{id}")
	void deleteDisciplinas(@PathVariable long id) {
		disciplinas.removeIf(d -> d.getId() == id);
	}		
}


