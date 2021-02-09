package br.com.pw.payment.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.pw.payment.entities.Payment;
import br.com.pw.payment.entities.Worker;

@Service
public class PaymentService {
	
	@Value("${workerr.host}")
	private String workerrHost;
	
	private final RestTemplate restTemplate;
	
	public PaymentService(final RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		
		uriVariables.put("id", ""+workerId);
		
		Worker worker = restTemplate.getForObject(workerrHost + "/workers/{id}", Worker.class, uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days );
	}
}
