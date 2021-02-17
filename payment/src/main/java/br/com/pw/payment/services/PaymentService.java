package br.com.pw.payment.services;

import org.springframework.stereotype.Service;

import br.com.pw.payment.entities.Payment;
import br.com.pw.payment.entities.Worker;
import br.com.pw.payment.feignclients.WorkerrFeignClient;

@Service
public class PaymentService {

	private final WorkerrFeignClient workerrFeignClient;

	public PaymentService(final WorkerrFeignClient workerrFeignClient) {
		this.workerrFeignClient = workerrFeignClient;
	}

	public Payment getPayment(long workerId, int days) {

		Worker worker = workerrFeignClient.findById(workerId).getBody();

		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
