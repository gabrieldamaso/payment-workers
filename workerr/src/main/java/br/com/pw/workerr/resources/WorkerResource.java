package br.com.pw.workerr.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pw.workerr.entities.Worker;
import br.com.pw.workerr.repository.WorkerRepository;

@RestController
@RequestMapping("/workers")
public class WorkerResource {
	
	
	private final WorkerRepository workerRepository;

	
	public WorkerResource(final WorkerRepository workerRepository) {
		this.workerRepository = workerRepository;
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> finAll(){
		
		List<Worker> list = workerRepository.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "{id}" )
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		Worker worker = workerRepository.findById(id).get();
		return ResponseEntity.ok(worker);
	}
	
	
}
