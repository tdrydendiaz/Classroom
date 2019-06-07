package com.qa.persistence.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository {

	@Inject
	private JSONUtil util; 
	
	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	@Override
	public String getAllTrainees() {
		Query query = manager.createQuery("SELECT a FROM Trainee a ORDER BY traineeID");

		Collection<Trainee> trainee = (Collection<Trainee>) query.getResultList();

		return util.getJSONForObject(trainee);
	}

	@Transactional(TxType.REQUIRED)
	@Override
	public String createTrainee(String trainee) {
		new JSONUtil();
		Trainee util = JSONUtil.getObjectForJSON(trainee, Trainee.class);
		manager.persist(util);
		return "{\"message\": \"Trainee sucessfully added\"}";
	}

	@Transactional(TxType.REQUIRED)
	@Override
	public String deleteTrainee(int traineeID) {
		Trainee trainee= manager.find(Trainee.class, traineeID);
	    manager.remove(trainee);
			return "{\"message\": \"Trainee sucessfully deleted\"}";
	}

	@Override
	public String updateTrainee(int traineeID, String trainee) {
		return null;
	}

	
	

}
