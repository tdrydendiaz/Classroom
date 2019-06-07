package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Alternative
public class TraineeMapRepository implements TraineeRepository {

	Map<Integer, Trainee> traineeMap = new HashMap<Integer, Trainee>();
	@Override
	public String getAllTrainees() {
		return new JSONUtil().getJSONForObject(traineeMap); 
	}


	@Override
	public String createTrainee(String trainee) {
		new JSONUtil();
		Trainee newTrainee = JSONUtil.getObjectForJSON(trainee, Trainee.class);
		traineeMap.put(newTrainee.getTraineeID(), newTrainee);
		return "Trainee successfuly created";
	}

	@Override
	public String deleteTrainee(int traineeID) {
		traineeMap.remove((Integer)traineeID);
		return "Trainee successfully removed";
	}

	@Override
	public String updateTrainee(int traineeID, String trainee) {
		new JSONUtil();
		Trainee traineeToUpdate = JSONUtil.getObjectForJSON(trainee, Trainee.class);
		traineeMap.put(traineeID, traineeToUpdate);
		return "Trainee successfully updated";
	}

	public void setTraineeMap(Map<Integer, Trainee> TraineeMap) {
		this.traineeMap = TraineeMap;
	}
	
	public Map<Integer, Trainee> getTraineeMap() {
		return traineeMap;
	}
}
