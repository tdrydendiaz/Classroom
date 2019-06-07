package com.qa.business.service;

public interface TraineeService {
	String getAllTrainees();
	String createTrainee(String trainee);
	String deleteTrainee(int traineeID);
	String updateTrainee(int traineeID, String trainee);
}
