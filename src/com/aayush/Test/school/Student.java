package com.aayush.Test.school;

import java.util.List;

public interface Student {
	public void saveStudentInfo(StudentVar studentVar);
	public List<StudentVar> getStudentInfo();
	public void deleteStudentInfo(int Id);
	public StudentVar getAllStudentInfo(int id);
	public void updateStudentInfo(StudentVar studentVar);
}
