package br.com.pw.payment.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.pw.payment.entities.Worker;


@Component
@FeignClient(name ="workerr", url = "localhost:8001", path = "/workers" )
public interface WorkerrFeignClient {
	
	@GetMapping(value = "{id}" )
	public ResponseEntity<Worker> findById(@PathVariable Long id);

}
