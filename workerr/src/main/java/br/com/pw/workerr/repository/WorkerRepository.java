package br.com.pw.workerr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pw.workerr.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
	
	
}
