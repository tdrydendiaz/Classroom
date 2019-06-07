package com.qa.persistence.repository;

public interface ClassroomRepository {

	String getAllClassroom();
	String createClassroom(String classroom);
	String deleteClassroom(int classroomID);
	String updateClassroom(int ClassroomID, String classroom);
}
