package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.TraineeRepository;

public class TraineeServicelmpl implements TraineeService {
	
	@Inject
	private TraineeRepository repo;
	

	@Override
	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

	@Override
	public String createTrainee(String trainee) {
		return repo.createTrainee(trainee);
	}

	@Override
	public String deleteTrainee(int traineeID) {
	return repo.deleteTrainee(traineeID);
	}

	@Override
	public String updateTrainee(int traineeID, String trainee) {
		return repo.updateTrainee(traineeID, trainee);
	}
	
	

}
