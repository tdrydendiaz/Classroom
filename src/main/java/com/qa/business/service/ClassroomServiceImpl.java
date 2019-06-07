package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.ClassroomRepository;

public class ClassroomServiceImpl implements ClassroomService {
	
	@Inject
	private ClassroomRepository repo;


	@Override
	public String getAllClassrooms() {
		return repo.getAllClassroom();
		}

	@Override
	public String createClassroom(String classroom) {
	return repo.createClassroom(classroom);
		
	}

	@Override
	public String deleteClassroom(int classroomID) {
		return repo.deleteClassroom(classroomID);
	
	}

	@Override
	public String updateClassroom(int classroomID, String classroom) {
	return repo.updateClassroom(classroomID, classroom);
	}

}
