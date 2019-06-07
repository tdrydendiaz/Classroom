package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classroom {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int classroomID;
	@Column (length = 20)
	private String trainer;
	@Column (length = 20)
	private String trainees;
	
	public Classroom(int classroomID, String trainer, String trainees) {
		super();
		this.classroomID = classroomID;
		this.trainer = trainer;
		this.trainees = trainees;
	}
	
	public int getClassroomID() {
		return classroomID;
	}
	public void setClassroomID(int classroomID) {
		this.classroomID = classroomID;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public String getTrainees() {
		return trainees;
	}
	public void setTrainees(String trainees) {
		this.trainees = trainees;
	}
	
}
