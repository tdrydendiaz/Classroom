package com.qa.business.service;

public interface ClassroomService {

	String getAllClassrooms();
	String createClassroom(String classroom);
	String deleteClassroom(int classroomID);
	String updateClassroom(int classroomID, String classroom);
}
