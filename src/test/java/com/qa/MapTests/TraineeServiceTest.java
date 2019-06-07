package com.qa.MapTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.ClassroomMapRepository;
import com.qa.persistence.repository.TraineeMapRepository;
import com.qa.util.JSONUtil;

public class TraineeServiceTest {


	private TraineeMapRepository tmr;
	private Trainee t1 = new Trainee(1, "Liam", 24);
	private Trainee t2 = new Trainee(1, "Robert", 21);
	private Trainee t3 = new Trainee(1, "Jane", 22);
	private JSONUtil jsonUtil = new JSONUtil(); 	
	
	@Before
	public void setup() {
		tmr = new TraineeMapRepository();
	}
	
	@Test
	public void getAllTraineesTest() {
		assertEquals("{}", tmr.getAllTrainees());
	}
	
	@Test
	public void getAllClassroomsTest2() {
		tmr.getTraineeMap().put(1, t1);
		assertEquals("{\"1\":{\"traineeID\":1,\"traineeName\":\"Liam\",\"age\":24}}",
				tmr.getAllTrainees()); 
	}
	
	@Test
	public void addTraineeTest() {
		String traineeToCreate = jsonUtil.getJSONForObject(t1);
		System.out.println(traineeToCreate);
		assertEquals(tmr.createTrainee(traineeToCreate), "Trainee successfuly created");
		assertEquals(tmr.getTraineeMap().size(), 1);
}
	
	@Test
	public void updateTraineeTest() {

		tmr.getTraineeMap().put(1, t1);
		tmr.updateTrainee(1, "{\"traineeID\":\"1\",\"traineeName\":\"Robert\",\"age\":22}");
		assertEquals("Robert", tmr.getTraineeMap().get(1).getTraineeName());
	}
	
	@Test
	public void removeTraineeTest() {

		tmr.getTraineeMap().put(1, t1);
	tmr.deleteTrainee(1);
		assertEquals(false, tmr.getTraineeMap().containsKey(1));

	}
	
}
