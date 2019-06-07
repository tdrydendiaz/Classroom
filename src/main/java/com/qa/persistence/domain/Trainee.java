package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int traineeID;
	@Column (length = 20)
	private String traineeName;
	@Column (length = 20)
	private int age;
	
	public Trainee(int traineeID, String traineeName, int age) {
		super();
		this.traineeID = traineeID;
		this.traineeName = traineeName;
		this.age = age;
	}
	
	public int getTraineeID() {
		return traineeID;
	}
	public void setTraineeID(int traineeID) {
		this.traineeID = traineeID;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
