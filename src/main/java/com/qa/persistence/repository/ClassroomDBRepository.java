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
import com.qa.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class ClassroomDBRepository  implements ClassroomRepository {
	
	@Inject
	private JSONUtil util;
	
	@PersistenceContext(unitName="primary")
	private EntityManager manager;

	@Override
	public String getAllClassroom() {
		Query query = manager.createQuery("SELECT a FROM Classroom a ORDER BY classroomID");

		Collection<Classroom> classroom = (Collection<Classroom>) query.getResultList();

		return util.getJSONForObject(classroom);
	}

	@Transactional(TxType.REQUIRED)
	@Override
	public String createClassroom(String classroom) {
		new JSONUtil();
		Classroom util = JSONUtil.getObjectForJSON(classroom, Classroom.class);
		manager.persist(util);
		return "{\"message\": \"classroom sucessfully added\"}";
	}
	
	@Transactional(TxType.REQUIRED)
	@Override
	public String deleteClassroom(int classroomID) {
		Classroom classroom= manager.find(Classroom.class, classroomID);
	    manager.remove(classroom);
			return "{\"message\": \"Classroom sucessfully deleted\"}";
	}
	@Transactional(TxType.REQUIRED)
	@Override
	public String updateClassroom(int ClassroomID, String classroom) {
		return null;
	}

}
