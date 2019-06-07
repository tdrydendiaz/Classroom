package com.qa.MapTests;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Classroom;

import com.qa.persistence.repository.ClassroomMapRepository;
import com.qa.util.JSONUtil;

public class ClassroomServiceTest {
	
	private ClassroomMapRepository cmr;
	private Classroom class1 = new Classroom(1, "Matt", "Tan");
	private Classroom class2 = new Classroom(2, "Chez", "Mon");
	private Classroom class3 = new Classroom(3, "John", "Bob");
	private JSONUtil jsonUtil = new JSONUtil();
	
	@Before
	public void setup() {
		cmr = new ClassroomMapRepository();
	}
	
	@Test
	public void getAllClassroomsTest() {

		assertEquals("{}", cmr.getAllClassroom());
	}
	
	@Test
	public void getAllClassroomsTest2() {
		cmr.getClassroomMap().put(1, class1);
		assertEquals("{\"1\":{\"classroomID\":1,\"trainer\":\"Matt\",\"trainees\":\"Tan\"}}",
				cmr.getAllClassroom()); 
	}
	
	@Test
	public void addClassroomTest() {
		String classToCreate = jsonUtil.getJSONForObject(class1);
		System.out.println(classToCreate);
		assertEquals(cmr.createClassroom(classToCreate), "Classroom successfuly created");
		assertEquals(cmr.getClassroomMap().size(), 1);
}
	
	@Test
	public void updateAccountTest() {

		cmr.getClassroomMap().put(1, class1);
		cmr.updateClassroom(1, "{\"classroomID\":\"1\",\"trainer\":\"Matt\",\"trainees\":\"Meg\"}");
		assertEquals("Meg", cmr.getClassroomMap().get(1).getTrainees());
	}
	
	@Test
	public void removeClassroomTest() {

		cmr.getClassroomMap().put(1, class1);
		cmr.deleteClassroom(1);
		assertEquals(false, cmr.getClassroomMap().containsKey(1));

	}
	
}


