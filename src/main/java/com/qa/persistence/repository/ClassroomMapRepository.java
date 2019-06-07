package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

@Alternative
public class ClassroomMapRepository implements ClassroomRepository {

	Map<Integer, Classroom> classroomMap = new HashMap<Integer, Classroom>();
	
	
	@Override
	public String getAllClassroom() {
		return new JSONUtil().getJSONForObject(classroomMap);
		
	} 

	@Override
	public String createClassroom(String classroom) {
		new JSONUtil();
		Classroom newClassroom = JSONUtil.getObjectForJSON(classroom, Classroom.class);
		classroomMap.put(newClassroom.getClassroomID(), newClassroom);
		return "Classroom successfuly created";
	}

	@Override
	public String deleteClassroom(int classroomID) {
		classroomMap.remove((Integer)classroomID);
		return "Classroom successfully removed";
	}

	

	@Override
	public String updateClassroom(int ClassroomID, String classroom) {
		new JSONUtil();
		Classroom classToUpdate = JSONUtil.getObjectForJSON(classroom, Classroom.class);
		classroomMap.put(ClassroomID, classToUpdate);
		return "Classroom successfully updated";
	}

	public void setClassroomMap(Map<Integer, Classroom> classroomMap) {
		this.classroomMap = classroomMap;
	}
	
	public Map<Integer, Classroom> getClassroomMap() {
		return classroomMap;
	}

public int findTrainer(String String) {
		
		int count = 0;
		for (Classroom aClassroom : classroomMap.values()) {
			if (aClassroom.getTrainer().equals(String)) {
				System.out.println(count++); 
			}
		} 
		 return count;
}

}

