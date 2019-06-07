package com.qa.persistence.repository;

public interface TraineeRepository {

	String getAllTrainees();
	String createTrainee(String trainee);
	String deleteTrainee(int traineeID);
	String updateTrainee(int traineeID, String trainee);
}
