package br.com.pw.workerr.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pw.workerr.entities.Worker;
import br.com.pw.workerr.repository.WorkerRepository;

@RestController
@RefreshScope
@RequestMapping("/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private Environment env;
	
	private final WorkerRepository workerRepository;

	
	public WorkerResource(final WorkerRepository workerRepository) {
		this.workerRepository = workerRepository;
	}
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs(){
		
		logger.info("MY CONF TEST CALL " + testConfig);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> finAll(){
		
		List<Worker> list = workerRepository.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}" )
	public ResponseEntity<Worker> findById(@PathVariable Long id) throws InterruptedException{
				
		logger.info("WORKERR PORT= " + env.getProperty("local.server.port"));
		
		Worker worker = workerRepository.findById(id).get();
		return ResponseEntity.ok(worker);
	}
	
	
}
